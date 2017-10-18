package com.xhystc.airport.dao;


import com.xhystc.airport.entities.Airport;

import java.util.List;

public interface AirportDao
{
	Airport addAirport(String name,String location);
	boolean deleteAirport(long id);
	List<Airport> findAirports(String name);
	Airport findAirport(String name);
	Airport findAirport(long id);

}
