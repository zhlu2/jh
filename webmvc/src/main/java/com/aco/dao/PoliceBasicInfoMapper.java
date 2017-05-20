package com.aco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.PoliceBasicInfo;

public interface PoliceBasicInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PoliceBasicInfo record);

    int insertSelective(PoliceBasicInfo record);

    List<PoliceBasicInfo> selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(PoliceBasicInfo record);

    int updateByPrimaryKey(PoliceBasicInfo record);
    
    String selectPoliceNum();
}