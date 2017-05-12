package com.aco.service;

import java.util.List;

import com.aco.model.DedrugBasicInfo;
import com.aco.util.PagedResult;

public interface DedrugBasicInfoService {
	
	PagedResult<DedrugBasicInfo> queryByPage(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<DedrugBasicInfo> queryDelete(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<DedrugBasicInfo> queryOut(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<DedrugBasicInfo> queryInPrison(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<DedrugBasicInfo> queryInPrisonTalk(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<DedrugBasicInfo> queryIntalk(String userName,Integer pageNo,Integer pageSize);

	String addDedrugBasicInfo(DedrugBasicInfo dedrugBasicInfo);
	
	String editDedrugBasicInfo(DedrugBasicInfo dedrugBasicInfo);
	
	String deleteDedrugBasicInfo(String id);
	
	List<DedrugBasicInfo> findDedrugBasicInfo(String id);
}
