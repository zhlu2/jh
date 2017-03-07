package com.aco.shiro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.aco.model.Permission;
import com.aco.model.Role;
import com.aco.model.User;
import com.aco.service.UserService;

public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;

	/**
	 * 授权操作
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		String username = (String) principals.getPrimaryPrincipal();
		
		Set<Role> roleSet =  userService.findUserByUsername(username).getRoleSet();
		//角色名的集合
		Set<String> roles = new HashSet<String>();
		//权限名的集合
		Set<String> permissions = new HashSet<String>();
		
		Iterator<Role> it = roleSet.iterator();
		while(it.hasNext()){
			roles.add(it.next().getRoleName());
			for(Permission per:it.next().getPermissionSet()){
				permissions.add(per.getPermissionName());
			}
		}

		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		authorizationInfo.addRoles(roles);
		authorizationInfo.addStringPermissions(permissions);
		
		
		return authorizationInfo;
	}

	/**
	 * 身份验证操作
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		String username = (String) token.getPrincipal();
		User user = userService.findUserByUsername(username);
		
		if(user==null){
			//木有找到用户
			throw new UnknownAccountException("没有找到该账号");
		}

		
		/**
		 * 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		 */
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),getName());
		
		
		return info;
	}
	
	@Override
	public String getName() {
		return getClass().getName();
	}



}
