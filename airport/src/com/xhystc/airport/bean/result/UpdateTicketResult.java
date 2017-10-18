package com.xhystc.airport.bean.result;

import com.xhystc.airport.entities.Ticket;

public class UpdateTicketResult extends GeneralResultBean
{
	Ticket ticket;

	public UpdateTicketResult(String result,String tip,Ticket ticket)
	{
		super(result,tip);
		this.ticket=ticket;
	}
	public  UpdateTicketResult()
	{
		super();
	}

	public Ticket getTicket()
	{
		return ticket;
	}

	public void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}
}
