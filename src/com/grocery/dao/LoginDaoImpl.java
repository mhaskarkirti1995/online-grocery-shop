package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.grocery.dbutility.DBUtility;

public class LoginDaoImpl implements LoginDao
{
		Connection con=DBUtility.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		boolean flag;
		int row;
		String adminLogin="select * from admin_22063 where username=? and password=?";
		String adminChangePass="update admin_22063 set password=? where username=?";
		String userLogin="select * from customer_22063 where customer_emailid=? and customer_password=?";
		String userChangePass="update customer_22063 set customer_password=? where customer_emailid=?";
		
	@Override
	public boolean adminLogin(String userName, String password) 
	{
		try
		{
			ps=con.prepareStatement(adminLogin);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next())
				flag=true;
			else 
				flag=false;
							
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean adminChangePassword(String userName, String newPassword) 
	{
		
		try
		{
			ps=con.prepareStatement(adminChangePass);
			ps.setString(1, newPassword);
			ps.setString(2, userName);
			
			row=ps.executeUpdate();
			
			if(row>0)
				flag=true;
			else
				flag=false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean userLogin(String userName, String password) 
	{
		try
		{
			ps=con.prepareStatement(userLogin);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next())
				flag=true;
			else 
				flag=false;
							
		}
		catch(Exception ex)
		{
			
		}
		return flag;
	}

	@Override
	public boolean userChangePassword(String userName, String newPassword) 
	{
		try
		{
			ps=con.prepareStatement(userChangePass);
			ps.setString(1, newPassword);
			ps.setString(2, userName);
			
			row=ps.executeUpdate();
			
			if(row>0)
				flag=true;
			else 
				flag=false;
							
		}
		catch(Exception ex)
		{
			
		}
		return flag;
	}

}
