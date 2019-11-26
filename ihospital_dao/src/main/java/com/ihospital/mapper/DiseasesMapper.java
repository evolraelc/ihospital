package com.ihospital.mapper;

import com.ihospital.pojo.Diseases;
import com.ihospital.pojo.DiseasesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiseasesMapper {
    int countByExample(DiseasesExample example);

    int deleteByExample(DiseasesExample example);

    int deleteByPrimaryKey(Long diseaseId);

    int insert(Diseases record);

    int insertSelective(Diseases record);

    List<Diseases> selectByExample(DiseasesExample example);

    Diseases selectByPrimaryKey(Long diseaseId);

    int updateByExampleSelective(@Param("record") Diseases record, @Param("example") DiseasesExample example);

    int updateByExample(@Param("record") Diseases record, @Param("example") DiseasesExample example);

    int updateByPrimaryKeySelective(Diseases record);

    int updateByPrimaryKey(Diseases record);
}