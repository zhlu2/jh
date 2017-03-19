package com.aco.service;

import java.util.List;

import com.aco.model.Role;
import com.aco.util.PagedResult;

public interface RoleService {
   
	String addRole(Role role);
	
	String editRole(Role role);
	
	String deleteRole(String id);
	
	PagedResult<Role> queryByPage(String userName,Integer pageNo,Integer pageSize); 
	
	List<Role> findRole(String id);
}
