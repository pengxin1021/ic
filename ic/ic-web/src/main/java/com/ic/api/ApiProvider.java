package com.ic.api;

import com.ic.service.user.UserService;

public class ApiProvider {

	private static ApiProvider instance = new ApiProvider();
	
	private ApiProvider() {
		
	}
	
	public static ApiProvider getInstance() {
		return instance;
	}
	
	public static UserService getUserService() {
		return null;
	}
}
