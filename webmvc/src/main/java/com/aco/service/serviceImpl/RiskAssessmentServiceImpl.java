package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.RiskAssessmentMapper;
import com.aco.model.RiskAssessment;
import com.aco.service.RiskAssessmentService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("riskAssessmentService")
public class RiskAssessmentServiceImpl implements RiskAssessmentService {
	@Autowired
	private RiskAssessmentMapper riskAssessmentMapper;

	@Override
	public PagedResult<RiskAssessment> queryByPage(String id, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(riskAssessmentMapper.selectByPrimaryKey(id));
	}

	@Override
	public String addRiskAssessment(RiskAssessment riskAssessment) {
		// TODO Auto-generated method stub
		riskAssessmentMapper.insertSelective(riskAssessment);
		return null;
	}

	@Override
	public String editRiskAssessment(RiskAssessment riskAssessment) {
		// TODO Auto-generated method stub
		riskAssessmentMapper.updateByPrimaryKeySelective(riskAssessment);
		return null;
	}

	@Override
	public List<RiskAssessment> findRiskAssessment(String id) {
		// TODO Auto-generated method stub
		return riskAssessmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public String deleteRiskAssessment(String id) {
		// TODO Auto-generated method stub
		riskAssessmentMapper.deleteByPrimaryKey(id);
		return null;
	}

}
