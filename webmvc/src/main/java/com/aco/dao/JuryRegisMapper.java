package com.aco.dao;

import com.aco.model.JuryRegis;

public interface JuryRegisMapper {
    int deleteByPrimaryKey(String id);

    int insert(JuryRegis record);

    int insertSelective(JuryRegis record);

    JuryRegis selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JuryRegis record);

    int updateByPrimaryKey(JuryRegis record);
}