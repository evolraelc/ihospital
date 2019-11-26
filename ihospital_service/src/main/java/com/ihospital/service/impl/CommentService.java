package com.ihospital.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ihospital.mapper.ConsultationMapper;
import com.ihospital.mapper.PatientMapper;
import com.ihospital.mapper.PhysicianMapper;
import com.ihospital.mapper.ReplyMapper;
import com.ihospital.pojo.*;
import com.ihospital.service.ICommentService;
import entity.CommentItem;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/19 19:40
 * @description 评论服务层
 * @project ihospital
 */

@Service
@Transactional
public class CommentService implements ICommentService {
    @Autowired
    private ConsultationMapper consultationMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PhysicianMapper physicianMapper;
    @Autowired
    private ReplyMapper replyMapper;

    private CommentItem createItem(Consultation consultation) {
        CommentItem commentItem = new CommentItem();
        commentItem.setConsultId(consultation.getConsultId());
        commentItem.setPatientId(consultation.getPatientId());
        commentItem.setPhysicianId(consultation.getPhysicianId());
        commentItem.setCreateTime(consultation.getTime());
        commentItem.setBody(consultation.getBody());
        commentItem.setPatientName(patientMapper.selectByPrimaryKey(consultation.getPatientId()).getPatientName());
        commentItem.setPhysicianName(physicianMapper.selectByPrimaryKey(consultation.getPhysicianId()).getPhysicianName());
        return commentItem;
    }

    private List<CommentItem> createItemList(List<Consultation> consultations) {
        List<CommentItem> commentItems = new ArrayList<>();
        for (Consultation consultation : consultations) {
            commentItems.add(createItem(consultation));
        }
        return commentItems;
    }

    @Override
    public List<CommentItem> findAll() {
        return createItemList(consultationMapper.selectByExample(null));
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Consultation> itemPage = (Page<Consultation>) consultationMapper.selectByExample(null);
        List<CommentItem> itemList = createItemList(itemPage.getResult());
        return new PageResult(itemPage.getTotal(), itemList);
    }

    @Override
    public void deleteComments(Long[] ids) {
        for(long id : ids) {
            consultationMapper.deleteByPrimaryKey(id);
            ReplyExample replyExample = new ReplyExample();
            ReplyExample.Criteria criteria = replyExample.createCriteria();
            criteria.andConsultIdEqualTo(id);
            replyMapper.deleteByExample(replyExample);
        }
    }

    @Override
    public CommentItem getCommentById(Long id) {
        return createItem(consultationMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult findPage(CommentItem commentItem, int pageNum, int pageSize) {
        ConsultationExample example = new ConsultationExample();
        ConsultationExample.Criteria criteria = example.createCriteria();
        if(commentItem != null) {
            if (commentItem.getPatientName() != null && commentItem.getPatientName().length() > 0) {
                PatientExample patientExample = new PatientExample();
                PatientExample.Criteria patientExampleCriteria = patientExample.createCriteria();
                patientExampleCriteria.andPatientNameLike("%" + commentItem.getPatientName() + "%");
                List<Patient> patients = patientMapper.selectByExample(patientExample);
                List<Long> patientIds = new ArrayList<>();
                patientIds.add(0L);
                for (Patient patient : patients) {
                    if (!patientIds.contains(patient.getPatientId())) {
                        patientIds.add(patient.getPatientId());
                    }
                }
                PhysicianExample physicianExample = new PhysicianExample();
                PhysicianExample.Criteria physicianExampleCriteria = physicianExample.createCriteria();
                physicianExampleCriteria.andPhysicianNameLike("%" + commentItem.getPhysicianName() + "%");
                List<Physician> physicians = physicianMapper.selectByExample(physicianExample);
                List<Long> physicianIds = new ArrayList<>();
                physicianIds.add(0L);
                for (Physician physician : physicians) {
                    if (!physicianIds.contains(physician.getPhysicianId())) {
                        physicianIds.add(physician.getPhysicianId());
                    }
                }
                if (commentItem.getCreateTime() != null) {
                    Date minDate = new Date(commentItem.getCreateTime().getTime() / 86400000L * 86400000L - 8 * 3600000);
                    Date maxDate = new Date(minDate.getTime() + 86399000L);
                    example.or().andTimeBetween(minDate, maxDate).andPatientIdIn(patientIds);
                    example.or().andTimeBetween(minDate, maxDate).andPhysicianIdIn(physicianIds);
                } else {
                    example.or().andPatientIdIn(patientIds);
                    example.or().andPhysicianIdIn(physicianIds);
                }
            }
            else if(commentItem.getCreateTime() != null) {
                Date minDate = new Date(commentItem.getCreateTime().getTime() / 86400000L * 86400000L - 8 * 3600000);
                Date maxDate = new Date(minDate.getTime() + 86399000L);
                criteria.andTimeBetween(minDate, maxDate);
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        Page<Consultation> page = (Page<Consultation>) consultationMapper.selectByExample(example);
        List<CommentItem> items = createItemList(page.getResult());
        return new PageResult(page.getTotal(), items);
    }
}
