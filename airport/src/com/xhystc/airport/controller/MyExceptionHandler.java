package com.xhystc.airport.controller;


import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.exception.AJAXRequestException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyExceptionHandler implements HandlerExceptionResolver
{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex)
	{
		String path = request.getServletPath();
		String tip = "";
		if(ex instanceof AJAXRequestException)
		{
			tip = "lock exception";
		}
		else
			tip = "unknow exception";

		request.setAttribute("errorTip",tip);

		if(path.contains("service"))
		{
			ObjectMapper mapper = new ObjectMapper();
			String json = null;
			try
			{
				json = mapper.writeValueAsString(new GeneralResultBean("no",tip));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			response.setContentType("application/json");
			try
			{
				response.getOutputStream().write(json.getBytes("utf-8"));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("error-page");
			modelAndView.addObject("errorTip",tip);
			return modelAndView;

		}
		return null;
	}
}











