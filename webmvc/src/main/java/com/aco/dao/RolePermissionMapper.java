package com.aco.dao;

import com.aco.model.RolePermission;
import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(String id);
    
    int deleteByRoleId(@Param("roleId")String roleId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}