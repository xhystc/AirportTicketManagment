package com.xhystc.airport.dao;

import java.io.IOException;
import java.io.Serializable;

public interface JedisRespoistory
{
	void setObject(String key, Serializable value,int sec);
	Object getObject(String key);
	void del(String key);
}
