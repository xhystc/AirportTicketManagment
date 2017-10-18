package com.xhystc.airport.bean.result;


import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.Ticket;

public class UpdateAirlineResult extends GeneralResultBean
{
	Airline airline;

	public UpdateAirlineResult(String result,String tip,Airline airline)
	{
		super(result,tip);
		this.airline=airline;
	}
	public  UpdateAirlineResult()
	{
		super();
	}

	public Airline getAirline()
	{
		return airline;
	}

	public void setAirline(Airline airline)
	{
		this.airline = airline;
	}
}

