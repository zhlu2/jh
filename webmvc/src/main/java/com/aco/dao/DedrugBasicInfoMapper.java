package com.aco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.DedrugBasicInfo;

public interface DedrugBasicInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DedrugBasicInfo record);

    int insertSelective(DedrugBasicInfo record);

    List<DedrugBasicInfo> selectByPrimaryKey(@Param("id")String id);
    
    List<DedrugBasicInfo> selectIntalkByPrimaryKey(@Param("id")String id);
    
    List<DedrugBasicInfo> selectByDelete(@Param("id")String id);
    
    List<DedrugBasicInfo> selectByOut(@Param("id")String id);
    
    List<DedrugBasicInfo> selectInPrison(@Param("id")String id);
    
    List<DedrugBasicInfo> selectInPrisonTalk(@Param("id")String id);
    
    DedrugBasicInfo selectByFullname(@Param("fullname")String fullname);

    int updateByPrimaryKeySelective(DedrugBasicInfo record);

    int updateByPrimaryKey(DedrugBasicInfo record);
}