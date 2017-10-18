package com.xhystc.airport.bean.result.easyui;

import com.xhystc.airport.entities.Airline;

public class AirlineResultBean
{
	Long id;
	String dep;
	String des;
	int takeoffHour;
	int takeoffMin;
	int landingHour;
	int landingMin;

	public AirlineResultBean(Long id, String dep, String des, int takeoffHour, int takeoffMin, int landingHour, int landingMin)
	{
		this.id = id;
		this.dep = dep;
		this.des = des;
		this.takeoffHour = takeoffHour;
		this.takeoffMin = takeoffMin;
		this.landingHour = landingHour;
		this.landingMin = landingMin;
	}
	public AirlineResultBean(Airline airline)
	{
		this.id = airline.getId();
		this.dep = airline.getDeparture().getName();
		this.des = airline.getDestination().getName();
		this.takeoffHour = airline.getTime().getTakeoffHour();
		this.takeoffMin = airline.getTime().getTakeoffMinute();
		this.landingHour = airline.getTime().getLandingHour();
		this.landingMin = airline.getTime().getLandingMinute();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

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

	public int getTakeoffHour()
	{
		return takeoffHour;
	}

	public void setTakeoffHour(int takeoffHour)
	{
		this.takeoffHour = takeoffHour;
	}

	public int getTakeoffMin()
	{
		return takeoffMin;
	}

	public void setTakeoffMin(int takeoffMin)
	{
		this.takeoffMin = takeoffMin;
	}

	public int getLandingHour()
	{
		return landingHour;
	}

	public void setLandingHour(int landingHour)
	{
		this.landingHour = landingHour;
	}

	public int getLandingMin()
	{
		return landingMin;
	}

	public void setLandingMin(int landingMin)
	{
		this.landingMin = landingMin;
	}
}










