package com.xhystc.airport.service;

import com.xhystc.airport.bean.controller.CreateAirlineBean;
import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.UpdateAirlineResult;

public interface AirlineManagerService
{
	UpdateAirlineResult updateAirline(Long airlineId, CreateAirlineBean bean);
	GeneralResultBean deleteAirline(long airlineId);
	GeneralResultBean addAirline(CreateAirlineBean bean);
}
