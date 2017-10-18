package com.xhystc.airport.controller;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.exception.AJAXRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ExceptionHandleTestController
{
	@RequestMapping("/service/runtime_exception")
	public @ResponseBody
	GeneralResultBean doException1()
	{
		throw new RuntimeException("runtime exception");
	}

	@RequestMapping("/runtime_exception")
	public @ResponseBody
	GeneralResultBean doException2()
	{
		throw new RuntimeException("runtime exception");
	}

	@RequestMapping("/service/my_exception")
	public @ResponseBody
	GeneralResultBean doException3()
	{
		throw new AJAXRequestException("ajax exception");
	}

	@RequestMapping("/my_exception")
	public @ResponseBody
	GeneralResultBean doException4()
	{
		throw new AJAXRequestException("ajax exception");
	}

}
