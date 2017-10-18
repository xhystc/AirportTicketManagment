package com.xhystc.airport.service;

import com.xhystc.airport.bean.controller.SearchAirlineBean;
import com.xhystc.airport.bean.controller.SearchTicketBean;
import com.xhystc.airport.bean.result.SearchAirlineResult;
import com.xhystc.airport.bean.result.SearchAirportResult;
import com.xhystc.airport.bean.result.SearchTicketResult;

import java.util.Calendar;

public interface SearchService
{
	SearchAirlineResult searchAirline(String dep,String des, int page);
	SearchTicketResult searchTicket(String dep,String des,int year,int month,int day,int page);
	SearchAirportResult searchAirport(String airport);
	SearchTicketResult searchTicketByAirlineId(long airlineId);
}
