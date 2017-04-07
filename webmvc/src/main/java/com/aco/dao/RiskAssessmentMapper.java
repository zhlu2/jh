package com.aco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aco.model.RiskAssessment;

public interface RiskAssessmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(RiskAssessment record);

    int insertSelective(RiskAssessment record);

    List<RiskAssessment> selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(RiskAssessment record);

    int updateByPrimaryKey(RiskAssessment record);
}