package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aco.model.Permission;
import com.aco.service.PermissionService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

	private static final String List = "permission/permissionList";
	private static final String addPage = "permission/addPermission";
	private static final String editPage = "permission/edidPermission";
	@Autowired
	private PermissionService permissionService;

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
	public String addPermission(Permission permission) {
		return permissionService.addPermission(permission);
	}
	
    @RequestMapping("/edit")
	public String editPermission(Permission permission) {
		return permissionService.editPermission(permission);
	}
    
    @RequestMapping("/delete")
    @ResponseBody
    public String deletePermission(String permissionId){
    	return permissionService.deletePermission(permissionId);
    }
    
    @RequestMapping("/findPermissionList")
    @ResponseBody
    public String list(Integer pageNumber,Integer pageSize ,String permissionId){
        logger.info("分页查询权限信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<Permission> pageResult = permissionService.queryByPage(permissionId, pageNumber,pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }

}
