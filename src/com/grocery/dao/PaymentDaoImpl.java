package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.grocery.dbutility.DBUtility;
import com.grocery.pojo.Payment;

public class PaymentDaoImpl implements PaymentDao 
{
	PreparedStatement ps;
	Connection con=DBUtility.getConnection();
	boolean flag;
	int row;
	String makePayment="insert into payment_22063(name_oncard ,card_number,cvv_number,expiry_date) values(?,?,?,?)";

	@Override
	public boolean makePayment(Payment payment) 
	{
		try
		{
			ps=con.prepareStatement(makePayment);
			ps.setString(1, payment.getNameOnCard());
			ps.setLong(2, payment.getCardNumber());
			ps.setInt(3, payment.getCvvNumber());
			ps.setString(4, payment.getExpiryDate());
			
			row=ps.executeUpdate();
			System.out.println(row);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		if(flag=true)
			return true;
		else
			return false;
	}

}
