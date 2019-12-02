package com.ihospital.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import sun.audio.AudioSecurityAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @program: ihospital
 * @description: 实现登录跳转
 * @author: Mr.King
 * @create: 2019-11-24 20:16
 **/

public class LoginSuccessHandle implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String path = httpServletRequest.getContextPath() ;
        String basePath = httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+path+"/";
        if (roles.contains("ROLE_ADMIN")){
            httpServletResponse.sendRedirect(basePath+"pages/all-administrator-patienttable.html");

        } else if (roles.contains("ROLE_PATIENT")){
            httpServletResponse.sendRedirect(basePath+"pages/all-patient-index.html");
        } else if (roles.contains("ROLE_DOCTOR")) {
            httpServletResponse.sendRedirect(basePath+"pages/all-doctor-personalcenter.html");
        } else  {
            httpServletResponse.sendRedirect(basePath+"login.html");
        }

    }
}
