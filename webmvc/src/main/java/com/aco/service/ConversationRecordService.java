package com.aco.service;

import java.util.List;

import com.aco.model.ConversationRecord;
import com.aco.util.PagedResult;

public interface ConversationRecordService {
	
	PagedResult<ConversationRecord> queryByPage(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<ConversationRecord> queryByPageForInPrison(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<ConversationRecord> queryByPageForOutPrison(String userName,Integer pageNo,Integer pageSize);

	String addConversationRecord(ConversationRecord conversationRecord);
	
	String addOutPrisonConversationRecord(ConversationRecord conversationRecord);
	
	String editConversationRecord(ConversationRecord conversationRecord);
	
	String deleteConversationRecord(String id);
	
	List<ConversationRecord> findConversationRecord(String id);
}
