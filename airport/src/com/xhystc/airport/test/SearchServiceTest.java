package com.xhystc.airport.test;

import com.xhystc.airport.bean.controller.SearchAirlineBean;
import com.xhystc.airport.bean.result.SearchTicketResult;
import com.xhystc.airport.entities.Ticket;
import com.xhystc.airport.service.SearchService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Calendar;
import java.util.List;

public class SearchServiceTest
{
	static public void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");
		SearchService service = (SearchService) context.getBean("searchService");

		SearchAirlineBean bean = new SearchAirlineBean();

		bean.setDep("福州长乐");

		System.out.println("lenbgth"+"".trim().length());
		SearchTicketResult result = service.searchTicketByAirlineId(35);

		List<Ticket> airports = result.getTickets();
		System.out.println("tip:"+result.getTip());
		for(Ticket airline :airports)
		{
			System.out.println(airline.getDate().get(Calendar.MONTH));
		}

	}
}
