package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.UserMapper;
import com.aco.model.User;
import com.aco.service.UserService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	@Override
	public List<User> findUser() {

		return userMapper.selectByPrimaryKey("21");
	}

	@Override
	public PagedResult<User> queryByPage(String userName, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(userMapper.selectByPrimaryKey(userName));
	}

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		 userMapper.insert(user);
		 return user.getId();
	}

}
