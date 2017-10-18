package com.xhystc.airport.dao.imp;

import com.xhystc.airport.dao.OrderDao;
import com.xhystc.airport.entities.Order;
import com.xhystc.airport.entities.Ticket;
import com.xhystc.airport.entities.User;
import net.sf.ehcache.search.expression.Or;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.List;

public class OrderDaoImp implements OrderDao
{
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public Order addOrder(User u, Ticket t, Calendar date,String sit)
	{
		if(u==null || t==null || date==null || sit==null)
			return null;

		Order order = new Order();
		order.setDate(date);
		order.setTicket(t);
		order.setUser(u);
		order.setSit(sit);

		u.getOrders().add(order);
		entityManager.persist(order);

		return order;
	}

	@Override
	public Order addOrder(User u, Ticket t,String sit)
	{
		Calendar calendar = Calendar.getInstance();


		return addOrder(u,t,calendar,sit);
	}

	@Override
	public boolean deleteOrder(long id)
	{
		Order order = entityManager.find(Order.class,id);
		if(order==null)
			return false;
		entityManager.remove(order);
		return true;
	}
	@Override
	public boolean deleteOrder(User user,Order order)
	{
		if(order==null)
			return false;
		user.getOrders().remove(order);

		entityManager.remove(order);
		return true;
	}

	@Override
	public Order getOrder(long id)
	{

		return entityManager.find(Order.class,id);
	}
}















