package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aco.model.user_role;
import com.aco.service.UserRoleService;

@Controller
@RequestMapping("/userRole")
public class UserRoleController extends BaseController{
    @Autowired
	private UserRoleService userRoleService;
	
    @RequestMapping("/add")
    public String addUserRole(String userId,String roleId){
		return userRoleService.addUserRole(userId, roleId);
	}
    
    @RequestMapping("/delete")
    public String deleteUserRole(user_role userRole){
    	return userRoleService.deleteUserRole(userRole);
    }
}
