package com.aco.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.PermissionMapper;
import com.aco.model.Permission;
import com.aco.service.PermissionService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public String addPermission(Permission permission) {
		// TODO Auto-generated method stub
		permissionMapper.insertSelective(permission);
		return permission.getPermissionId();
	}

	@Override
	public String editPermission(Permission permission) {
		// TODO Auto-generated method stub
		permissionMapper.updateByPrimaryKeySelective(permission);
		return permission.getPermissionId();
	}

	@Override
	public String deletePermission(String permissionId) {
		// TODO Auto-generated method stub
		permissionMapper.deleteByPrimaryKey(permissionId);
		return permissionId;
	}

	@Override
	public PagedResult<Permission> queryByPage(String userName, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(permissionMapper.selectByPrimaryKey(userName));
	}

}
