package com.aco.service;

import java.util.List;

import com.aco.model.Role;
import com.aco.model.User;
import com.aco.util.PagedResult;

public interface UserService {

	public User findUserByUsername(String username);
	
	public List<User> findUser(String id);
	
	PagedResult<User> queryByPage(String userName,Integer pageNo,Integer pageSize); 
	
	PagedResult<Role> queryByPageForRole(String id,Integer pageNo,Integer pageSize); 
	
	String addUser(User user);
	
	String updateUser(User user);
	
	String deleteUser(User user);
}
