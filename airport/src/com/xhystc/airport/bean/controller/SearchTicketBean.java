package com.xhystc.airport.bean.controller;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Calendar;

public class SearchTicketBean implements Serializable
{
	@Length(min = 4,max=20)
	@NotBlank
	String dep;

	@Length(min = 4,max=20)
	@NotBlank
	String des;

	@Max(12)
	@Min(1)
	int month;

	@Max(31)
	@Min(1)
	int day;
	int page;

	public String getDep()
	{
		return dep;
	}

	public void setDep(String dep)
	{
		this.dep = dep;
	}

	public String getDes()
	{
		return des;
	}

	public void setDes(String des)
	{
		this.des = des;
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


	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}
}
