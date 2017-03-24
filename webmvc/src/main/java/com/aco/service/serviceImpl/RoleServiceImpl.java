package com.aco.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aco.dao.RoleMapper;
import com.aco.dao.RolePermissionMapper;
import com.aco.model.Role;
import com.aco.model.RolePermission;
import com.aco.service.RoleService;
import com.aco.util.BeanUtil;
import com.aco.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
	private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
	@Override
	public String addRole(String permissionId,String roleName,String roleSign,String description,Date creatTime) {
		// TODO Auto-generated method stub
		Role role= new Role();
		role.setRoleName(roleName);
		role.setRoleSign(roleSign);
		role.setDescription(description);
		role.setCreateTime(creatTime);
		roleMapper.insertSelective(role);
		role=roleMapper.findNewest().get(0);
		String[] permissionIds=permissionId.split(",");
		for(String pid:permissionIds){
		RolePermission rolePermission=new RolePermission();
		rolePermission.setRoleId(role.getRoleId());
		rolePermission.setPermissionId(pid);
		rolePermissionMapper.insertSelective(rolePermission);
		}
		return role.getRoleId();
	}
	
	@Override
	public String editRole(Role role) {
		// TODO Auto-generated method stub
		roleMapper.updateByPrimaryKeySelective(role);
		return null;
	}

	@Override
	public String deleteRole(String roleId) {
		// TODO Auto-generated method stub
		rolePermissionMapper.deleteByRoleId(roleId);
		roleMapper.deleteByPrimaryKey(roleId);
		return roleId;
	}

	@Override
	public PagedResult<Role> queryByPage(String userName, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(roleMapper.selectByPrimaryKey(userName));
	}

	@Override
	public List<Role> findRole(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleById(roleId);
	}

}
