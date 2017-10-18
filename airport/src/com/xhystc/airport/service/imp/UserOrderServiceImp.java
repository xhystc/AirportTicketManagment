package com.xhystc.airport.service.imp;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.TicketOrderResult;
import com.xhystc.airport.bean.result.UserOrderResult;
import com.xhystc.airport.dao.OrderDao;
import com.xhystc.airport.dao.TicketDao;
import com.xhystc.airport.dao.UserDao;
import com.xhystc.airport.entities.Order;
import com.xhystc.airport.entities.Ticket;
import com.xhystc.airport.entities.User;
import com.xhystc.airport.exception.AJAXRequestException;
import com.xhystc.airport.service.UserOrderService;

import javax.transaction.Transactional;
import java.util.*;

public class UserOrderServiceImp implements UserOrderService
{
	UserDao userDao;
	TicketDao ticketDao;
	OrderDao orderDao;


	@Transactional
	@Override
	public UserOrderResult checkUserOrder(long userId)
	{
		User user = userDao.findUser(userId);
		if(user==null)
			return new UserOrderResult("no","user not found",null);

		Set<Order> orders = user.getOrders();
		List<Order> result = new ArrayList<>(orders.size());
		result.addAll(orders);


		return new UserOrderResult("yes","xxx",result);
	}

	@Transactional
	@Override
	public TicketOrderResult preOrder(long ticketId)
	{
		Ticket ticket = ticketDao.findTicket(ticketId,false);
		if(ticket==null)
			return new TicketOrderResult("no","ticket not found",null);
		if(ticket.getStock()<=0)
			return new TicketOrderResult("no","not stock",null);

		return new TicketOrderResult("yes","xxx",ticket);
	}

	@Transactional
	@Override
	public GeneralResultBean doOrder(long userId, long ticketId)
	{
		User user = userDao.findUser(userId);
		Ticket ticket = ticketDao.findTicket(ticketId,true);
		if(ticket==null)
			return new GeneralResultBean("no","no stock") ;
		ticket.takeTicket(1);

		Order order = orderDao.addOrder(user,ticket,UUID.randomUUID().toString().substring(0,10));
		if(order!=null)
			return new GeneralResultBean("yes","xxx");
		else
			return new GeneralResultBean("no","unknowerror");
	}



	@Transactional
	@Override
	public GeneralResultBean deleteOrder(Long userId,long orderId)
	{
		Order order = orderDao.getOrder(orderId);

		if(order==null || !order.getUser().getId().equals(userId) || order.getTicket()==null)
		{
			return new GeneralResultBean("no","bad request");
		}
		if(!orderDao.deleteOrder(orderId))
			return new GeneralResultBean("no","order not found");

		if(!order.getTicket().backTicket(1))
			throw new AJAXRequestException("back ticket error");

		return new GeneralResultBean("yes","xxx");
	}

	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	public TicketDao getTicketDao()
	{
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao)
	{
		this.ticketDao = ticketDao;
	}

	public OrderDao getOrderDao()
	{
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao)
	{
		this.orderDao = orderDao;
	}
}










