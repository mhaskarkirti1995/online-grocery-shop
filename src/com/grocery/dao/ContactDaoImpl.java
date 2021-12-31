package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.grocery.dbutility.DBUtility;
import com.grocery.pojo.Contact;

public class ContactDaoImpl implements ContactDao 
{
	Connection con=DBUtility.getConnection();
	int row;
	PreparedStatement ps;
	ResultSet rs;
	Contact contact;
	String addContact="insert into contact_22063(cust_name,contact_number,email_id,subject,message) values(?,?,?,?,?)";
	String displayAllContact="select * from contact_22063";
	@Override
	public boolean addContact(Contact contact) 
	{
		try
		{
			ps=con.prepareStatement(addContact);
			ps.setString(1, contact.getCustName());
			ps.setLong(2, contact.getContactNumber());
			ps.setString(3, contact.getEmailId());
			ps.setString(4, contact.getSubject());
			ps.setString(5, contact.getMessage());
			
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
	public List<Contact> displayAllContact() 
	{
		List<Contact> conlist= new ArrayList<Contact>();
		try
		{
			ps=con.prepareStatement(displayAllContact);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				contact = new Contact
						(
								rs.getString("cust_name"),
								rs.getLong("contact_number"),
								rs.getString("email_id"),
								rs.getString("subject"),
								rs.getString("message")
						);
				contact.setContactId(rs.getInt("contact_id"));
				conlist.add(contact);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return conlist;
	}

}
