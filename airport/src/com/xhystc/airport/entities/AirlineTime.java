package com.xhystc.airport.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class AirlineTime implements Serializable
{
	@NotNull
	@Column(nullable = false)
	int takeoffMinute;

	@NotNull
	@Column(nullable = false)
	int takeoffHour;

	@NotNull
	@Column(nullable = false)
	int landingMinute;


	@NotNull
	@Column(nullable = false)
	int landingHour;



	public int getTakeoffMinute()
	{
		return takeoffMinute;
	}

	public void setTakeoffMinute(int takeoffMinute)
	{
		this.takeoffMinute = takeoffMinute;
	}

	public int getTakeoffHour()
	{
		return takeoffHour;
	}

	public void setTakeoffHour(int takeoffHour)
	{
		this.takeoffHour = takeoffHour;
	}

	public int getLandingMinute()
	{
		return landingMinute;
	}

	public void setLandingMinute(int landingMinute)
	{
		this.landingMinute = landingMinute;
	}

	public int getLandingHour()
	{
		return landingHour;
	}

	public void setLandingHour(int landingHour)
	{
		this.landingHour = landingHour;
	}


	@Override
	public int hashCode()
	{
		return this.getLandingHour()*7+this.getLandingMinute()*5+this.getTakeoffHour()*3+this.getTakeoffMinute();
	}

	@Override
	public boolean equals(Object o)
	{
		if(o==this) return true;
		if(o!=null && o.getClass()==this.getClass())
		{
			AirlineTime u = (AirlineTime)o;
			return this.getLandingHour()==u.getLandingHour() && this.getLandingMinute()==u.getLandingMinute()
					&& this.getTakeoffHour()==u.getTakeoffHour()&&this.getTakeoffMinute()==u.getTakeoffMinute();
		}
		return false;
	}

	public AirlineTime(int takeoffHour,int  takeoffMinute,int landingHour,int  landingMinute)
	{
		if(takeoffHour<0 || takeoffMinute<0 || landingHour<0 || landingMinute<0 || takeoffMinute>=60 || takeoffHour>=24 ||
				landingHour >=24 || landingMinute>=60)
			throw new RuntimeException("airline time illegal");
		this.takeoffMinute=takeoffMinute;
		this.takeoffHour=takeoffHour;
		this.landingMinute=landingMinute;
		this.landingHour=landingHour;
	}
	public AirlineTime()
	{
		this.takeoffHour=0;
		this.takeoffMinute=0;
		this.landingHour=0;
		this.landingMinute=0;

	}

}






















