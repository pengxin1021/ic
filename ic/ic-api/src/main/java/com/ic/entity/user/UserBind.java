package com.ic.entity.user;

import java.io.Serializable;
import java.util.Date;

public class UserBind implements Serializable{

	private static final long serialVersionUID = -4212719457922071072L;
	
	private long userId;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private Date loginTime;
	
	private String loginIp;
	
	public UserBind(long userId, String name, String phone, String email, Date loginTime, String loginIp) {
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
	}
	
	public UserBind(UserBind userBind) {
		if(userBind != null) {
			this.userId = userBind.userId;
			this.name = userBind.name;
			this.phone = userBind.phone;
			this.email = userBind.email;
			this.loginTime = userBind.loginTime;
			this.loginIp = userBind.loginIp;
		}
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	
}
