package com.aco.service;

import java.util.List;

import com.aco.model.DedrugBasicInfo;
import com.aco.model.SocialRelations;
import com.aco.util.PagedResult;

public interface SocialRelationsService {
	
	PagedResult<SocialRelations> queryByPage(String userName,Integer pageNo,Integer pageSize);

	String addSocialRelations(SocialRelations socialRelations);
	
	String editSocialRelations(SocialRelations socialRelations);
	
	String deleteSocialRelations(String id);
	
	List<SocialRelations> findSocialRelations(String id);
}
