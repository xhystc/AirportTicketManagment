package com.xhystc.airport.bean.controller;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateAirlineBean implements Serializable
{

	@Length(max = 20,min = 4)
	@NotNull
	String dep;
	@Length(max = 20,min = 4)
	@NotNull
	String des;

	@Min(0)
	@Max(23)
	@NotNull
	int takeoffHour;
	@Max(59)
	@NotNull
	@Min(0)
	int takeoffMin;

	@Min(0)
	@Max(23)
	@NotNull
	int landingHour;
	@Max(59)
	@NotNull
	@Min(0)
	int landingMin;

	@NotBlank
	String plane;

	public String getDes()
	{
		return des;
	}

	public void setDes(String des)
	{
		this.des = des;
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

	public String getPlane()
	{
		return plane;
	}

	public void setPlane(String plane)
	{
		this.plane = plane;
	}

	public String getDep()
	{
		return dep;
	}

	public void setDep(String dep)
	{
		this.dep = dep;
	}

	public int getTakeoffHour()
	{
		return takeoffHour;
	}

	public void setTakeoffHour(int takeoffHour)
	{
		this.takeoffHour = takeoffHour;
	}
}













