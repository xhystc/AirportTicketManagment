package com.xhystc.airport.shiro;

import com.xhystc.airport.dao.UserDao;
import com.xhystc.airport.entities.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm
{

	UserDao userDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
	{
		String username = (String) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo ret = new SimpleAuthorizationInfo();
		Set<Permission> permissions = new HashSet<>(5);
		Set<String> roles = new HashSet<>(5);
		if(username.equals("root"))
		{
			roles.add("root");
			permissions.add(new WildcardPermission("*:*"));

		}

		roles.add("user");
		permissions.add(new WildcardPermission("*:select"));

		ret.addObjectPermissions(permissions);
		ret.addRoles(roles);
		return ret;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
	{

		User user = userDao.findUser((String) authenticationToken.getPrincipal());
		if (user == null)
		{
			System.out.println("user==null");
			throw new UnknownAccountException();
		}
		System.out.println("username:"+user.getUsername()+" password:"+user.getPassword());
		SimpleAuthenticationInfo ret = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
		return ret;
	}

	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
}













