package com.aco.service;

import com.aco.model.Permission;
import com.aco.util.PagedResult;

public interface PermissionService {

	String addPermission(Permission permission);
	
	String editPermission(Permission permission);
	
	String deletePermission(String id);
	
	PagedResult<Permission> queryByPage(String userName,Integer pageNo,Integer pageSize);
}
