package com.cts;


public class User {
	
	private int userId;
	private String userName;
	private String email;
	private String country;
	
	
	public User(int userId, String userName, String email, String country) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.country = country;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
