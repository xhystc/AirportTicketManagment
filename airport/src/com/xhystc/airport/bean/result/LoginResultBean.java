package com.xhystc.airport.bean.result;

import java.io.Serializable;

public class LoginResultBean extends GeneralResultBean implements Serializable
{

	String token;

	public LoginResultBean(String result,String tip,String token)
	{
		super(result,tip);
		this.token=token;
	}
	public LoginResultBean()
	{
		super();
		token="";
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}
}
