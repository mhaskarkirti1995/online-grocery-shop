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

import com.grocery.dao.LoginDaoImpl;
import com.grocery.pojo.Login;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Login login;
	LoginDaoImpl ldao = new LoginDaoImpl();
	boolean flag;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session =request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String type,userName,password,key;
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		
		key = request.getParameter("action");
		type=request.getParameter("type");
		userName=request.getParameter("username");
		password=request.getParameter("pass");
		
		if(key!=null && key.equals("login"))
		{
			if(type!=null && type.equals("admin"))
			{
				flag=ldao.adminLogin(userName, password);
				
				if(flag)
				{
					session.setAttribute("admin", userName);
					response.sendRedirect("index.jsp");
				}
				else
				{
					request.setAttribute("status", "Invalid Credentials");
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
			}
			else if(type!=null && type.equals("customer"))
			{
				flag=ldao.userLogin(userName, password);
				
				if(flag)
				{
					session.setAttribute("user", userName);
					response.sendRedirect("index.jsp");
				}
				else
				{
					request.setAttribute("status", "Invalid Credentials");
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
			} 	
		}
		else if(key!=null && key.equals("change"))
		{
			
			if(type!=null && type.equals("admin"))
			{
				flag=ldao.adminChangePassword(userName, password);
				
				if(flag)
				{
					request.setAttribute("status", "Password Changed Successfully.");
				}
				else
				{
					request.setAttribute("status", "Password not Changed.");
					RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
					rd.include(request, response);
				}
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else if(type!=null && type.equals("customer"))
			{
				flag=ldao.userChangePassword(userName, password);
				
				if(flag)
				{
					request.setAttribute("status", "Password Changed Successfully.");
				}
				else
				{
					request.setAttribute("status", "Password not Changed.");
					RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
					rd.include(request, response);
				}
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} 
				
		}
	}

}
