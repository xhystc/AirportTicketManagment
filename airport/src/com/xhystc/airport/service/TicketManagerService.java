package com.xhystc.airport.service;


import com.xhystc.airport.bean.controller.CreateTicketBean;
import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.UpdateTicketResult;


public interface TicketManagerService
{
	UpdateTicketResult updateTicket(Long ticketId, CreateTicketBean bean);
	GeneralResultBean deleteTicket(long ticketId);
	GeneralResultBean addTicket(CreateTicketBean bean);
}
