package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.ConversationRecordMapper;
import com.aco.dao.DedrugBasicInfoMapper;
import com.aco.model.ConversationRecord;
import com.aco.model.DedrugBasicInfo;
import com.aco.service.ConversationRecordService;
import com.aco.service.DedrugBasicInfoService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("conversationRecordService")
public class ConversationRecordServiceImpl implements ConversationRecordService {
	@Autowired
	private ConversationRecordMapper conversationRecordMapper;

	@Override
	public PagedResult<ConversationRecord> queryByPage(String id, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(conversationRecordMapper.selectByPrimaryKey(id));
	}

	@Override
	public String addConversationRecord(ConversationRecord conversationRecord) {
		// TODO Auto-generated method stub
		conversationRecordMapper.insertSelective(conversationRecord);
		return null;
	}

	@Override
	public String editConversationRecord(ConversationRecord conversationRecord) {
		// TODO Auto-generated method stub
		conversationRecordMapper.updateByPrimaryKeySelective(conversationRecord);
		return null;
	}

	@Override
	public List<ConversationRecord> findConversationRecord(String id) {
		// TODO Auto-generated method stub
		return conversationRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public String deleteConversationRecord(String id) {
		// TODO Auto-generated method stub
		conversationRecordMapper.deleteByPrimaryKey(id);
		return null;
	}

}
