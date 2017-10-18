package com.xhystc.airport.test;

import com.xhystc.airport.service.LoginService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LoginServiceTest
{
	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");

		LoginService loginService = (LoginService) context.getBean("loginService");
		System.out.println(loginService.register("root","root").getTip());



	}
}











