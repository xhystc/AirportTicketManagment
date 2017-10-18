package com.xhystc.airport.service.imp;

import com.xhystc.airport.bean.controller.SearchAirlineBean;
import com.xhystc.airport.bean.controller.SearchTicketBean;
import com.xhystc.airport.bean.result.SearchAirlineResult;
import com.xhystc.airport.bean.result.SearchAirportResult;
import com.xhystc.airport.bean.result.SearchTicketResult;
import com.xhystc.airport.dao.AirlineDao;
import com.xhystc.airport.dao.AirportDao;
import com.xhystc.airport.dao.TicketDao;
import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.Airport;
import com.xhystc.airport.entities.Ticket;
import com.xhystc.airport.service.SearchService;
import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class SearchServiceImp implements SearchService
{
	TicketDao ticketDao;
	AirportDao airportDao;
	AirlineDao airlineDao;

	@Override
		public SearchAirlineResult searchAirline(String dep,String des, int page)
	{
		List<Airline> airlines = airlineDao.findAirlines(dep,des,(page-1)*10,10);


		return new SearchAirlineResult("yes","xxx",airlines);
	}



	@Override
	public SearchTicketResult searchTicket(String dep,String des,int year,int month,int day,int page)
	{
		Calendar date=null;
		if(month>0 && month<=12  && day>0 && day<=31)
		{
			date = Calendar.getInstance();
			date.set(Calendar.DAY_OF_MONTH, day);
			date.set(Calendar.MONTH,month-1);
			date.set(Calendar.YEAR,year);
		}

		List<Ticket> tickets  = ticketDao.findTickets(dep,des,date,true,(page-1)*10,5);

		return new SearchTicketResult("yes","xxx",tickets);
	}

	@Override
	public SearchAirportResult searchAirport(String airport)
	{
		List<Airport> airports = airportDao.findAirports(airport);
		return new SearchAirportResult("yes","xxx",airports);
	}

	@Override
	public SearchTicketResult searchTicketByAirlineId(long airlineId)
	{

		Airline airline = airlineDao.findAirline(airlineId);

		if(airline==null)
			return new SearchTicketResult("no","airline not found",null);

		List<Ticket> result = ticketDao.findTickets(airline,null,false,-1,0);

		return new SearchTicketResult("yes","xxx",result);
	}

	public TicketDao getTicketDao()
	{
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao)
	{
		this.ticketDao = ticketDao;
	}

	public AirportDao getAirportDao()
	{
		return airportDao;
	}

	public void setAirportDao(AirportDao airportDao)
	{
		this.airportDao = airportDao;
	}

	public AirlineDao getAirlineDao()
	{
		return airlineDao;
	}

	public void setAirlineDao(AirlineDao airlineDao)
	{
		this.airlineDao = airlineDao;
	}
}












