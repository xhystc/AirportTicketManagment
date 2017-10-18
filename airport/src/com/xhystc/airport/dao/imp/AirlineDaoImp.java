package com.xhystc.airport.dao.imp;

import com.xhystc.airport.dao.AirlineDao;
import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.AirlineTime;
import com.xhystc.airport.entities.Airport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class AirlineDaoImp implements AirlineDao
{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Airline addAirline(Airport departure, Airport destination, AirlineTime airlineTime,String plane)
	{
		List<Airline> airlines = findAirlines(departure.getName(),destination.getName(),0,-1);

		for(Airline a : airlines)
		{
			if(a.getTime().equals(airlineTime))
				return null;
		}
		Airline airline = new Airline(departure,destination,airlineTime,plane);
		entityManager.persist(airline);
		return airline;
	}

	@Override
	public List<Airline> findAirlines(String departure, String destination, int start, int max)
	{
		List res = null;
		String queryString = "select distinct a from Airline a where '1'='1'";
		if(departure!=null )
			queryString+=" and a.departure.name like :dep";
		if(destination!=null)
			queryString+=" and a.destination.name like :des";

		queryString+=" order by a.time.takeoffHour,a.time.takeoffMinute";

		Query query = entityManager.createQuery(queryString);

		if(departure!=null)
			query.setParameter("dep",departure+"%");
		if(destination!=null)
			query.setParameter("des",destination+"%");

		if(max>0 && start>0)
			query.setFirstResult(start).setMaxResults(max);
		return query.getResultList();
	}

	@Override
	public List<Airline> findAirlines(Airport airport, int start, int max)
	{
		List<Airline> list1 = this.findAirlines(null,airport.getName(),start,max/2);
		List<Airline> list2 =  this.findAirlines(airport.getName(),null,start,max/2);
		list1.addAll(list2);
		return list1;
	}

	@Override
	public List<Airline> findAll(int start, int max)
	{

		return this.findAirlines(null,null,start,max);
	}

	@Override
	public Airline findAirline(long id)
	{
		return entityManager.find(Airline.class,id);
	}

	@Override
	public boolean deleteAirline(long id)
	{
		Airline airline = this.findAirline(id);
		if(airline==null)
			return false;
		entityManager.remove(airline);
		return true;
	}
}









