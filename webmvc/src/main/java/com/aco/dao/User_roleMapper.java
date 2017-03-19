package com.aco.dao;

import com.aco.model.user_role;

public interface User_roleMapper {
    int deleteByPrimaryKey(String id);

    int insert(user_role record);

    int insertSelective(user_role record);

    user_role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(user_role record);

    int updateByPrimaryKey(user_role record);
}