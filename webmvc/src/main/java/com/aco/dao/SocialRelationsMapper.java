package com.aco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.SocialRelations;

public interface SocialRelationsMapper {
    int deleteByPrimaryKey(String id);

    int insert(SocialRelations record);

    int insertSelective(SocialRelations record);

    List<SocialRelations> selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(SocialRelations record);

    int updateByPrimaryKey(SocialRelations record);
}