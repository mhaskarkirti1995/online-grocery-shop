package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.grocery.dbutility.DBUtility;
import com.grocery.pojo.Feedback;

public class FeedbackDaoImpl implements FeedbackDao
{
	Connection con=DBUtility.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean flag;
	String addFeedback = "insert into feedback_22063(customer_emailid,rate_grocery,rate_us,suggestion) values(?,?,?,?)";
	String displayAllFeedback = "select * from feedback_22063";
	Feedback feedback;
	
	@Override
	public boolean addFeedback(Feedback feedback) 
	{
		try
		{
			ps=con.prepareStatement(addFeedback);
			ps.setString(1, feedback.getCustomerEmailId());
			ps.setInt(2, feedback.getRateGrocery());
			ps.setString(3, feedback.getRateUs());
			ps.setString(4, feedback.getSuggestion());
			
			row=ps.executeUpdate();
			
			
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

	@Override
	public List<Feedback> displayAllFeedback() 
	{
		List<Feedback> feedlist=new ArrayList<>();
		try
		{
			ps=con.prepareStatement(displayAllFeedback);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				feedback =new Feedback
						(
								rs.getString("customer_emailid"),
								rs.getInt("rate_grocery"),
								rs.getString("rate_us"),
								rs.getString("suggestion")
						);
								feedback.setFeedbackId(rs.getInt("feedback_id"));
								feedlist.add(feedback);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		return feedlist;
	}
	
}
