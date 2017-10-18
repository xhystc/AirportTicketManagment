package com.xhystc.airport.dao;


import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.Ticket;

import java.util.Calendar;
import java.util.List;

public interface TicketDao 
{	
	Ticket addTicket(Airline airline, Calendar date, int total);
	List<Ticket> findTickets(Airline airline, Calendar date, boolean stock, int start, int max);
	List<Ticket> findTickets(String dep ,String des, Calendar date, boolean stock, int start, int max);
	List<Ticket> findTickets(Airline airline, boolean stock, int start, int max);
	Ticket findTicket(long id,boolean lock);
	List<Ticket> findAll(boolean stock,int start, int max);
	boolean deleteTicket(long id);

}





