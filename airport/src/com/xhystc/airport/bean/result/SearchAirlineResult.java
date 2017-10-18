package com.xhystc.airport.bean.result;

import com.xhystc.airport.entities.Airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchAirlineResult extends GeneralResultBean implements Serializable
{
	List<Airline> airlines;


	public List<Airline> getAirlines()
	{
		return airlines;
	}

	public void setAirlines(List<Airline> airlineBeans)
	{
		this.airlines = airlineBeans;
	}


	public SearchAirlineResult(String result,String tip,List<Airline> airlineBeans)
	{
		super(result,tip);
		this.airlines=airlineBeans;
	}
	public SearchAirlineResult()
	{
		this.result="";
		this.tip="";
		this.airlines = new ArrayList<>(0);
	}

}
