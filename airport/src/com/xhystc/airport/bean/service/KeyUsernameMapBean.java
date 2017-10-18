package com.xhystc.airport.bean.service;

import java.io.Serializable;

public class KeyUsernameMapBean implements Serializable
{
	String username;
	String remoteAddress;

	public String getRemoteAddress()
	{
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress)
	{
		this.remoteAddress = remoteAddress;
	}

	public String getUsername()
	{

		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
}
