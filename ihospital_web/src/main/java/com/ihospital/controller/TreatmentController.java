package com.ihospital.controller;

import com.ihospital.pojo.Physician;
import com.ihospital.service.ITreatmentService;
import entity.PageResult;
import entity.PathographySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author RUANBY
 * @date 2019/11/29 22:58
 */
@RestController
@RequestMapping("/treatment")
public class TreatmentController {

    @Autowired
    private ITreatmentService treatmentService;

    @RequestMapping("/search.do")
    public PageResult search(@RequestBody PathographySearch pathographySearch, int page, int size, Long id) throws Exception {
        return treatmentService.findPage(pathographySearch,page, size,id);
    }
    @RequestMapping("/getPhysicianName.do")
    public Physician getPhysicianName(Long id){
        return treatmentService.findOnePhysician(id);
    }



}
