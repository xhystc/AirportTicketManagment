package com.xhystc.airport.test;

import com.xhystc.airport.bean.controller.CreateTicketBean;
import com.xhystc.airport.service.TicketManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TicketManagerServiceTest
{
	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");
		TicketManagerService service = (TicketManagerService) context.getBean("ticketManagerService");

		for(int i=55;i<=58;i++)
		{
			CreateTicketBean bean = new CreateTicketBean();
			bean.setAirlineId(i);
			bean.setDay((int)(Math.random()*100)%32);
			bean.setMonth((int)(10+Math.random()*100)%13);
			bean.setYear(2017);
			bean.setTotal(100+(int)(Math.random()*100%101));

			service.addTicket(bean);

		}
	}
}
