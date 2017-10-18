package com.xhystc.airport.dao;

import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.AirlineTime;
import com.xhystc.airport.entities.Airport;


import java.util.List;

public interface AirlineDao 
{
	/*airport级联*/
	Airline addAirline(Airport departure, Airport destination, AirlineTime airlineTime,String plane);
	List<Airline> findAirlines(String departure, String destination, int start, int max);
	List<Airline> findAirlines(Airport airport, int start, int max);
	List<Airline> findAll(int start, int end);
	Airline findAirline(long id);
	boolean deleteAirline(long id);
	
}
