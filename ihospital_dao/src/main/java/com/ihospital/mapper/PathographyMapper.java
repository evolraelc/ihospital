package com.ihospital.mapper;

import com.ihospital.pojo.Pathography;
import com.ihospital.pojo.PathographyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PathographyMapper {
    int countByExample(PathographyExample example);

    int deleteByExample(PathographyExample example);

    int deleteByPrimaryKey(Long pathoId);

    int insert(Pathography record);

    int insertSelective(Pathography record);

    List<Pathography> selectByExample(PathographyExample example);

    Pathography selectByPrimaryKey(Long pathoId);

    int updateByExampleSelective(@Param("record") Pathography record, @Param("example") PathographyExample example);

    int updateByExample(@Param("record") Pathography record, @Param("example") PathographyExample example);

    int updateByPrimaryKeySelective(Pathography record);

    int updateByPrimaryKey(Pathography record);
}