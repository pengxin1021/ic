package com.ic.controller;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ic.controller.support.WebControllerSupport;
import com.ic.entity.user.UserBind;
import com.ic.service.ring.RingService;

@Controller
@RequestMapping("/ring")
public class RingController extends WebControllerSupport{
	
	@Reference
	private RingService ringService;

	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		view.setViewName("/ring/index");
		return view;
	}
	
	@RequestMapping(value="/chat")
	@ResponseBody
	public String chat(HttpServletRequest request, String info, String userId, String ioc){
		UserBind userBind = (UserBind) request.getSession().getAttribute("userBind");
		return ringService.chat(info, userBind.getName(), null);
	}
	
}
