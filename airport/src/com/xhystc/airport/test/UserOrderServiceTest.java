package com.xhystc.airport.test;

import com.xhystc.airport.service.UserOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserOrderServiceTest
{
	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");

		UserOrderService service = (UserOrderService) context.getBean("orderManagerService");
	//	service.deleteOrder(1);

	}
}
