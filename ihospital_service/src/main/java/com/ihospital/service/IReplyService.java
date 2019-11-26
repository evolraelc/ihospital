package com.ihospital.service;

import com.ihospital.pojo.Reply;

import java.util.List;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/21 15:50
 * @description 回复服务接口
 * @project ihospital
 */
public interface IReplyService {
    /**
     * 获取回复列表
     * @param consultId 评论id
     * @return 对应回复列表
     */
    List<Reply> getReplyList(Long consultId);

    /**
     * 获取回复
     * @param id 回复id
     * @return 对应回复
     */
    Reply getReplyById(Long id);
}
