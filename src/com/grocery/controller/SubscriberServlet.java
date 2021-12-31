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

import com.grocery.dao.SubscriberDaoImpl;
import com.grocery.pojo.Subscriber;

@WebServlet("/SubscriberServlet")
public class SubscriberServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
    SubscriberDaoImpl sdao = new SubscriberDaoImpl();
    Subscriber subscribe;
    List<Subscriber> sublist = new ArrayList<Subscriber>();
    boolean flag;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		sublist = sdao.displayAllSubscriber();
		session.setAttribute("sublist", sublist);
		response.sendRedirect("subscriberlist.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String emailId = request.getParameter("email");
		
		subscribe = new Subscriber(emailId);
		
		flag = sdao.addSubscriber(subscribe);
		
		if(flag)
		{
		//	session.setAttribute("alert", "Congratulation");
			response.sendRedirect("index.jsp");
		}
		else
		{
		// request.setAttribute("status", "Your Subscription not not been done");	
		}
		
	}

}
