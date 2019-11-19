package com.ihospital.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ihospital.mapper.MedicineMapper;
import com.ihospital.pojo.Medicine;
import com.ihospital.pojo.MedicineExample;
import com.ihospital.service.IMedicineService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-19-12-52
 **/

@Service
public class MedicineService implements IMedicineService {
    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public List<Medicine> findAll() throws Exception {
        return medicineMapper.selectByExample(null);
    }

    @Override
    public Medicine findOne(Long medicineId) {
        return medicineMapper.selectByPrimaryKey(medicineId);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Medicine> medicines= (Page<Medicine>) medicineMapper.selectByExample(null);
        return new PageResult(medicines.getTotal(),medicines.getResult());
    }

    @Override
    public void add(Medicine medicine){
        medicineMapper.insert(medicine);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids ){
            medicineMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public void update(Medicine medicine) {
        medicineMapper.updateByPrimaryKey(medicine);

    }

    @Override
    public PageResult findPage(Medicine medicine, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        MedicineExample medicineExample = new MedicineExample();

        MedicineExample.Criteria criteria = medicineExample.createCriteria();

        //暂时设为根据名称检索
        if (medicine != null) {
            if (medicine.getMedicineName() != null && medicine.getMedicineName().length() > 0) {
                criteria.andMedicineNameLike("%" + medicine.getMedicineName() + "%");
            }
        }

        Page<Medicine> medicines = (Page<Medicine>) medicineMapper.selectByExample(null);
        return new PageResult(medicines.getTotal(),medicines.getResult());



    }


}




