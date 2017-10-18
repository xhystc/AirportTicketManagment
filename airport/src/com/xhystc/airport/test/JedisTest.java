package com.xhystc.airport.test;

import com.xhystc.airport.dao.JedisRespoistory;
import com.xhystc.airport.entities.Order;
import com.xhystc.airport.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.util.Calendar;
import java.util.Set;

public class JedisTest
{
	public static void main(String[] args) throws IOException
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");

		JedisRespoistory jedis = (JedisRespoistory) context.getBean("redisRespoistory");

		jedis.setObject("xixi","haha",10);


	}
}
