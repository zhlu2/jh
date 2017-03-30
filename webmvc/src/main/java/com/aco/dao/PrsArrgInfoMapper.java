package com.aco.dao;

import com.aco.model.PrsArrgInfo;

public interface PrsArrgInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PrsArrgInfo record);

    int insertSelective(PrsArrgInfo record);

    PrsArrgInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PrsArrgInfo record);

    int updateByPrimaryKey(PrsArrgInfo record);
}