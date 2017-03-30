package com.aco.dao;

import com.aco.model.ConversationRecord;

public interface ConversationRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(ConversationRecord record);

    int insertSelective(ConversationRecord record);

    ConversationRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ConversationRecord record);

    int updateByPrimaryKey(ConversationRecord record);
}