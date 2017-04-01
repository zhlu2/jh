package com.aco.service;

import java.util.List;

import com.aco.model.JuryRegis;
import com.aco.util.PagedResult;

public interface JuryRegisService {
	
	PagedResult<JuryRegis> queryByPage(String userName,Integer pageNo,Integer pageSize);

	String addJuryRegis(JuryRegis juryRegis);
	
	String editJuryRegis(JuryRegis juryRegis);
	
	String deleteJuryRegis(String id);
	
	List<JuryRegis> findJuryRegis(String id);
}
