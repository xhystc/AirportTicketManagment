package com.xhystc.airport.dao;


import com.xhystc.airport.entities.User;

public interface UserDao
{
	User findUser(String username);
	User findUser(long id);
	User addUser(String username, String password);
	boolean deleteUser(long id);
	User merge(User user);
}
