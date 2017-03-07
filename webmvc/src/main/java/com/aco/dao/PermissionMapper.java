package com.aco.dao;

import com.aco.model.Permission;
import java.math.BigDecimal;

public interface PermissionMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}