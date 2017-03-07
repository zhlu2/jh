package com.aco.dao;

import com.aco.model.RolePermission;
import java.math.BigDecimal;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}