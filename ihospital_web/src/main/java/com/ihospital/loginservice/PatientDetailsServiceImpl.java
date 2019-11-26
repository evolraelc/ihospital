package com.ihospital.loginservice;

import com.ihospital.mapper.PatientMapper;
import com.ihospital.pojo.Patient;
import com.ihospital.pojo.PatientExample;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ihospital
 * @description: 自定义认证类
 * @author: Mr.King
 * @create: 2019-11-24 19:27
 **/

public class PatientDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
        PatientExample patientExample = new PatientExample();
        PatientExample.Criteria criteria = patientExample.createCriteria();
        criteria.andPhoneNumberEqualTo(s);
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        if(!patients.isEmpty()){
            if (patients.get(0).getPwd()==null){
                return new User(s,"123456", grantedAuthorities);
            } else{
                return new User(s,patients.get(0).getPwd(), grantedAuthorities);
            }

        } else{
            return null;
        }

    }
}
