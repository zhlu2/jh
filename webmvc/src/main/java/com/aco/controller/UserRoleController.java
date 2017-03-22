package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.user_role;
import com.aco.service.UserRoleService;

@Controller
@RequestMapping("/userRole")
public class UserRoleController extends BaseController{
    private static final String ADDPAGE="userRole/addUserRole";

	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("/addPage/{id}")
	public ModelAndView addPage(@PathVariable("id") String id){
		ModelAndView mav=new ModelAndView(ADDPAGE);
		mav.addObject("id",id);
		return mav;
	}
	
    @RequestMapping("/add")
    @ResponseBody
    public String addUserRole(String userId,String roleId){
		return userRoleService.addUserRole(userId, roleId);
	}
    
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteUserRole(String userId, String roleId){
    	return userRoleService.deleteUserRole(userId, roleId);
    }
}
