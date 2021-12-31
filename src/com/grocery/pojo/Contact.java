package com.grocery.pojo;

public class Contact 
{
	private int contactId;
	private String custName,emailId,subject,message;
	private long contactNumber;
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Contact(String custName, long contactNumber, String emailId, String subject, String message) {
		super();
		this.custName = custName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.subject = subject;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", custName=" + custName + ", contactNumber=" + contactNumber
				+ ", emailId=" + emailId + ", subject=" + subject + ", message=" + message + "]";
	}
	
	
}
