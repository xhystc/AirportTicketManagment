package com.xhystc.airport.bean.service;

import com.xhystc.airport.entities.User;

import java.io.Serializable;

public class UserKeyMapBean implements Serializable
{
	User user;
	String key;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}
}


