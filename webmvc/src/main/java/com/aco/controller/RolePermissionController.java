package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aco.model.RolePermission;
import com.aco.service.RolePermissionService;

@Controller
@RequestMapping("/rolePermission")
public class RolePermissionController {
    @Autowired
	private RolePermissionService rolePermissionservice;
    
    @RequestMapping("/add")
    public String addRolePermission(RolePermission rolePermission){
    	return rolePermissionservice.addRolePermission(rolePermission);
    }
    @RequestMapping("/delete")
    public String deleteRolePermission(String id){
    	return rolePermissionservice.deleteRolePermission(id);
    }
    
}
