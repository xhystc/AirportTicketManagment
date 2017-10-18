package com.xhystc.airport.test;

import com.xhystc.airport.bean.controller.CreateAirlineBean;
import com.xhystc.airport.service.AirlineManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.UUID;

public class AirlineManagerServiceTest
{
	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");
		AirlineManagerService service = (AirlineManagerService) context.getBean("airlineManagerService");

		CreateAirlineBean bean = new CreateAirlineBean();


		bean.setDep("北京首都");
		bean.setDes("上海虹桥");
		bean.setPlane(UUID.randomUUID().toString().substring(0,10));
		bean.setTakeoffHour(8);
		bean.setTakeoffMin(16);
		bean.setLandingHour(11);
		bean.setLandingMin(25);

		bean.setDep("北京首都");
		bean.setDes("上海虹桥");
		bean.setPlane(UUID.randomUUID().toString().substring(0,10));
		bean.setTakeoffHour(10);
		bean.setTakeoffMin(23);
		bean.setLandingHour(13);
		bean.setLandingMin(6);

		bean.setDep("北京首都");
		bean.setDes("上海虹桥");
		bean.setPlane(UUID.randomUUID().toString().substring(0,10));
		bean.setTakeoffHour(23);
		bean.setTakeoffMin(12);
		bean.setLandingHour(1);
		bean.setLandingMin(21);


		System.out.println(service.addAirline(bean).getTip());



	}
}







