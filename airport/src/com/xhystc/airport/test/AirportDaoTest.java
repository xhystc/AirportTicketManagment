package com.xhystc.airport.test;

import com.xhystc.airport.dao.AirportDao;
import com.xhystc.airport.dao.UserDao;
import com.xhystc.airport.entities.Airport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class AirportDaoTest
{

	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");
		AirportDao airportDao = (AirportDao) context.getBean("airportdao");
		airportDao.addAirport("虹桥","上海");
		airportDao.addAirport("滨海","天津");
		airportDao.addAirport("首都","北京");
	}
}
