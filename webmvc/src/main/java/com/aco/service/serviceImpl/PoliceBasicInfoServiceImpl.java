package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.PoliceBasicInfoMapper;
import com.aco.model.PoliceBasicInfo;
import com.aco.service.PoliceBasicInfoService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("policeBasicInfoService")
public class PoliceBasicInfoServiceImpl implements PoliceBasicInfoService {

	@Autowired
	private PoliceBasicInfoMapper policeBasicInfoMapper;
	@Override
	public PagedResult<PoliceBasicInfo> queryByPage(String id, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(policeBasicInfoMapper.selectByPrimaryKey(id));
	}
	
	@Override
	public String addPoliceBasicInfo(PoliceBasicInfo policeBasicInfo) {
		// TODO Auto-generated method stub
		policeBasicInfoMapper.insertSelective(policeBasicInfo);
		return policeBasicInfo.getId();
	}

	@Override
	public String deletePoliceBasicInfo(String id) {
		// TODO Auto-generated method stub
		policeBasicInfoMapper.deleteByPrimaryKey(id);
		return null;
	}

	@Override
	public List<PoliceBasicInfo> findPolice(String id) {
		// TODO Auto-generated method stub
		return policeBasicInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public String editPoliceBasicInfo(PoliceBasicInfo policeBasicInfo) {
		// TODO Auto-generated method stub
		policeBasicInfoMapper.updateByPrimaryKeySelective(policeBasicInfo);
		return null;
	}
	
}
