package com.xhystc.airport.controller.Interceptor;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.entities.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerCheckInterceptor implements HandlerInterceptor
{
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
	{
		User user = (User) httpServletRequest.getAttribute("currentUser");
		System.out.println("root check start");
		if(user==null || !user.getUsername().equals("root"))
		{
			System.out.println("no root");
			if(httpServletRequest.getServletPath().contains("service"))
			{
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(new GeneralResultBean("no","not root"));
				httpServletResponse.setContentType("application/json");
				httpServletResponse.getOutputStream().write(json.getBytes("utf-8"));
			}
			else
			{
				httpServletRequest.setAttribute("message","not root");
				httpServletRequest.getRequestDispatcher("/login_page").forward(httpServletRequest,httpServletResponse);
			}
			return false;
		}
		System.out.println("access");
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
}
