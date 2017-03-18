package com.aco.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aco.model.User;
import com.aco.service.UserService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	private static final String ADDPAGE="user/addUser";
	//用户登录
	@Autowired
	private UserService userService;
	
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try{
            subject.login(token);//会跳到我们自定义的realm中
            request.getSession().setAttribute("user", user);
            return "index";
        }catch(Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误！");
            return "unauthorized";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }   

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        return "success";
    }
    
    @RequestMapping("/addPage")
    public String admin(){
    	return ADDPAGE;
    }
    @RequestMapping("/findUserList")
    @ResponseBody
    public String list(Integer pageNumber,Integer pageSize ,String userName){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<User> pageResult = userService.queryByPage(userName, pageNumber,pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
    
    @RequestMapping("/add")
    @ResponseBody
    public String add(User user){
    	return userService.addUser(user);
    }
    
    @RequestMapping("/edit")
    @ResponseBody
    public String update(User user){
    	return userService.updateUser(user);
    }
          
    public String delete(User user){
    	return userService.deleteUser(user);
    }
}
