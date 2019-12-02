package com.ihospital.service;

import com.ihospital.pojo.Consultation;
import entity.CommentItem;
import entity.PageResult;

import java.util.List;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/19 16:29
 * @description 评论服务接口
 * @project ihospital
 */
public interface ICommentService {
    /**
     * 获取所有评论
     * @return 评论列表
     */
    List<CommentItem> findAll();

    /**
     * 根据页码获取评论列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return 分页结果
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 删除对应的评论
     * @param ids 评论的id
     */
    void deleteComments(Long[] ids);

    /**
     * 获取对应的评论实体
     * @param id 评论id
     * @return 评论实体
     */
    CommentItem getCommentById(Long id);

    /**
     * 条件查询
     * @param commentItem 评论条件
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return 分页结果
     */
    PageResult findPage(CommentItem commentItem, int pageNum, int pageSize);

    /**
     * 添加评论
     * @param consultation 新评论
     */
    void addComment(Consultation consultation);
}
