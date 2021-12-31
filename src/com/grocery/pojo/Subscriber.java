package com.grocery.pojo;

public class Subscriber 
{
	private String emailId;
	private int subscribeId;
	
	public int getSubscribeId() {
		return subscribeId;
	}

	public void setSubscribeId(int subscribeId) {
		this.subscribeId = subscribeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public Subscriber(String emailId) {
		super();
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Subscriber [subscribeId=" + subscribeId + ", emailId=" + emailId + "]";
	}

	
	
}
