package com.grocery.dao;

import com.grocery.pojo.Payment;

public interface PaymentDao 
{
	boolean  makePayment(Payment payment);
	
}
