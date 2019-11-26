package com.ihospital.service.impl;

import com.ihospital.mapper.ReplyMapper;
import com.ihospital.pojo.Reply;
import com.ihospital.pojo.ReplyExample;
import com.ihospital.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<Reply> getReplyList(Long consultId) {
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        criteria.andConsultIdEqualTo(consultId);
        criteria.andParentIdIsNull();
        Reply first =  replyMapper.selectByExample(example).get(0);
        List<Reply> orderedList = new ArrayList<>();
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
}
