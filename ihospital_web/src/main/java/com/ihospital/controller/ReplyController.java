package com.ihospital.controller;

import com.ihospital.pojo.Reply;
import com.ihospital.service.IReplyService;

import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/21 15:56
 * @description
 * @project ihospital
 */

@RestController
@RequestMapping(path = "/reply")
public class ReplyController {
    @Autowired
    private IReplyService replyService;

    @RequestMapping(path = "/findAll.do")
    public List<Reply> findAll(Long consultId) {
        return replyService.getReplyList(consultId);
    }

    @RequestMapping(path = "/addReply.do")
    public Result addReply(@RequestBody Reply reply) {
         try {
             replyService.addReply(reply);
             return new Result(true, "回复成功");
         }
         catch (Exception e){
             e.printStackTrace();
             return new Result(false, e.getMessage());
         }
    }

}
