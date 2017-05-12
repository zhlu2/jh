package com.aco.service.serviceImpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
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
	@Autowired
	private DedrugBasicInfoMapper dedrugBasicInfoMapper;

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
		if (StringUtils.isNotBlank(conversationRecord.getFullname())) {
			DedrugBasicInfo dedrugBasicInfo = dedrugBasicInfoMapper.selectByFullname(conversationRecord.getFullname());
			dedrugBasicInfo.setPersonsign("0");
			dedrugBasicInfoMapper.updateByPrimaryKeySelective(dedrugBasicInfo);
		}
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

	@Override
	public PagedResult<ConversationRecord> queryByPageForInPrison(String userName, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(conversationRecordMapper.selectInprisonByPrimaryKey(userName));
	}

	@Override
	public PagedResult<ConversationRecord> queryByPageForOutPrison(String userName, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(conversationRecordMapper.selectOutprisonByPrimaryKey(userName));
	}

	@Override
	public String addOutPrisonConversationRecord(ConversationRecord conversationRecord) {
		// TODO Auto-generated method stub
		conversationRecordMapper.insertSelective(conversationRecord);
		if (StringUtils.isNotBlank(conversationRecord.getFullname())) {
			DedrugBasicInfo dedrugBasicInfo = dedrugBasicInfoMapper.selectByFullname(conversationRecord.getFullname());
			dedrugBasicInfo.setPersonsign("4");
			dedrugBasicInfoMapper.updateByPrimaryKeySelective(dedrugBasicInfo);
		}
		return null;
	}

}
