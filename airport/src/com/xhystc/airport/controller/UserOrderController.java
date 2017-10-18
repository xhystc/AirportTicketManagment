package com.xhystc.airport.controller;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.TicketOrderResult;
import com.xhystc.airport.bean.result.UserOrderResult;
import com.xhystc.airport.entities.User;
import com.xhystc.airport.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

@SessionAttributes("checkOrderId")
@Controller
public class UserOrderController
{
	@Autowired
	UserOrderService userOrderService;

	@RequestMapping("/check_order")
	public String checkOrder(Long ticketId, Model model)
	{
		TicketOrderResult result = userOrderService.preOrder(ticketId);
		if(result.getResult().equals("yes"))
		{
			model.addAttribute("checkOrderId",ticketId);
			model.addAttribute("ticket",result.getTicket());
			return "check-order";
		}
		model.addAttribute("result",result.getTip());
		return "order-error";
	}

	@RequestMapping("/service/do_order")
	public @ResponseBody
	GeneralResultBean doOrder(HttpSession session, HttpServletRequest request)
	{
		Long ticketId = (Long) session.getAttribute("checkOrderId");
		if(ticketId==null)
			return new GeneralResultBean("no","check order first!");
		User user = (User) request.getAttribute("currentUser");
		if(user==null)
			return new GeneralResultBean("no","login first!");

		return userOrderService.doOrder(user.getId(),ticketId);
	}

	@RequestMapping("/service/user_order")
	public @ResponseBody
	GeneralResultBean checkOrder(HttpServletRequest request)
	{
		User user = (User) request.getAttribute("currentUser");
		if(user==null)
			return new GeneralResultBean("no","login first!!");
		return userOrderService.checkUserOrder(user.getId());
	}

	@RequestMapping("/service/back_order")
	public @ResponseBody GeneralResultBean
	backOrder(HttpServletRequest request,Long orderId)
	{
		User user = (User) request.getAttribute("currentUser");
		if(user==null)
			return new GeneralResultBean("no","login first!!");
		return userOrderService.deleteOrder(user.getId(),orderId);
	}

	public UserOrderService getUserOrderService()
	{
		return userOrderService;
	}

	public void setUserOrderService(UserOrderService userOrderService)
	{
		this.userOrderService = userOrderService;
	}

}














