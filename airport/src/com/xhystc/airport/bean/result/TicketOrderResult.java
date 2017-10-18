package com.xhystc.airport.bean.result;

import com.xhystc.airport.entities.Ticket;

public class TicketOrderResult extends GeneralResultBean
{
	Ticket ticket;

	public TicketOrderResult(String result,String tip,Ticket ticket)
	{
		super(result,tip);
		this.ticket=ticket;
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


