package com.grocery.pojo;

public class Payment 
{
	private int paymentId;
	private String nameOnCard;
	private Long cardNumber;
	private String expiryDate;
	private int cvvNumber;
	
	public int getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Payment(String nameOnCard, Long cardNumber, int cvvNumber, String expiryDate) {
		super();
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.cvvNumber = cvvNumber;
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber
				+ ", expiryDate=" + expiryDate + ", cvvNumber=" + cvvNumber + "]";
	}
	
	
	
}
