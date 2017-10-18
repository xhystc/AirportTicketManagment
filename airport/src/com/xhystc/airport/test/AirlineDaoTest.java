package com.xhystc.airport.test;

import com.xhystc.airport.dao.AirlineDao;
import com.xhystc.airport.dao.AirportDao;
import com.xhystc.airport.entities.AirlineTime;
import com.xhystc.airport.entities.Airport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class AirlineDaoTest
{
	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");
		AirportDao airportDao = (AirportDao) context.getBean("airportdao");
		AirlineDao airlineDao = (AirlineDao) context.getBean("airlinedao");

		Airport airport1 = airportDao.findAirports("北").get(0);
		Airport airport2 = airportDao.findAirports("武").get(0);

		AirlineTime airlineTime = new AirlineTime(18,12,20,14);
		airlineDao.addAirline(airport1,airport2,airlineTime,"AC235");

	}
}
