package com.xhystc.airport.controller;

import com.xhystc.airport.bean.controller.CreateAirlineBean;
import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.service.AirlineManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class AirlineManagerController
{
	@Autowired
	AirlineManagerService service;

	@RequestMapping("/root/service/delete_airline")
	public @ResponseBody GeneralResultBean deleteAirline(Long airlineId)
	{
		return service.deleteAirline(airlineId);
	}
	@RequestMapping("/root/service/create_airline")
	public @ResponseBody GeneralResultBean createAirline(@Valid  CreateAirlineBean bean,Errors errors )
	{
		if(errors.hasErrors())
			return new GeneralResultBean("no","param illegal");
		return service.addAirline(bean);
	}

	@RequestMapping("/root/service/update_airline")
	public @ResponseBody GeneralResultBean updateAirline(Long id,@Valid  CreateAirlineBean bean,Errors errors)
	{
		if(errors.hasErrors() || id==null)
		{
			return new GeneralResultBean("no","param illegal");
		}
		return service.updateAirline(id,bean);

	}



	public AirlineManagerService getService()
	{
		return service;
	}

	public void setService(AirlineManagerService service)
	{
		this.service = service;
	}
}














