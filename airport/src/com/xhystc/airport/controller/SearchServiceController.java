package com.xhystc.airport.controller;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.SearchAirlineResult;
import com.xhystc.airport.bean.result.SearchAirportResult;
import com.xhystc.airport.bean.result.easyui.AirlineResultBean;
import com.xhystc.airport.bean.result.easyui.EasyUIResultBean;
import com.xhystc.airport.bean.result.easyui.TicketResultBean;
import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.Ticket;
import com.xhystc.airport.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class SearchServiceController
{
	@Autowired
	SearchService service;

	@RequestMapping("/service/search/airports")
	public @ResponseBody
	SearchAirportResult searchAirport(String airport)
	{

		if(airport==null || airport.trim().equals(""))
			return new SearchAirportResult("no","illegal name",null);
		SearchAirportResult result = service.searchAirport(airport);
	/*	System.out.print("return:");
		for(Airport air : result.getAirports())
		{
			System.out.println(air.getName()+",");
		}*/
		return result;
	}

	@RequestMapping("/root/service/search/airlines")
	public @ResponseBody
	GeneralResultBean searchAirline(String dep,String des)
	{
		System.out.println("airline search start");
		SearchAirlineResult result = service.searchAirline(dep,des,0);

		return result;
	}
	@RequestMapping("/root/service/search/ticketsByAirline")
	public @ResponseBody
	GeneralResultBean searchTicketByAirline(Long airlineId)
	{
		if(airlineId==null)
			return new GeneralResultBean("no","param illegal");
		return service.searchTicketByAirlineId(airlineId);
	}


	@RequestMapping("/service/search/tickets")
	public @ResponseBody
	GeneralResultBean searchTicket(String dep, String des, String date)
	{
		if(date==null)
			return new GeneralResultBean("no","illegal param");
		String[] dates = date.split("-");

		if(dates.length!=3)
			return new GeneralResultBean("no","illegal param");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]);

		Calendar curr = Calendar.getInstance();
		Calendar queryDate = Calendar.getInstance();
		queryDate.set(year,month,day);
		if(curr.getTimeInMillis()>queryDate.getTimeInMillis())
			return new GeneralResultBean("no","illegal param");

		GeneralResultBean result = service.searchTicket(dep,des,year,month,day,-1);

		return result;
	}


	@RequestMapping("/root/service/easyui/search/airlines")
	public @ResponseBody
	EasyUIResultBean searchEasyUIAirline(String dep, String des)
	{
		System.out.println("airline search start");
		SearchAirlineResult result = service.searchAirline(dep,des,0);
		List<Airline> searchResult = result.getAirlines();
		List<AirlineResultBean> res = new ArrayList<>(10);
		EasyUIResultBean bean = new EasyUIResultBean(searchResult.size(),res);
		for(Airline airline : searchResult)
		{
			res.add(new AirlineResultBean(airline));
		}

		return bean;
	}
	@RequestMapping("/root/service/easyui/search/tickets")
	public @ResponseBody
	EasyUIResultBean searchEasyUITicket(Long id)
	{
		if(id==null || id.equals(0))
			return null;
		List<Ticket> searchResult = service.searchTicketByAirlineId(id).getTickets();
		List<TicketResultBean> res = new ArrayList<>(10);
		EasyUIResultBean bean = new EasyUIResultBean(searchResult.size(),res);
		for(Ticket ticket : searchResult)
		{
			res.add(new TicketResultBean(ticket));
		}
		return bean;
	}

	public SearchService getService()
	{
		return service;
	}

	public void setService(SearchService service)
	{
		this.service = service;
	}
}





