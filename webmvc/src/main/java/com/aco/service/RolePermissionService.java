package com.aco.service;

import com.aco.model.RolePermission;

public interface RolePermissionService {

	String addRolePermission(RolePermission rolepermission);
	
	String deleteRolePermission(String id);
}
