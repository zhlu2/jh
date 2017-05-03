package com.aco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.ConversationRecord;

public interface ConversationRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(ConversationRecord record);

    int insertSelective(ConversationRecord record);

    List<ConversationRecord> selectByPrimaryKey(@Param("id")String id);
    
    List<ConversationRecord> selectInprisonByPrimaryKey(@Param("id")String id);
    
    List<ConversationRecord> selectOutprisonByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(ConversationRecord record);

    int updateByPrimaryKey(ConversationRecord record);
}