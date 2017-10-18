package com.xhystc.airport.controller;

import com.xhystc.airport.bean.controller.CreateTicketBean;
import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.service.TicketManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class TicketManagerController
{
	@Autowired
	TicketManagerService service;

	@RequestMapping("/root/service/delete_ticket")
	public @ResponseBody
	GeneralResultBean deleteTicket(Long id)
	{
		return service.deleteTicket(id);
	}
	@RequestMapping("/service/create_ticket")
	public @ResponseBody
	GeneralResultBean createTicket(@Valid  CreateTicketBean bean, Errors errors)
	{
		if(errors.hasErrors())
			return new GeneralResultBean("no","param illegal");
		System.out.println("airlineId:"+bean.getAirlineId());



		return service.addTicket(bean);
	}

	@RequestMapping("/root/service/update_ticket")
	public @ResponseBody
	GeneralResultBean updateTicket(Long id,@Valid CreateTicketBean bean,Errors errors)
	{
		if(errors.hasErrors())
			return new GeneralResultBean("no","param illegal");
		return service.updateTicket(id,bean);
	}



	public TicketManagerService getService()
	{
		return service;
	}

	public void setService(TicketManagerService service)
	{
		this.service = service;
	}
}



