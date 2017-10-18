package com.xhystc.airport.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xhystc.airport.bean.result.GeneralResultBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthcErrorServlet extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		String servletPath = request.getServletPath();
		System.out.println("servlet path:"+servletPath);
		if(servletPath.contains("service"))
		{
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(new GeneralResultBean("no","login first"));
			response.getOutputStream().write(json.getBytes("utf-8"));
		}
		else
		{
			request.setAttribute("errorTip","auth error");
			request.getRequestDispatcher("/WEB-INF/jsp/error-page.jsp").forward(request,response);
		}
		return;
	}
}








