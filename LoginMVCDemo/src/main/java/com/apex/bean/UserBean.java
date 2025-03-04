package com.apex.bean;

public class UserBean {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;

	public UserBean() {
	}

	public  UserBean(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
