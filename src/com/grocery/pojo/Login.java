package com.grocery.pojo;

public class Login 
{
	private String userName,password,newPassword;

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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Login(String userName, String password, String newPassword) {
		super();
		this.userName = userName;
		this.password = password;
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", newPassword=" + newPassword + "]";
	}
	
	
		
}
