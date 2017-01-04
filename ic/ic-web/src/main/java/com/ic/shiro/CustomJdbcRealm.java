package com.ic.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ic.entity.user.User;
import com.ic.service.user.UserService;

public class CustomJdbcRealm extends AuthorizingRealm{
	
	private Logger logger = LoggerFactory.getLogger(CustomJdbcRealm.class);
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.debug("check authentication of {}", token.getPrincipal());
		String userName = token.getPrincipal().toString();
		User user = userService.getUserByName(userName);
		if(user == null) {
			logger.error("用户" + userName + "不存在");
			throw new UnknownAccountException("用户" + userName + "不存在");
		}
		return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
	}

}
