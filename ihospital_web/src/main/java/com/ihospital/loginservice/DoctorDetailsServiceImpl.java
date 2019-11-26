package com.ihospital.loginservice;

import com.ihospital.mapper.PatientMapper;
import com.ihospital.mapper.PhysicianMapper;
import com.ihospital.pojo.Patient;
import com.ihospital.pojo.PatientExample;
import com.ihospital.pojo.Physician;
import com.ihospital.pojo.PhysicianExample;
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
 * @create: 2019-11-24 19:16
 **/

public class DoctorDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PhysicianMapper physicianMapper;

    @Autowired
    private PatientMapper patientMapper;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));


        Physician physician = physicianMapper.selectByPrimaryKey(Long.valueOf(username));
        if (physician!=null){
            if (physician.getPwd()==null){
                return new User(username,"123456", grantedAuthorities);
            } else{
                return new User(username,physician.getPwd(), grantedAuthorities);
            }

        } else {
            List<GrantedAuthority> grantedAuthorities2 = new ArrayList<>();
            grantedAuthorities2.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
            PatientExample patientExample = new PatientExample();
            PatientExample.Criteria criteria = patientExample.createCriteria();
            criteria.andPhoneNumberEqualTo(username);
            List<Patient> patients = patientMapper.selectByExample(patientExample);
            if(!patients.isEmpty()){
                if (patients.get(0).getPwd()==null){
                    return new User(username,"123456", grantedAuthorities2);
                } else{
                    return new User(username,patients.get(0).getPwd(), grantedAuthorities2);
                }

            } else{
                return null;
            }
        }

    }
}
