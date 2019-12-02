package com.ihospital.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ihospital.pojo.Department;
import com.ihospital.pojo.JsonParam;
import com.ihospital.pojo.Physician;
import com.ihospital.service.IDepartmentService;
import com.ihospital.service.IPhysicianService;
import entity.MyException;
import entity.PageResult;
import entity.Result;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/doctor")
public class PhysicianController {
//    private static Logger logger = LoggerFactory.getLogger(PhysicianController.class);

    Logger logger = Logger.getLogger(PhysicianController.class);

    @Autowired
    private IPhysicianService physicianService;

    @ResponseBody
    @RequestMapping("/findPage.do")
    public PageResult findPage(int page, int size) {
        return physicianService.findPage(page, size);
    }


    @ResponseBody
    @RequestMapping("/addPhysician.do")
    public Result addPhysician(@RequestBody JsonParam jsondata){
        BasicConfigurator.configure();

        logger.setLevel(Level.INFO);

        logger.warn("mylog");
        try {


            logger.warn("myjson3"+jsondata.toString());
            logger.warn("myjson3"+jsondata.getData().toString());
            String[] data = jsondata.getData().split("&");
            logger.warn("mydata"+data.toString());
            if (data.length!=2){
                throw new MyException("error:parameters failure");
            }
            logger.warn("mydata"+data.toString());

            Department department = null;
            Physician physician = null;

            try {
                ObjectMapper mapper = new ObjectMapper();

                logger.warn("mylog");
                logger.warn(data[0]);
                logger.warn(data[1]);

                physician = mapper.readValue(data[0], Physician.class);
                department = mapper.readValue(data[1], Department.class);

            } catch (JsonParseException e) {
                logger.warn(e.toString());
            } catch (JsonMappingException e) {
                logger.warn(e.toString());
            } catch (IOException e) {
                logger.warn(e.toString());
            };


            logger.warn("mapper works");
            Long departId = physicianService.departNameToId( department.getDepartName() );
            logger.warn("departId works");
            if (departId==null)
                throw new MyException("error:department not found");
            logger.warn("departId not null");
            physician.setDepartId(departId);
            physician.setDepartName(department.getDepartName());
            physicianService.addPhysician(physician);
            logger.warn("should not appear");
            return new Result(true, "Add Success");
        } catch (Exception e) {
            logger.error(e.toString());
            return new Result(false, e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/searchPhysician.do")
    public PageResult searchPhysician(@RequestBody Physician physician, int page, int size) {
        return physicianService.findPage(physician, page, size);
    }


    @RequestMapping("/deletePhysicians.do")
    public Result deletePhysicians(Long[] ids){
        try{
            physicianService.deletePhysicians(ids);
            return new Result(true,"success");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"failure");
        }
    }

    @RequestMapping("/findOne.do")
    public Physician findOnePhysician(Long id){
        return physicianService.findOnePhysician(id);
    }

    @RequestMapping("/updatePhysician.do")
    public Result updatePhysician(@RequestBody String jsondata){
        try{
            String[] data = jsondata.split("&");
            if (data.length!=2){
                throw new MyException("error:parameters failure");
            }

            ObjectMapper mapper = new ObjectMapper();
            Department department = null;
            Physician physician = null;

            physician = mapper.readValue(data[0],Physician.class);
            department = mapper.readValue(data[1],Department.class);

            Long departId = physicianService.departNameToId( department.getDepartName() );
            if (departId==null)
                throw new MyException("error:department not found");
            physician.setDepartId(departId);
            physicianService.updatePhysician(physician);
            return new Result(true,"success");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"failure");
        }
    }






}



