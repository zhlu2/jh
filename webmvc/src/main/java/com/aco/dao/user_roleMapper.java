package com.aco.dao;

import com.aco.model.user_role;
import java.math.BigDecimal;

public interface user_roleMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(user_role record);

    int insertSelective(user_role record);

    user_role selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(user_role record);

    int updateByPrimaryKey(user_role record);
}