package com.aco.service;

import java.util.List;

import com.aco.model.PrsArrgInfo;
import com.aco.util.PagedResult;

public interface PrsArrgInfoService {
	
	PagedResult<PrsArrgInfo> queryByPage(String userName,Integer pageNo,Integer pageSize);

	String addPrsArrgInfo(PrsArrgInfo prsArrgInfo);
	
	String editPrsArrgInfo(PrsArrgInfo prsArrgInfo);
	
	String deletePrsArrgInfo(String id);
	
	List<PrsArrgInfo> findPrsArrgInfo(String id);
}
