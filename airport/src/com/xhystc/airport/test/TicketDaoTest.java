package com.xhystc.airport.test;

import com.xhystc.airport.dao.TicketDao;
import com.xhystc.airport.entities.Ticket;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import sun.misc.Cache;

import java.util.Calendar;
import java.util.List;

public class TicketDaoTest
{
	public static void main (String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");

		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR,2018);;
		date.set(Calendar.DAY_OF_MONTH,1);
		date.set(Calendar.MONTH,11);
		TicketDao dao  = (TicketDao) context.getBean("ticketDao");
		List<Ticket> result = dao.findTickets(null,null,date,false,0,10);

		System.out.println(result.get(0).getAirline().getPlane());

	}
}
