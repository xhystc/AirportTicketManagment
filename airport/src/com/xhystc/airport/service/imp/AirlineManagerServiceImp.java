package com.xhystc.airport.service.imp;

import com.xhystc.airport.bean.controller.CreateAirlineBean;
import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.UpdateAirlineResult;
import com.xhystc.airport.dao.AirlineDao;
import com.xhystc.airport.dao.AirportDao;
import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.AirlineTime;
import com.xhystc.airport.entities.Airport;
import com.xhystc.airport.exception.AJAXRequestException;
import com.xhystc.airport.service.AirlineManagerService;

import javax.transaction.Transactional;
import java.util.List;

public class AirlineManagerServiceImp implements AirlineManagerService
{
	AirportDao airportDao;
	AirlineDao airlineDao;


	@Transactional
	@Override
	public UpdateAirlineResult updateAirline(Long airlineId, CreateAirlineBean bean)
	{
		Airline airline = airlineDao.findAirline(airlineId);
		if(airline==null)
			return new UpdateAirlineResult("no","airline not found",null);

		Airport dep = airportDao.findAirport(bean.getDep());
		Airport des = airportDao.findAirport(bean.getDes());
		if(dep==null || des==null)
			throw new AJAXRequestException("airport not found");

		System.out.println("dep:"+bean.getDep()+" des:"+bean.getDes());


		AirlineTime time = new AirlineTime(bean.getTakeoffHour(),bean.getTakeoffMin(),bean.getLandingHour(),bean.getLandingMin());
		airline.setTime(time);
		airline.setDestination(des);
		airline.setDeparture(dep);
		airline.setPlane(bean.getPlane());


		return new UpdateAirlineResult("yes","xxx",airline);
	}

	@Transactional
	@Override
	public GeneralResultBean deleteAirline(long airlineId)
	{
		if(!airlineDao.deleteAirline(airlineId))
			return new GeneralResultBean("no","airline not found");

		return new GeneralResultBean("yes","xxx");
	}

	@Transactional
	@Override
	public GeneralResultBean addAirline(CreateAirlineBean bean)
	{
		Airport dep = airportDao.findAirport(bean.getDep());
		Airport des = airportDao.findAirport(bean.getDes());
		if(dep==null || des==null)
			throw new RuntimeException("airport not found");

		AirlineTime time = new AirlineTime(bean.getTakeoffHour(),bean.getTakeoffMin(),bean.getLandingHour(),bean.getLandingMin());
		Airline airline = airlineDao.addAirline(dep,des,time,bean.getPlane());

		if(airline==null)
			return new GeneralResultBean("no","add error");
		return new GeneralResultBean("yes","xxx");
	}

	public AirportDao getAirportDao()
	{
		return airportDao;
	}

	public void setAirportDao(AirportDao airportDao)
	{
		this.airportDao = airportDao;
	}

	public AirlineDao getAirlineDao()
	{
		return airlineDao;
	}

	public void setAirlineDao(AirlineDao airlineDao)
	{
		this.airlineDao = airlineDao;
	}
}










