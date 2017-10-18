package com.xhystc.airport.service.imp;

import com.xhystc.airport.bean.controller.CreateTicketBean;
import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.SearchTicketResult;
import com.xhystc.airport.bean.result.UpdateAirlineResult;
import com.xhystc.airport.bean.result.UpdateTicketResult;
import com.xhystc.airport.dao.AirlineDao;
import com.xhystc.airport.dao.TicketDao;
import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.Ticket;
import com.xhystc.airport.exception.AJAXRequestException;
import com.xhystc.airport.service.TicketManagerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TicketManagerServiceImp implements TicketManagerService
{

	AirlineDao airlineDao;
	TicketDao ticketDao;

	@Transactional
	@Override
	public UpdateTicketResult updateTicket(Long ticketId, CreateTicketBean bean)
	{
		Ticket ticket = ticketDao.findTicket(ticketId,true);
		if(ticket==null)
			return new UpdateTicketResult("no","ticket not found",null);


		System.out.println("change date："+ticket.getDate().get(Calendar.MONTH));
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR,bean.getYear());
		date.set(Calendar.DAY_OF_MONTH,bean.getDay());
		date.set(Calendar.MONTH,bean.getMonth()-1);
		ticket.setDate(date);


		if(bean.getTotal()!=ticket.getTotal())
		{
			ticket.updateTotal(bean.getTotal());
		}


		return new UpdateTicketResult("yes","xxx",ticket);
	}

	@Transactional
	@Override
	public GeneralResultBean deleteTicket(long ticketId)
	{
		if(!ticketDao.deleteTicket(ticketId))
			return new GeneralResultBean("no","ticket not found");
		return new GeneralResultBean("yes","xxx");
	}

	@Transactional
	@Override
	public SearchTicketResult addTicket(CreateTicketBean bean)
	{
		Airline airline = airlineDao.findAirline(bean.getAirlineId());
		List<Ticket> res = new ArrayList<>(1);
		if(airline==null)
			return new SearchTicketResult("no","airline not found",null);

		Calendar date = Calendar.getInstance();
		date.set(Calendar.MONTH,bean.getMonth()-1);
		date.set(Calendar.YEAR,bean.getYear());
		date.set(Calendar.DAY_OF_MONTH,bean.getDay());

		Calendar current = Calendar.getInstance();
		if(current.getTimeInMillis()>date.getTimeInMillis())
			return new SearchTicketResult("no","time too small",null);

		Ticket ticket = ticketDao.addTicket(airline,date,bean.getTotal());
		if(ticket==null)
			return new SearchTicketResult("no","add error",null);
		res.add(ticket);

		return new SearchTicketResult("yes","xxx",res);
	}

	public AirlineDao getAirlineDao()
	{
		return airlineDao;
	}

	public void setAirlineDao(AirlineDao airlineDao)
	{
		this.airlineDao = airlineDao;
	}

	public TicketDao getTicketDao()
	{
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao)
	{
		this.ticketDao = ticketDao;
	}
}











