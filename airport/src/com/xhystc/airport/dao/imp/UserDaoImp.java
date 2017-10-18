package com.xhystc.airport.dao.imp;

import com.xhystc.airport.dao.UserDao;
import com.xhystc.airport.entities.User;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class UserDaoImp implements UserDao
{
	@PersistenceContext(unitName = "airport")
	EntityManager entityManager;

	@Override
	public User findUser(String username)
	{
		List res = entityManager.createQuery("select  distinct  u from User u left join fetch u.orders where u.username =:un").setParameter("un",username).getResultList();
		if(res.size()<=0)
			return null;
		return (User)res.get(0);
	}

	@Override
	public User findUser(long id)
	{
		User u  = entityManager.find(User.class,new Long(id));
		return u;
	}

	@Override
	public User addUser(String username, String password)
	{
		if(username==null || password==null)
			return null;
		if(username.length()>20 || username.length()<3 || password.length()>20 || password.length()<3)
			return null;
		User u = this.findUser(username);
		if(u!=null)
			return null;
		User user = new User(username,password);

		entityManager.persist(user);
		return user;

	}

	@Override
	public boolean deleteUser(long id)
	{
		User user = this.findUser(id);
		if(user==null)
			return false;
		entityManager.remove(user);
		return true;
	}

	@Override
	public User merge(User user)
	{
		return entityManager.merge(user);
	}
}













