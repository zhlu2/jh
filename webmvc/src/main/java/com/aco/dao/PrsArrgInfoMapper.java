package com.aco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.PrsArrgInfo;

public interface PrsArrgInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PrsArrgInfo record);

    int insertSelective(PrsArrgInfo record);

    List<PrsArrgInfo> selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(PrsArrgInfo record);

    int updateByPrimaryKey(PrsArrgInfo record);
}