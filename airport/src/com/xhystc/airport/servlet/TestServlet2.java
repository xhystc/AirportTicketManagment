package com.xhystc.airport.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet2 extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("servlet2");
		request.setAttribute("errorTip","do filter test");
		request.getRequestDispatcher("/WEB-INF/jsp/error-page.jsp").forward(request,response);
		System.out.println("servlet2 forward over");
	}
}
