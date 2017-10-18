package com.xhystc.airport.shiro;


import com.xhystc.airport.dao.JedisRespoistory;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import java.io.Serializable;


public class MySessionDao extends CachingSessionDAO
{
	JedisRespoistory jedis;
	int exp;
	@Override
	protected void doUpdate(Session session)
	{
		if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid())
		{
			return;
		}
		jedis.setObject(session.getId().toString(),(Serializable)session,exp/1000);
	}

	@Override
	protected void doDelete(Session session)
	{
		jedis.del(session.getId().toString());
	}

	@Override
	protected Serializable doCreate(Session session)
	{
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		jedis.setObject(sessionId.toString(),(Serializable)session,exp/1000);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable serializable)
	{
		Session session = (Session) jedis.getObject(serializable.toString());
		return session;
	}

	public JedisRespoistory getJedis()
	{
		return jedis;
	}

	public void setJedis(JedisRespoistory jedis)
	{
		this.jedis = jedis;
	}

	public int getExp()
	{
		return exp;
	}

	public void setExp(int exp)
	{
		this.exp = exp;
	}
}













