package com.xhystc.airport.service;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.result.LoginResultBean;
import com.xhystc.airport.entities.User;

public interface LoginService
{
	LoginResultBean userLogin(String addr, String username, String password, int exp);
	User getUser(String addr,String key);
	void logoff(String key);
	GeneralResultBean register(String username, String password);
}
