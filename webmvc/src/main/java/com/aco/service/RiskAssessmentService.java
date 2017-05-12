package com.aco.service;

import java.util.List;

import com.aco.model.RiskAssessment;
import com.aco.util.PagedResult;

public interface RiskAssessmentService {
	
	PagedResult<RiskAssessment> queryByPage(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<RiskAssessment> queryByPageForRiskDepartmentList(String userName,Integer pageNo,Integer pageSize);
	
	PagedResult<RiskAssessment> queryByPageForDirector(String userName,Integer pageNo,Integer pageSize);

	String addRiskAssessment(RiskAssessment riskAssessment);
	
	String editRiskAssessment(RiskAssessment riskAssessment);
	
	String deleteRiskAssessment(String id);
	
	List<RiskAssessment> findRiskAssessment(String id);
}
