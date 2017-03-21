package com.aco.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.User_roleMapper;
import com.aco.model.user_role;
import com.aco.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
	private User_roleMapper user_roleMapper;
	@Override
	public String addUserRole(String userId, String roleId) {
		// TODO Auto-generated method stub
		String[] roles=roleId.split(",");
		for(String rid:roles){
		user_role userRole=new user_role();
		userRole.setUserId(userId);
		userRole.setRoleId(rid);
		user_roleMapper.insertSelective(userRole);}
		return userId;
	}

	@Override
	public String deleteUserRole(user_role userRole) {
		// TODO Auto-generated method stub
		user_roleMapper.deleteByPrimaryKey(userRole.getId());
		return userRole.getId();
	}

}
