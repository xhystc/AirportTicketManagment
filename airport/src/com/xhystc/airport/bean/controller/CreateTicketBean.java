package com.xhystc.airport.bean.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateTicketBean
{

	@NotNull
	int year;

	@Min(1)
	@Max(12)
	@NotNull
	int month;

	@NotNull
	@Max(31)
	@Min(1)
	int day;

	int stock;

	@NotNull
	int total;

	long airlineId;


	public long getAirlineId()
	{
		return airlineId;
	}

	public void setAirlineId(long airineId)
	{
		this.airlineId = airineId;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public int getDay()
	{
		return day;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}
}
