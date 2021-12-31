package com.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.grocery.dao.CustomerDaoImpl;
import com.grocery.pojo.Customer;
import com.mysql.cj.Session;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Customer customer;
	CustomerDaoImpl cdao= new CustomerDaoImpl();
	boolean flag;
	List<Customer> custlist=new ArrayList<>();
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		PrintWriter out= response.getWriter();
		String key = request.getParameter("action");
		String operation = request.getParameter("name");
		
		if(operation!=null && operation.equals("checkcustemail"))
		{
			String customerEmailId=request.getParameter("custemail");
			customer = cdao.searchCustomerByEmailId(customerEmailId);
			
			if(customer != null)
			{
				String message = "EmailId already registered";
				
				String message1 = gson.toJson(message);
				response.setContentType("application/json");
				
				out.print(message1);
			}
			else
				out.print("");
		}
		else if(operation != null && operation.equals("checkpassword"))
		{
			String password = request.getParameter("password");
			customer = cdao.searchCustomerByPassword(password);
			if(customer != null)
			{
				String message = "Password already present please enter another";
				
				String message1 = gson.toJson(message);
				response.setContentType("application/json");
				
				out.print(message1);
			}
			else
				out.print("");
		}
		else if(operation !=null && operation.equals("checkcontact"))
		{
			long contact = Long.parseLong(request.getParameter("contact"));
			customer =cdao.searchCustomerByContactNumber(contact);
			
			if(customer !=null)
			{
				String message = "Contact number already registered please enter another";
				
				String message1 = gson.toJson(message);
				response.setContentType("application/json");
				out.print(message1);
			}
			else
				out.print("");
		}
		else if(key!=null && key.equals("delete"))
		{
			int customerId = Integer.parseInt(request.getParameter("custid"));
			flag = cdao.deleteCustomer(customerId);
			
			if(flag)
			{
				custlist = cdao.displayAllCustomer();
				session.setAttribute("cust", custlist);
				request.setAttribute("status", "Customer has been deleted successfully");
			}
			else
			{
				request.setAttribute("status", "Customer has not been deleted.");
			}
			RequestDispatcher rd = request.getRequestDispatcher("customerlist.jsp");
			rd.forward(request, response);
		}
		else if(key!=null && key.equals("update"))
		{
			String customerEmailId = request.getParameter("custemail");
			customer = cdao.searchCustomerByEmailId(customerEmailId);
			if(customer!=null)
			{
				session.setAttribute("cust", customer);
				response.sendRedirect("updatecustomer.jsp");
			}
		}
		else
		{
			custlist = cdao.displayAllCustomer();
			session.setAttribute("custlist", custlist);
			response.sendRedirect("customerlist.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String customerName,customerEmailId,customerAddress,customerPassword;
		long customerContact;
		PrintWriter out = response.getWriter();
		String key=request.getParameter("action");
		HttpSession session =request.getSession();
		
		if(key!=null && key.equals("add"))
		{
			customerName=request.getParameter("custname");
			customerEmailId=request.getParameter("custemail");
			customerPassword=request.getParameter("pass");
			customerContact=Long.parseLong(request.getParameter("contact"));
			customerAddress=request.getParameter("custadd");
			
			customer = new Customer(customerName, customerEmailId, customerPassword, customerContact, customerAddress);

			flag = cdao.addCustomer(customer);
			if(flag)
			{
				session.setAttribute("cust", custlist);
				request.setAttribute("status", "Your Registration has been done successfully");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			else
			{
				request.setAttribute("status", "Your Registration has not been done please try again.....");
				RequestDispatcher rd = request.getRequestDispatcher("addcustomer.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(key!=null && key.equals("update"))
		{	
			int customerId=Integer.parseInt(request.getParameter("custid"));
			customerName=request.getParameter("custname");
			customerEmailId=request.getParameter("custemail");
			customerPassword=request.getParameter("pass");
			customerContact=Long.parseLong(request.getParameter("contact"));
			customerAddress=request.getParameter("custadd");
			
			String admin = (String)session.getAttribute("admin");
			String user = (String)session.getAttribute("user");
			
			customer = new Customer(customerName, customerEmailId, customerPassword, customerContact, customerAddress);
			customer.setCustomerId(customerId);
			
			flag = cdao.updateCustomer(customer);
			
			if(admin!=null && user==null)
			{
				if(flag)
				{
					custlist = cdao.displayAllCustomer();
					session.setAttribute("custlist", custlist);
					request.setAttribute("status", "Customer has been updated successfully");
				}
				else
				{
					request.setAttribute("status", "Customer has not been updated");
				}
					RequestDispatcher rd = request.getRequestDispatcher("customerlist.jsp");
					rd.forward(request, response);
			}
			else if(admin==null && user!=null)
			{
				if(flag)
				{
					request.setAttribute("status", "Profile has been updated successfully");
				}
				else
				{
					request.setAttribute("status", "Profile has not been updated");
				}
					RequestDispatcher rd = request.getRequestDispatcher("grocerylist.jsp");
					rd.forward(request, response);
			}
			
		}
			
	}

}
