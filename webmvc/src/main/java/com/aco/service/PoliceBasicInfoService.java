package com.aco.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.PoliceBasicInfo;
import com.aco.util.PagedResult;

public interface PoliceBasicInfoService {

	PagedResult<PoliceBasicInfo> queryByPage(String Id,Integer pageNo,Integer pageSize);
	
	String addPoliceBasicInfo(PoliceBasicInfo policeBasicInfo);
	
	String editPoliceBasicInfo(PoliceBasicInfo policeBasicInfo);
	
	String deletePoliceBasicInfo(String id);
	
	List<PoliceBasicInfo> findPolice(String id);
	
	String findPoliceNum();
}
