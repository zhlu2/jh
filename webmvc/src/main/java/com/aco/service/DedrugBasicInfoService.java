package com.aco.service;

import java.util.List;

import com.aco.model.DedrugBasicInfo;
import com.aco.util.PagedResult;

public interface DedrugBasicInfoService {
	
	PagedResult<DedrugBasicInfo> queryByPage(String userName,Integer pageNo,Integer pageSize);

	String addDedrugBasicInfo(DedrugBasicInfo dedrugBasicInfo);
	
	String editDedrugBasicInfo(DedrugBasicInfo dedrugBasicInfo);
	
	String deleteDedrugBasicInfo(String id);
	
	List<DedrugBasicInfo> findDedrugBasicInfo(String id);
}
