package com.xhystc.airport.bean.controller;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class SearchAirlineBean implements Serializable
{
	@Length(min = 4,max=20)
	@NotBlank
	String dep;

	@Length(min = 4,max=20)
	@NotBlank
	String des;

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

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}
}
