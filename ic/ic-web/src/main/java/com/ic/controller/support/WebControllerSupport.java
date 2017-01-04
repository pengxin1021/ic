package com.ic.controller.support;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ic.entity.BaseResult;
import com.ic.entity.Operator;
import com.ic.entity.user.UserBind;

public abstract class WebControllerSupport {
	
	protected HttpServletRequest request;
	
	public BaseResult successResult(Object... message){
		BaseResult result = new BaseResult();
		result.setSuccess(true);
		result.setMessage(message);
		return result;
	}
	
	public BaseResult erroResult(Object message){
		BaseResult result = new BaseResult();
		result.setSuccess(false);
		result.setMessage(message);
		return result;
	}
	
	protected void setSession(HttpServletRequest request, UserBind userBind) {
		request.getSession().setAttribute("userBind", userBind);
		request.getSession().setAttribute("name", userBind.getName());
	}
	
	protected void removeSession(HttpServletRequest request) {
		request.getSession().removeAttribute("name");
	}
	
	protected Operator getOper(HttpServletRequest request, String memo) {
		Operator oper = new Operator();
		return oper;
	}
	
	public void execute(HttpServletRequest request, Model model){};
}
