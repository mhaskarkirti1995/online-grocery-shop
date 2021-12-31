package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.grocery.dbutility.DBUtility;
import com.grocery.pojo.Subscriber;

public class SubscriberDaoImpl implements SubscriberDao 
{
	Connection con=DBUtility.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	String addSubscriber="insert into subscriber_22063(email_id) values(?) ";
	String displayAllSubscriber="select * from subscriber_22063";
	boolean flag;
	int row;
	Subscriber subscribe;
	
	@Override
	public boolean addSubscriber(Subscriber subscribe)
	{
		try
		{
			ps=con.prepareStatement(addSubscriber);
			ps.setString(1, subscribe.getEmailId());
			
			row = ps.executeUpdate();	
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public List<Subscriber> displayAllSubscriber() 
	{
		List<Subscriber> sublist = new ArrayList<Subscriber>();
		try
		{
			ps=con.prepareStatement(displayAllSubscriber);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				subscribe = new Subscriber(rs.getString("email_id"));
				subscribe.setSubscribeId(rs.getInt("subscriber_id"));
				sublist.add(subscribe);
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return sublist;
	}

}
