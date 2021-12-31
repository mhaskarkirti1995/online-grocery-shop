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

import com.grocery.dao.ContactDaoImpl;
import com.grocery.pojo.Contact;


@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ContactDaoImpl cdao=new ContactDaoImpl();
	Contact contact;
	boolean flag;
	List<Contact> conlist= new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			PrintWriter out =response.getWriter();
			HttpSession session =request.getSession();
			
			conlist = cdao.displayAllContact();
		
			session.setAttribute("conlist", conlist);
			response.sendRedirect("contactlist.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String custName,subject,message,emailId;
		long contactNumber;
		
		custName=request.getParameter("name");
		contactNumber=Long.parseLong(request.getParameter("contact"));
		emailId=request.getParameter("email");
		subject=request.getParameter("subject");
		message=request.getParameter("message");
		
		contact = new Contact(custName, contactNumber, emailId, subject, message);
		flag = cdao.addContact(contact);
		
		if(flag)
		{
			request.setAttribute("status", "Mail sent successfully, thank you for contacting with us !!!");
		}
		else
		{
			request.setAttribute("status", "Mail has not been sent !!!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("addcontact.jsp");
		rd.forward(request, response);
		
	}

}
