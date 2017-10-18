package com.xhystc.airport.dao;


import com.xhystc.airport.entities.Order;
import com.xhystc.airport.entities.Ticket;
import com.xhystc.airport.entities.User;
import net.sf.ehcache.search.expression.Or;

import java.util.Calendar;
import java.util.List;

public interface OrderDao
{
	Order addOrder(User u, Ticket t, Calendar date,String sit);
	Order addOrder(User u, Ticket t,String sit);
	boolean deleteOrder(long id);
	boolean deleteOrder(User user, Order order);
	Order getOrder(long id);
}
