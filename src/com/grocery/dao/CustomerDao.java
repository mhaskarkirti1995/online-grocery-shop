package com.grocery.dao;

import java.util.List;

import com.grocery.pojo.Customer;

public interface CustomerDao 
{
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int customerId);
	Customer searchCustomerByEmailId(String customerEmailId);
	Customer searchCustomerByPassword(String password);
	Customer searchCustomerByContactNumber(long contact);
	String getEncryptedPassword(String customerPassword);
	List<Customer> displayAllCustomer();
	
}
