package com.xhystc.airport.bean.result.easyui;

import com.xhystc.airport.entities.Ticket;

import java.util.Calendar;

public class TicketResultBean
{
	Long id;
	String date;
	int total;
	int stock;

	public TicketResultBean(Long id, String date, int total, int stock)
	{
		this.id = id;
		this.date = date;
		this.total = total;
		this.stock = stock;
	}
	public TicketResultBean(Ticket ticket)
	{
		this.id = ticket.getId();
		this.date = ticket.getDate().get(Calendar.YEAR)+"-"+(ticket.getDate().get(Calendar.MONTH)+1)+"-"+ticket.getDate().get(Calendar.DAY_OF_MONTH);
		this.total = ticket.getTotal();
		this.stock = ticket.getTotal();
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	public  TicketResultBean() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}
}










