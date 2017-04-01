package com.aco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.JuryRegis;

public interface JuryRegisMapper {
    int deleteByPrimaryKey(String id);

    int insert(JuryRegis record);

    int insertSelective(JuryRegis record);

    List<JuryRegis> selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(JuryRegis record);

    int updateByPrimaryKey(JuryRegis record);
}