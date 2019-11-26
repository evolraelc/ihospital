package com.ihospital.controller;

import org.omg.IOP.ServiceContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: ihospital
 * @description: 登录所用控制器
 * @author: Mr.King
 * @create: 2019-11-24 16:10
 **/


@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/name.do")
    public Map name(){

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map= new HashMap<>();
        map.put("loginName",name);
        return map;

    }




}
