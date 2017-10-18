package com.xhystc.airport.controller;

import com.xhystc.airport.entities.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexPageController
{
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request)
	{
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		System.out.println("index page username:"+username);
		if(username.equals("root"))
			return "manager-page";
		return "index";
	}
	@RequestMapping(value = "/regist_page")
	public String regist()
	{
		return "regist";
	}
	@RequestMapping(value = "/login_page")
	public String login()
	{
		return "login";
	}
	@RequestMapping(value = "/user_search")
	public String userSearch()
	{
		return "error-page";
	}
	@RequestMapping("/user_information")
	public String order()
	{
		return "user-information";
	}
	@RequestMapping("/easyui-test/{index}")
	public String easyui(@PathVariable int index)
	{
		System.out.println("index page:"+index);
		return "easyui-test"+index;
	}

}
