package com.xhystc.airport.service;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.TicketOrderResult;
import com.xhystc.airport.bean.result.UserOrderResult;

public interface UserOrderService
{
	UserOrderResult checkUserOrder(long userId);
	TicketOrderResult preOrder(long ticketId);
	GeneralResultBean doOrder(long userId, long ticketId);
	GeneralResultBean deleteOrder(Long userId,long orderId);
}



