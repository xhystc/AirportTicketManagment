package com.xhystc.airport.test;

import com.xhystc.airport.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.transaction.Transactional;

public class UserDaoTest
{
	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/conf/spring/application-context-hibernate.xml");
		UserDao userDao = (UserDao) context.getBean("userdao");
		userDao.addUser("root","root");
	}
}
