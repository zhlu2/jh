package com.aco.service;

import java.util.Date;
import java.util.List;

import com.aco.model.Role;
import com.aco.util.PagedResult;

public interface RoleService {
   
	String addRole(String permissionId,String roleName,String roleSign,String description,Date creatTime);
	
	String editRole(Role role);
	
	String deleteRole(String id);
	
	PagedResult<Role> queryByPage(String userName,Integer pageNo,Integer pageSize); 
	
	List<Role> findRole(String id);
}
