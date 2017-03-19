package com.aco.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.RolePermissionMapper;
import com.aco.model.RolePermission;
import com.aco.service.RolePermissionService;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
	private RolePermissionMapper rolePermissionMapper;

	@Override
	public String addRolePermission(RolePermission rolepermission) {
		// TODO Auto-generated method stub
		rolePermissionMapper.insertSelective(rolepermission);
		return null;
	}

	@Override
	public String deleteRolePermission(String id) {
		// TODO Auto-generated method stub
		rolePermissionMapper.deleteByPrimaryKey(id);
		return null;
	}
    
    
}
