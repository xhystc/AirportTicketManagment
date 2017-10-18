package com.xhystc.airport.dao.imp;

import com.xhystc.airport.dao.AirportDao;
import com.xhystc.airport.entities.Airport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class AirportDaoImp implements AirportDao
{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Airport addAirport(String name,String location)
	{
		if(name==null || location==null)
			return null;
		if(name.length()>20 || name.length()<2 || location.length()>20 || location.length()<2)
			return null;
		Airport a = this.findAirport(name);
		if(a!=null)
			return null;
		Airport airport = new Airport(name,location);
		entityManager.persist(airport);
		return airport;
	}

	@Override
	public boolean deleteAirport(long id)
	{
		Airport airport = this.findAirport(id);
		if(airport==null)
			return false;
		entityManager.remove(airport);
		return true;
	}

	@Override
	public List<Airport> findAirports(String name)
	{
		if(name==null)
			return new ArrayList<>(0);
		List res=null;

		res = entityManager.createQuery("select distinct a from Airport a where a.name like :name ").setParameter("name",name+"%").getResultList();

		return res;
	}

	@Override
	public Airport findAirport(String name)
	{
		if(name==null)
			return null;
		List res;
		res = entityManager.createQuery("select distinct a from Airport a where a.name = :name ").setParameter("name",name).getResultList();
		if(res.size()<=0)
			return null;
		return (Airport) res.get(0);
	}

	@Override
	public Airport findAirport(long id)
	{
		Airport airport = entityManager.find(Airport.class,id);
		return airport;
	}

}











