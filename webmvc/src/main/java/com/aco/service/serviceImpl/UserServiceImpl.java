package com.aco.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.UserMapper;
import com.aco.model.User;
import com.aco.service.UserService;



@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper; 
	
	@Override
	public User findUserByUsername(String username) {
	  return userMapper.findUserByUsername(username);
	}

	@Override
	public User findUser() {
	
		return userMapper.selectByPrimaryKey("21");
	}

	
}
