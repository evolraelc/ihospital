package com.ihospital.mapper;

import com.ihospital.pojo.Physician;
import com.ihospital.pojo.PhysicianExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhysicianMapper {
    int countByExample(PhysicianExample example);

    int deleteByExample(PhysicianExample example);

    int deleteByPrimaryKey(Long physicianId);

    int insert(Physician record);

    int insertSelective(Physician record);

    List<Physician> selectByExample(PhysicianExample example);

    Physician selectByPrimaryKey(Long physicianId);

    int updateByExampleSelective(@Param("record") Physician record, @Param("example") PhysicianExample example);

    int updateByExample(@Param("record") Physician record, @Param("example") PhysicianExample example);

    int updateByPrimaryKeySelective(Physician record);

    int updateByPrimaryKey(Physician record);
}