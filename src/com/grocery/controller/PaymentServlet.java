package com.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grocery.dao.PaymentDaoImpl;
import com.grocery.pojo.Payment;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet 
{
	Payment payment;
	PaymentDaoImpl pdao = new PaymentDaoImpl();
	boolean flag;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nameOnCard=request.getParameter("nameoncard");
		long cardNumber=Long.parseLong(request.getParameter("cardnumber"));
		int cvvNumber=Integer.parseInt(request.getParameter("cvvnumber"));
		String expiryDate=request.getParameter("expirydate");
	
		payment = new Payment(nameOnCard, cardNumber, cvvNumber, expiryDate);
		
		flag = pdao.makePayment(payment);
		
		if(flag)
		{
			request.setAttribute("status", "Your Payment has been done successfully Now you can place your order ");
		}
		else
		{
			request.setAttribute("status", "Your Payment has not been done please try again. ");
		}
		RequestDispatcher rd=request.getRequestDispatcher("cartlist.jsp");
		rd.forward(request, response);
	}

}
