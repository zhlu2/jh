package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.DedrugBasicInfoMapper;
import com.aco.dao.SocialRelationsMapper;
import com.aco.model.DedrugBasicInfo;
import com.aco.model.SocialRelations;
import com.aco.service.DedrugBasicInfoService;
import com.aco.service.SocialRelationsService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("socialRelationsService")
public class SocialRelationsServiceImpl implements SocialRelationsService {
	@Autowired
	private SocialRelationsMapper socialRelationsMapper;

	@Override
	public PagedResult<SocialRelations> queryByPage(String id, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(socialRelationsMapper.selectByPrimaryKey(id));
	}

	@Override
	public String addSocialRelations(SocialRelations socialRelations) {
		// TODO Auto-generated method stub
		socialRelationsMapper.insertSelective(socialRelations);
		return null;
	}

	@Override
	public String editSocialRelations(SocialRelations socialRelations) {
		// TODO Auto-generated method stub
		socialRelationsMapper.updateByPrimaryKeySelective(socialRelations);
		return null;
	}

	@Override
	public List<SocialRelations> findSocialRelations(String id) {
		// TODO Auto-generated method stub
		return socialRelationsMapper.selectByPrimaryKey(id);
	}

	@Override
	public String deleteSocialRelations(String id) {
		// TODO Auto-generated method stub
		socialRelationsMapper.deleteByPrimaryKey(id);
		return null;
	}

}
