package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.grocery.dbutility.DBUtility;
import com.grocery.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao 
{
	Connection con=DBUtility.getConnection();
	int row;
	PreparedStatement ps;
	ResultSet rs;
	String addCustomer="insert into customer_22063(customer_name,customer_emailid,customer_password,customer_contactno,customer_address) values(?,?,?,?,?)";
	String updateCustomer="update customer_22063 set customer_name=?,customer_emailid=?,customer_password=?,customer_contactno=?,customer_address=? where customer_id=?";
	String deleteCustomer="delete from customer_22063 where customer_id=?";
	String searchCustomerByEmail="select * from customer_22063 where customer_emailid=?";
	String displayAllCustomer="select * from customer_22063";
	String searchCustomerByPassword = "select * from customer_22063 where customer_password=?";
	String searchCustomerByContactNumber = "select * from customer_22063 where customer_contactno=?";
	
	Customer customer;
	
	@Override
	public boolean addCustomer(Customer customer) 
	{
		try
		{
			ps=con.prepareStatement(addCustomer);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmailId());
			ps.setString(3, customer.getCustomerPassword());
			ps.setLong(4, customer.getCustomerContact());
			ps.setString(5, customer.getCustomerAddress());
			
			row=ps.executeUpdate();
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
	public boolean updateCustomer(Customer customer) 
	{
		try
		{
			ps=con.prepareStatement(updateCustomer);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmailId());
			ps.setString(3, customer.getCustomerPassword());
			ps.setLong(4, customer.getCustomerContact());
			ps.setString(5, customer.getCustomerAddress());
			ps.setInt(6, customer.getCustomerId());
			
			row=ps.executeUpdate();
			
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
	public boolean deleteCustomer(int customerId) 
	{
		try
		{
			ps=con.prepareStatement(deleteCustomer);
			ps.setInt(1, customerId);
			
			row=ps.executeUpdate();
			
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
	public Customer searchCustomerByEmailId(String customerEmailId) 
	{
		try
		{
			ps=con.prepareStatement(searchCustomerByEmail);
			ps.setString(1, customerEmailId);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				customer=new Customer
						(
							rs.getString("customer_name"),
							rs.getString("customer_emailid"),
							rs.getString("customer_password"),
							rs.getLong("customer_contactno"),
							rs.getString("customer_address")
						);
					customer.setCustomerId(rs.getInt("customer_id"));
					customer.setCustomerEmailId(rs.getString("customer_emailid"));
					return customer;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> displayAllCustomer() 
	{
		List<Customer> custlist=new ArrayList<>();
		try
		{
			ps=con.prepareStatement(displayAllCustomer);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				customer=new Customer
						(
								rs.getString("customer_name"),
								rs.getString("customer_emailid"),
								rs.getString("customer_password"),
								rs.getLong("customer_contactno"),
								rs.getString("customer_address")
						);
					customer.setCustomerId(rs.getInt("customer_id"));
					custlist.add(customer);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return custlist;
	}

	@Override
	public Customer searchCustomerByPassword(String password) 
	{
		try
		{
			ps=con.prepareStatement(searchCustomerByPassword);
			ps.setString(1, password);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				customer = new Customer
						(
								rs.getString("customer_name"),
								rs.getString("customer_emailid"),
								rs.getString("customer_password"),
								rs.getLong("customer_contactno"),
								rs.getString("customer_address")
							);
						customer.setCustomerId(rs.getInt("customer_id"));
						customer.setCustomerEmailId(rs.getString("customer_emailid"));
						return customer;
			}
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer searchCustomerByContactNumber(long contact) 
	{
		try
		{
			ps=con.prepareStatement(searchCustomerByContactNumber);
			ps.setLong(1, contact);
			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				customer = new Customer
						(
								rs.getString("customer_name"),
								rs.getString("customer_emailid"),
								rs.getString("customer_password"),
								rs.getLong("customer_contactno"),
								rs.getString("customer_address")
							);
						customer.setCustomerId(rs.getInt("customer_id"));
						customer.setCustomerEmailId(rs.getString("customer_emailid"));
						return customer;
			}
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public String getEncryptedPassword(String customerPassword) 
	{
		String customerPassword1="";
		
		char ch[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U',
					'V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
					'r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0','!','@','#',
					'$','%','^','&','*'};
		
		char ch1[]= { 'Z','Y','X','W','V','U','T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F',
					  'E','D','C','B','A','z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k',
					  'j','i','h','g','f','e','d','c','b','a','0','9','8','7','6','5','4','3','2','1',
					   '*','&','^','%','$','#','@','!'};
		
		for(int i=0;i<customerPassword.length();i++)
		{
			for(int j=0;j<ch.length;j++)
			{
				if(customerPassword.charAt(i)==(j))
				{
					customerPassword1=customerPassword1+ch1[j];
				}
			}
		}		
		return customerPassword1;
	}

	
}
