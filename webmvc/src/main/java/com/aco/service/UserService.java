package com.aco.service;

import com.aco.model.User;

public interface UserService {

	public User findUserByUsername(String username);
	
	public User findUser();
}
