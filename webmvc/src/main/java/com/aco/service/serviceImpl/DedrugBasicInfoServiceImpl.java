package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.DedrugBasicInfoMapper;
import com.aco.model.DedrugBasicInfo;
import com.aco.service.DedrugBasicInfoService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("dedrugBasicInfoService")
public class DedrugBasicInfoServiceImpl implements DedrugBasicInfoService {
	@Autowired
	private DedrugBasicInfoMapper dedrugBasicInfoMapper;

	@Override
	public PagedResult<DedrugBasicInfo> queryByPage(String id, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(dedrugBasicInfoMapper.selectByPrimaryKey(id));
	}

	@Override
	public String addDedrugBasicInfo(DedrugBasicInfo dedrugBasicInfo) {
		// TODO Auto-generated method stub
		dedrugBasicInfoMapper.insertSelective(dedrugBasicInfo);
		return null;
	}

	@Override
	public String editDedrugBasicInfo(DedrugBasicInfo dedrugBasicInfo) {
		// TODO Auto-generated method stub
		dedrugBasicInfoMapper.updateByPrimaryKeySelective(dedrugBasicInfo);
		return null;
	}

	@Override
	public List<DedrugBasicInfo> findDedrugBasicInfo(String id) {
		// TODO Auto-generated method stub
		return dedrugBasicInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public String deleteDedrugBasicInfo(String id) {
		// TODO Auto-generated method stub
		dedrugBasicInfoMapper.deleteByPrimaryKey(id);
		return null;
	}

}
