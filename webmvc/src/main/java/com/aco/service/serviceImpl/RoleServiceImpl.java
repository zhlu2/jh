package com.aco.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.RoleMapper;
import com.aco.model.Role;
import com.aco.service.RoleService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
	private RoleMapper roleMapper;
	@Override
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		roleMapper.insertSelective(role);
		return role.getId();
	}
	
	@Override
	public String editRole(Role role) {
		// TODO Auto-generated method stub
		roleMapper.updateByPrimaryKeySelective(role);
		return null;
	}

	@Override
	public String deleteRole(String id) {
		// TODO Auto-generated method stub
		roleMapper.deleteByPrimaryKey(id);
		return id;
	}

	@Override
	public PagedResult<Role> queryByPage(String userName, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(roleMapper.selectByPrimaryKey(userName));
	}

	@Override
	public List<Role> findRole(String id) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleById(id);
	}

}
