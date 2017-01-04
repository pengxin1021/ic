package com.ic.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ic.service.user.UserService;

public class CustomSessionManager extends DefaultWebSessionManager {

private Logger logger = LoggerFactory.getLogger(CustomJdbcRealm.class);
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
}
