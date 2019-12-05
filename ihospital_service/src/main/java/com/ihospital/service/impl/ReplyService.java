package com.ihospital.service.impl;

import com.ihospital.mapper.ConsultationMapper;
import com.ihospital.mapper.ReplyMapper;
import com.ihospital.pojo.Consultation;
import com.ihospital.pojo.Reply;
import com.ihospital.pojo.ReplyExample;
import com.ihospital.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/21 15:52
 * @description 回复服务层实现
 * @project ihospital
 */

@Service
@Transactional
public class ReplyService implements IReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public List<Reply> getReplyList(Long consultId) {
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        criteria.andConsultIdEqualTo(consultId);
        criteria.andParentIdIsNull();
        List<Reply> orderedList = new ArrayList<>();
        List<Reply> list = replyMapper.selectByExample(example);
        if(list.isEmpty()) {
            return orderedList;
        }
        Reply first =  list.get(0);
        orderedList.add(first);
        Reply current = first;
        while(current.getChildId() != null) {
            current = getReplyById(current.getChildId());
            orderedList.add(current);
        }
        return orderedList;
    }

    @Override
    public Reply getReplyById(Long id) {
        return replyMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addReply(Reply reply) {
        reply.setTime(new Date());
        List<Reply> list = getReplyList(reply.getConsultId());
        Consultation consultation = consultationMapper.selectByPrimaryKey(reply.getConsultId());
        if(list.isEmpty()) {
            replyMapper.insertSelective(reply);
            consultation.setReplyCount(1);
            consultation.setLastReplyId(reply.getReplyId());
            consultationMapper.updateByPrimaryKey(consultation);
            return;
        }
        Reply last = list.get(list.size() - 1);
        reply.setParentId(last.getReplyId());
        replyMapper.insertSelective(reply);
        last.setChildId(reply.getReplyId());
        this.updateReply(last);
        consultation.setReplyCount(consultation.getReplyCount() + 1);
        consultation.setLastReplyId(reply.getReplyId());
        consultationMapper.updateByPrimaryKey(consultation);
    }

    @Override
    public void updateReply(Reply reply) {
        replyMapper.updateByPrimaryKeySelective(reply);
    }


}
