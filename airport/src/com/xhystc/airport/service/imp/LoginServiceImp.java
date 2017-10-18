package com.xhystc.airport.service.imp;

import com.xhystc.airport.bean.result.GeneralResultBean;
import com.xhystc.airport.bean.service.KeyUsernameMapBean;
import com.xhystc.airport.bean.result.LoginResultBean;
import com.xhystc.airport.bean.service.UserKeyMapBean;
import com.xhystc.airport.dao.JedisRespoistory;
import com.xhystc.airport.dao.UserDao;
import com.xhystc.airport.entities.User;
import com.xhystc.airport.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;


import javax.transaction.Transactional;
import java.util.UUID;

public class LoginServiceImp implements LoginService
{
	UserDao userDao;
	JedisRespoistory jedis;

	@Transactional
	@Override
	public LoginResultBean userLogin(String addr,String username,String password,int exp)
	{
		System.out.println("try to login:"+username+":"+password);
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject subject = SecurityUtils.getSubject();
		try
		{
			token.setRememberMe(true);
			subject.login(token);
			if(!subject.isAuthenticated())
				return new LoginResultBean("no","login error",null);
		}
		catch (IncorrectCredentialsException ice)
		{
			return new LoginResultBean("no",ice.toString(),null);
		}
		catch (UnknownAccountException uae)
		{
			return new LoginResultBean("no",uae.toString(),null);
		}
		catch (ExcessiveAttemptsException eae)
		{
			return new LoginResultBean("no",eae.toString(),null);
		}
		catch (AuthenticationException ae)
		{
			ae.printStackTrace();
			return new LoginResultBean("no",ae.toString(),null);
		}
		return new LoginResultBean("yes","xxx",UUID.randomUUID().toString());
	}

/*	@Transactional
	@Override
	public LoginResultBean userLogin(String addr, String username, String password, int exp)
	{
		User user = userDao.findUser(username);

		if(user==null)
		{
			return new LoginResultBean("no","user not find","");
		}
		if(user.getPassword().equals(password))
		{
			UserKeyMapBean loginUser = (UserKeyMapBean) jedis.getObject(username);
			if(loginUser!=null)
			{
				jedis.del(loginUser.getKey());
			}
			else
			{
				loginUser = new UserKeyMapBean();
			}
			String uuid = UUID.randomUUID().toString();
			KeyUsernameMapBean mapBean = new KeyUsernameMapBean();
			mapBean.setRemoteAddress(addr);
			mapBean.setUsername(username);

			loginUser.setUser(user);
			loginUser.setKey(uuid);

			jedis.setObject(username,loginUser,exp);
			jedis.setObject(uuid,mapBean,exp);


			return new LoginResultBean("yes","xxx",uuid);
		}

		return new LoginResultBean("no","password wrong","");
	}*/

	@Transactional
	@Override
	public User getUser(String addr, String key)
	{
		KeyUsernameMapBean loginUser  = (KeyUsernameMapBean) jedis.getObject(key);
		if(loginUser==null || !loginUser.getRemoteAddress().equals(addr))
			return null;

		UserKeyMapBean mapBean = (UserKeyMapBean) jedis.getObject(loginUser.getUsername());
		if(mapBean==null)
			return null;
		return mapBean.getUser();
	}

	@Transactional
	@Override
	public void logoff(String key)
	{
		/*KeyUsernameMapBean loginUser = (KeyUsernameMapBean) jedis.getObject(key);

		jedis.del(loginUser.getUsername());
		jedis.del(key);*/
		SecurityUtils.getSubject().logout();
	}

	@Transactional
	@Override
	public GeneralResultBean register(String username, String password)
	{
		User user = userDao.addUser(username,password);
		if(user==null)
			return new GeneralResultBean("no","username exsit");
		return new GeneralResultBean("yes","xxx");
	}


	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	public JedisRespoistory getJedis()
	{
		return jedis;
	}

	public void setJedis(JedisRespoistory jedis)
	{
		this.jedis = jedis;
	}
}














