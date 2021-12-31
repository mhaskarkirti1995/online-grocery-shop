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

import com.grocery.dao.FeedbackDaoImpl;
import com.grocery.dao.GroceryDaoImpl;
import com.grocery.pojo.Feedback;
import com.grocery.pojo.Grocery;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Feedback feedback;
	FeedbackDaoImpl fdao =new FeedbackDaoImpl();
	List<Feedback> feedlist = new ArrayList<>();
	List<Grocery> grolist = new ArrayList<>();
	GroceryDaoImpl gdao=new GroceryDaoImpl();
	boolean flag;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		
		feedlist = fdao.displayAllFeedback();
		session.setAttribute("feedlist", feedlist);
		response.sendRedirect("feedbacklist.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String key=request.getParameter("action");
		HttpSession session=request.getSession();
		
		String customerEmailId,suggestion,rateUs;
		int rateGrocery;
		
		if(key !=null && key.equals("addfeedback")) 
		{
			customerEmailId=request.getParameter("custemailid");
			rateGrocery= Integer.parseInt(request.getParameter("rategrocery"));
			rateUs = request.getParameter("rateus");
			suggestion = request.getParameter("suggestion");
			
			feedback = new Feedback(customerEmailId, rateGrocery, rateUs, suggestion);
			flag = fdao.addFeedback(feedback);
			
			if(flag)
			{
				grolist = gdao.showAllGrocery();
				session.setAttribute("grolist", grolist);
				request.setAttribute("status", "Thank you for your feedback");
			}
			else
			{
				request.setAttribute("status", "Your feedback not send yet please try again");
			}
			RequestDispatcher rd = request.getRequestDispatcher("grocerylist.jsp");
			rd.forward(request, response);
		}
	}

}
