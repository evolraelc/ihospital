package com.ihospital.controller;

import com.ihospital.service.ICommentService;
import entity.CommentItem;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/19 19:43
 * @description 评论控制层
 * @project ihospital
 */

@RestController
@RequestMapping(path = "/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @RequestMapping(path = "/findAll.do")
    public List<CommentItem> findAll() {
        return commentService.findAll();
    }

    @RequestMapping(path = "/findPage.do")
    public PageResult findPage(int pageNum, int pageSize) {
        return commentService.findPage(pageNum, pageSize);
    }

    @RequestMapping(path = "/deleteComment.do")
    public Result deleteComments(Long[] ids) {
        try{
            commentService.deleteComments(ids);
            return new Result(true, "Delete Success");
        }catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(path = "/getComment.do")
    public CommentItem getConsultation(Long id) {
        return commentService.getCommentById(id);
    }

    @RequestMapping(path = "/searchComment.do")
    public PageResult searchComment(@RequestBody CommentItem commentItem, int pageNum, int pageSize) {
        return commentService.findPage(commentItem, pageNum, pageSize);
    }
}
