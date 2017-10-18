package com.xhystc.airport.controller.Interceptor;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.entities.User;
import com.xhystc.airport.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserLoginCheckInterceptor implements HandlerInterceptor
{
	@Autowired
	LoginService service;
	String[] ignorePath={"regist","login"};
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
	{
		/*String requestPath = httpServletRequest.getServletPath();
		for(String s : ignorePath)
		{
			if(requestPath.contains(s))
				return true;
		}
		Cookie[] cookies = httpServletRequest.getCookies();
		Cookie loginToken = null;
		for(Cookie cookie : cookies)
		{
			if(cookie.getName().equals("loginToken"))
			{
				loginToken=cookie;
				break;
			}
		}
		User user=null;
		if(loginToken!=null)
			user = service.getUser(httpServletRequest.getRemoteAddr(),loginToken.getValue());
		if(user==null)
		{
			if(requestPath.contains("service"))
			{
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(new GeneralResultBean("no","login first"));
				httpServletResponse.getOutputStream().write(json.getBytes("utf-8"));
			}
			else
			{
				httpServletRequest.setAttribute("loginTip","login first");
				httpServletRequest.getRequestDispatcher("/login_page").forward(httpServletRequest,httpServletResponse);
			}
			return false;
		}*/
		httpServletRequest.setAttribute("currentUser", SecurityUtils.getSubject().getSession().getAttribute("user"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
	{

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
	{

	}

	public LoginService getService()
	{
		return service;
	}

	public void setService(LoginService service)
	{
		this.service = service;
	}

}
















