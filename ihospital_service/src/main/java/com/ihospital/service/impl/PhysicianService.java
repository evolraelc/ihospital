package com.ihospital.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ihospital.mapper.DepartmentMapper;
import com.ihospital.mapper.PhysicianMapper;
import com.ihospital.pojo.Department;
import com.ihospital.pojo.DepartmentExample;
import com.ihospital.pojo.Physician;
import com.ihospital.pojo.PhysicianExample;
import com.ihospital.service.IPhysicianService;
import entity.MyException;
import entity.PageResult;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicianService implements IPhysicianService {

    Logger logger = Logger.getLogger(PhysicianService.class);

    @Autowired
    PhysicianMapper physicianMapper;

    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public PageResult findPage(Physician physician, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        PhysicianExample physicianExample = new PhysicianExample();
        PhysicianExample.Criteria criteria= physicianExample.createCriteria();

//        filter criteria
        if (physician!=null){
            if (physician.getDepartId()!=null&&physician.getDepartId()>=0&& physician.getDepartName()==null){
                criteria.andDepartIdEqualTo(physician.getDepartId());
            }
            if (physician.getDepartName()!=null&&physician.getDepartName().length()>0){
                criteria.andDepartNameLike("%"+physician.getDepartName()+"%");
            }
            if (physician.getPhysicianId()!=null && physician.getPhysicianId()>0){
                criteria.andPhysicianIdEqualTo(physician.getDepartId());
            }
            if (physician.getPhysicianName()!=null && physician.getPhysicianName().length()>0){
                criteria.andPhysicianNameLike("%"+physician.getPhysicianName()+"%");
            }
        }

        Page<Physician> physicians = (Page<Physician>) physicianMapper.selectByExample(physicianExample);
        return new PageResult(physicians.getTotal(), physicians.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //分页，调用插件
        PageHelper.startPage(pageNum, pageSize);
        Page<Physician> physicianPage = (Page<Physician>) physicianMapper.selectByExample(null);
        return new PageResult(physicianPage.getTotal(), physicianPage.getResult());
    }

    @Override
    public void deletePhysicians(Long[] ids) {
        for (Long id: ids){
            physicianMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Physician findOnePhysician(Long id) {
        return physicianMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updatePhysician(Physician physician) {
        physicianMapper.updateByPrimaryKey(physician);
    }


    @Override
    public void addPhysician(Physician physician) throws MyException {
        try{
            physicianMapper.insert(physician);
        }catch (Exception e){
            System.out.println("ERROR"+e.toString());
            throw new MyException("ERROR"+e.toString());
        }
    }

    @Override
    public Long departNameToId(String departName) throws MyException {
        BasicConfigurator.configure();
        logger.setLevel(Level.INFO);

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();

        logger.warn("departname"+departName);
        System.out.println("departname"+departName);
        if (departName.length()>0){
            criteria.andDepartNameEqualTo(departName);
        }
        List<Department> departments=departmentMapper.selectByExample(departmentExample); // list of only one item

        logger.warn(departments.toString()+"departments");
        logger.warn("list length"+departments.size());

        if (departments==null || departments.size()==0){
            return null;
        }
        else
            return departments.get(0).getDepartId();
    }
}
