package com.xhystc.airport.bean.result;

import com.xhystc.airport.entities.Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchTicketResult extends GeneralResultBean implements Serializable
{
	List<Ticket> tickets;



	public SearchTicketResult(String result,String tip,List<Ticket> ticketBeans)
	{
		super(result,tip);
		this.tickets=ticketBeans;
	}
	public SearchTicketResult()
	{
		super();
		this.tickets = new ArrayList<>(0);
	}


	public List<Ticket> getTickets()
	{
		return tickets;
	}

	public void setTickets(List<Ticket> tickets)
	{
		this.tickets = tickets;
	}

}
