package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.DedrugBasicInfoMapper;
import com.aco.dao.JuryRegisMapper;
import com.aco.model.DedrugBasicInfo;
import com.aco.model.JuryRegis;
import com.aco.service.DedrugBasicInfoService;
import com.aco.service.JuryRegisService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("juryRegisService")
public class JuryRegisServiceImpl implements JuryRegisService {
	@Autowired
	private JuryRegisMapper juryRegisMapper;

	@Override
	public PagedResult<JuryRegis> queryByPage(String id, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(juryRegisMapper.selectByPrimaryKey(id));
	}

	@Override
	public String addJuryRegis(JuryRegis juryRegis) {
		// TODO Auto-generated method stub
		juryRegisMapper.insertSelective(juryRegis);
		return null;
	}

	@Override
	public String editJuryRegis(JuryRegis juryRegis) {
		// TODO Auto-generated method stub
		juryRegisMapper.updateByPrimaryKeySelective(juryRegis);
		return null;
	}

	@Override
	public List<JuryRegis> findJuryRegis(String id) {
		// TODO Auto-generated method stub
		return juryRegisMapper.selectByPrimaryKey(id);
	}

	@Override
	public String deleteJuryRegis(String id) {
		// TODO Auto-generated method stub
		juryRegisMapper.deleteByPrimaryKey(id);
		return null;
	}

}
