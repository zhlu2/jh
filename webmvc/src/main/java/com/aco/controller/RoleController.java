package com.aco.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aco.model.Role;
import com.aco.service.RoleService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	private static final String List = "role/roleList";
	private static final String addPage = "role/addRole";
	private static final String editPage = "role/editRole";
	@Autowired
	private RoleService roleService;

	@RequestMapping("/list")
	public String list() {
		return List;
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return addPage;
	}

	@RequestMapping("/editPage")
	public String editPage() {
		return editPage;
	}

	@RequestMapping("/add")
	@ResponseBody
	public String addRole(String permissionId,String roleName,String roleSign,String description,Date creatTime) {
		return roleService.addRole(permissionId,roleName,roleSign,description,creatTime);
	}

	@RequestMapping("/edit")
	public String editRole(Role role) {
		return roleService.editRole(role);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String deleteRole(String roleId) {
		return roleService.deleteRole(roleId);
	}

	@RequestMapping("/findRoleList")
	@ResponseBody
	public String list(Integer pageNumber, Integer pageSize, String userName) {
		logger.info("分页查询角色信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PagedResult<Role> pageResult = roleService.queryByPage(userName, pageNumber, pageSize);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}
}
