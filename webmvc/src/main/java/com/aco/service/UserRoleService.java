package com.aco.service;

import com.aco.model.user_role;

public interface UserRoleService {

	String addUserRole(String userId,String roleId);
	
	String deleteUserRole(String userId, String roleId);
}
