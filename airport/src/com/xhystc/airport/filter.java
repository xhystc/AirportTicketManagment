package com.xhystc.airport;

import javax.servlet.*;
import java.io.IOException;

public class filter implements Filter
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
	{
		System.out.println("do filter errorTip:"+servletRequest.getAttribute("errorTip"));
		filterChain.doFilter(servletRequest,servletResponse);

	}

	@Override
	public void destroy()
	{

	}
}











