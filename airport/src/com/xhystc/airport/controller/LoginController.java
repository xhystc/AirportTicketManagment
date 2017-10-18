package com.xhystc.airport.controller;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.LoginResultBean;
import com.xhystc.airport.bean.result.UserOrderResult;
import com.xhystc.airport.entities.User;
import com.xhystc.airport.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

@Controller
public class LoginController
{
	@Autowired
	LoginService loginService;

	/*@RequestMapping("/service/login")
	public @ResponseBody
	GeneralResultBean doLogin(HttpServletRequest request,HttpServletResponse response, @Valid User user,Errors errors)
	{
		if(errors.hasErrors())
		{
			return new GeneralResultBean("no","information illegal");
		}
		LoginResultBean result = loginService.userLogin(request.getRemoteAddr(),user.getUsername(),user.getPassword(),60*60*24);
		if(result.getToken()==null || result.getToken().length()<=0)
			return result;
		Cookie cookie = new Cookie("loginToken", result.getToken());
		System.out.println("username:"+user.getUsername()+" password:"+user.getPassword());
		cookie.setMaxAge(60*60*24);
		cookie.setPath("/");
		response.addCookie(cookie);

		System.out.println("add cookie:"+cookie.getValue());
		return  result;
	}*/

	@RequestMapping("/service/login")
	public @ResponseBody
	GeneralResultBean doLogin(HttpServletRequest request,HttpServletResponse response, @Valid User user,Errors errors)
	{
		if(errors.hasErrors())
		{
			return new GeneralResultBean("no","information illegal");
		}
		LoginResultBean result = loginService.userLogin(request.getRemoteAddr(),user.getUsername(),user.getPassword(),60*60*24);

		return  result;
	}

	@RequestMapping("/logoff")
	public String doLogoff(@CookieValue("loginToken") String token,HttpServletResponse response)
	{
		loginService.logoff(token);
		return "login";
	}

	@RequestMapping("/service/regist")
	public @ResponseBody
	GeneralResultBean doRegist(@Valid User user, Errors errors)
	{
		if(errors.hasErrors())
		{
			return new GeneralResultBean("no","information illegal");
		}
		return loginService.register(user.getUsername(),user.getPassword());
	}




	public LoginService getLoginService()
	{
		return loginService;
	}

	public void setLoginService(LoginService loginService)
	{
		this.loginService = loginService;
	}
}






