package com.grocery.pojo;

public class Feedback 
{
	private int feedbackId,rateGrocery;
	private String customerEmailId,suggestion,rateUs;
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getRateUs() {
		return rateUs;
	}
	public void setRateUs(String rateUs) {
		this.rateUs = rateUs;
	}
	public int getRateGrocery() {
		return rateGrocery;
	}
	public void setRateGrocery(int rateGrocery) {
		this.rateGrocery = rateGrocery;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public Feedback(String customerEmailId, int rateGrocery, String rateUs, String suggestion) {
		super();
		this.customerEmailId = customerEmailId;
		this.rateGrocery = rateGrocery;
		this.rateUs = rateUs;
		this.suggestion = suggestion;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", rateUs=" + rateUs + ", rateGrocery=" + rateGrocery
				+ ", customerEmailId=" + customerEmailId + ", suggestion=" + suggestion + "]";
	}
	
	
}
