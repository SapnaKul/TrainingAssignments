package com.cts;

import java.util.ArrayList;

public interface UserDao {
	public int insert (User u);
	public ArrayList listUsers();
	public User getUser(int userId);
	public int updateUser( User u);
	public int deleteUser (int userId);
}
