package com.xhystc.airport.bean.result;

import com.xhystc.airport.entities.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserOrderResult extends GeneralResultBean implements Serializable
{
	List<Order> orders;


	public List<Order> getOrders()
	{
		return orders;
	}

	public void setOrders(List<Order> orders)
	{
		this.orders = orders;
	}

	public String getResult()
	{
		return result;
	}


	public UserOrderResult(String result, String tip, List<Order> orders)
	{
		super(result,tip);
		this.orders=orders;
	}
	public UserOrderResult()
	{
		super();
		orders = new ArrayList<>(0);
	}
}
