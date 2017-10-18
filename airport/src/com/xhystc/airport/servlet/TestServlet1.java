package com.xhystc.airport.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet1 extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("servlet1");
		request.setAttribute("errorTip","do filter test");
		request.getRequestDispatcher("/servlet2").forward(request,response);
		System.out.println("servlet1 forward over");
	}
}






