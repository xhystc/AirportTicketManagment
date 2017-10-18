package com.xhystc.airport.bean.result;

import com.xhystc.airport.entities.Airport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchAirportResult extends GeneralResultBean implements Serializable
{
	List<Airport> airports;


	public List<Airport> getAirports()
	{
		return airports;
	}

	public void setAirports(List<Airport> airports)
	{
		this.airports = airports;
	}

	public SearchAirportResult(String result,String tip,List<Airport> airports)
	{
		super(result,tip);
		this.airports=airports;
	}
	public SearchAirportResult()
	{
		super();
		this.airports = new ArrayList<>(0);
	}
}
