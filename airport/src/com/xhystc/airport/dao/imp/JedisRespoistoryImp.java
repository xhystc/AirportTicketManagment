package com.xhystc.airport.dao.imp;

import com.xhystc.airport.dao.JedisRespoistory;
import com.xhystc.airport.entities.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedisPool;

import java.io.*;

public class JedisRespoistoryImp implements JedisRespoistory
{
	JedisPool pool;
	@Override
	public void setObject(String key, Serializable value,int sec)
	{
		Jedis jedis = pool.getResource();

		try
		{
			jedis.setex(key.getBytes("utf-8"),sec,serialize(value));
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			jedis.close();
		}


	}

	@Override
	public Object getObject(String key)
	{
		Jedis jedis = pool.getResource();
		byte[] array;

		try
		{
			array = jedis.get(key.getBytes("utf-8"));
			if(array==null || array.length<=0)
				return null;
			Object object = unserialize(array);

			return object;
		}
		catch (IOException e)
		{
			System.out.println(e);
			return null;
		}
		catch (ClassNotFoundException cfe)
		{
			System.out.println(cfe);
			return null;
		}
		finally
		{
			jedis.close();
		}
	}

	@Override
	public void del(String key)
	{
		Jedis jedis = pool.getResource();
		try
		{
			jedis.del(key.getBytes("utf-8"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			jedis.close();
		}

	}


	byte[] serialize(Serializable object) throws IOException
	{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

		objectOutputStream.writeObject(object);
		return byteArrayOutputStream.toByteArray();
	}

	Object unserialize(byte[] bytes) throws IOException, ClassNotFoundException
	{
		Object result;



		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		result = objectInputStream.readObject();


		return result;
	}


	public JedisPool getPool()
	{
		return pool;
	}

	public void setPool(JedisPool pool)
	{
		this.pool = pool;
	}
}











