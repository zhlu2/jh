package com.aco.service;

import java.util.List;

import com.aco.model.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

	public User findUserByUsername(String username);
	
	public List<User> findUser();
	
	PageInfo<User> queryByPage(String userName,Integer pageNo,Integer pageSize); 
}
