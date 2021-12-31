package com.grocery.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.grocery.dao.CustomerDaoImpl;
import com.grocery.pojo.Customer;

public class CustomerTest 
{
	public static void main(String[] args) throws IOException
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int customerId,choice;
		long customerContact;
		String customerName,customerEmailId,customerAddress,customerPassword;
		Customer customer;
		CustomerDaoImpl cdao=new CustomerDaoImpl();
		List<Customer> custlist=new ArrayList<>();
		boolean flag;
		
		while(true)
		{
			System.out.println("Enter \n"
					+ "1. Add Customer Details\n"
					+ "2. Update Customer Details \n"
					+ "3. Delete Customer \n"
					+ "4. Search Customer By EmailID \n"
					+ "5. Show All Customer\n"
					+ "6. Exit");
			
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				
				System.out.println("----Add Customer Details----");
				System.out.println("Enter Customer Name : ");
				customerName=br.readLine();
				System.out.println("Enter Customer Email Id : ");
				customerEmailId=br.readLine();
				System.out.println("Enter Customer Password : ");
				customerPassword=br.readLine();
				System.out.println("Enter Customer Contact Number : ");
				customerContact=scanner.nextLong();
				System.out.println("Enter Customer Address : ");
				customerAddress=br.readLine();
				
				customer=new Customer(customerName, customerEmailId, customerPassword, customerContact, customerAddress);
				flag=cdao.addCustomer(customer);
				
				if(flag=true)
					System.out.println("Customer added successfully");
				else
					System.out.println("Failed");
			break;
			case 2:
				System.out.println("----Update Customer----");
				System.out.println("Enter Existing Customer ID : ");
				customerId=scanner.nextInt();
				
				custlist=cdao.displayAllCustomer();
				Customer objCustomer=null;
				Iterator<Customer> itr=custlist.iterator();
				while(itr.hasNext())
				{
					Customer cust=itr.next();
					if(cust.getCustomerId()==customerId)
					{
						objCustomer=cust;
					}
				}
				if(objCustomer!=null && objCustomer.getCustomerId()>0)
				{
					System.out.println("Enter Customer Name : ");
					customerName=br.readLine();
					System.out.println("Enter Customer Email Id : ");
					customerEmailId=br.readLine();
					System.out.println("Enter Customer Password : ");
					customerPassword=br.readLine();
					System.out.println("Enter Customer Contact Number : ");
					customerContact=scanner.nextLong();
					System.out.println("Enter Customer Address : ");
					customerAddress=br.readLine();
					
					customer=new Customer(customerName, customerEmailId, customerPassword, customerContact, customerAddress);
					customer.setCustomerId(customerId);
					flag=cdao.updateCustomer(customer);
					if(flag=true)
						System.out.println("Customer updated successfully");
					else
						System.out.println("Failed");
				}
				else
					System.out.println("Enter valid customer Id");
				
				
			break;
			case 3:
				System.out.println("----Delete Customer----");
				System.out.println("Enter Existing Customer ID : ");
				customerId=scanner.nextInt();
				flag=cdao.deleteCustomer(customerId);
				if(flag==true)
					System.out.println("Customer deleted successfully");
				else
					System.out.println("Customer Id not match");
			break;
			case 4:
				System.out.println("----Search Customer----");
				System.out.println("Enter Customer Email ID : ");
				customerEmailId=br.readLine();
			
				customer=cdao.searchCustomerByEmailId(customerEmailId);
			
				if(customer!=null)
					System.out.println(customer);
				else
					System.out.println("No such customer");
			break;
			case 5:
				System.out.println("----All Customer Details----");
				custlist=cdao.displayAllCustomer();
				if(!custlist.isEmpty())
				{
					for(Customer cust : custlist)
					{
						System.out.println(cust);
					}
				}
				else
				System.out.println("Customer List is Empty");
				
			break;
			case 6:
				System.exit(0);
			default:
					System.out.println("Enter valid choice");
			}
		}
	}

}
