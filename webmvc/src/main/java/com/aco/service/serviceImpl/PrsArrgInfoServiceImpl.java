package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.DedrugBasicInfoMapper;
import com.aco.dao.PrsArrgInfoMapper;
import com.aco.model.DedrugBasicInfo;
import com.aco.model.PrsArrgInfo;
import com.aco.service.DedrugBasicInfoService;
import com.aco.service.PrsArrgInfoService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("prsArrgInfoService")
public class PrsArrgInfoServiceImpl implements PrsArrgInfoService {
	@Autowired
	private PrsArrgInfoMapper prsArrgInfoMapper;

	@Override
	public PagedResult<PrsArrgInfo> queryByPage(String id, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(prsArrgInfoMapper.selectByPrimaryKey(id));
	}

	@Override
	public String addPrsArrgInfo(PrsArrgInfo prsArrgInfo) {
		// TODO Auto-generated method stub
		prsArrgInfoMapper.insertSelective(prsArrgInfo);
		return null;
	}

	@Override
	public String editPrsArrgInfo(PrsArrgInfo prsArrgInfo) {
		// TODO Auto-generated method stub
		prsArrgInfoMapper.updateByPrimaryKeySelective(prsArrgInfo);
		return null;
	}

	@Override
	public List<PrsArrgInfo> findPrsArrgInfo(String id) {
		// TODO Auto-generated method stub
		return prsArrgInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public String deletePrsArrgInfo(String id) {
		// TODO Auto-generated method stub
		prsArrgInfoMapper.deleteByPrimaryKey(id);
		return null;
	}

}
