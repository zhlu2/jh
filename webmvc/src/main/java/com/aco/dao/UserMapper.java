package com.aco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User findUserByUsername(@Param("username") String username);
    
    User findUserByUserId(@Param("id")String id);
}