package com.aco.dao;

import com.aco.model.SocialRelations;

public interface SocialRelationsMapper {
    int deleteByPrimaryKey(String id);

    int insert(SocialRelations record);

    int insertSelective(SocialRelations record);

    SocialRelations selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SocialRelations record);

    int updateByPrimaryKey(SocialRelations record);
}