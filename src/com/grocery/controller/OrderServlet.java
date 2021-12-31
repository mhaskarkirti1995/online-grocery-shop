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

import com.grocery.dao.CustomerDaoImpl;
import com.grocery.dao.OrderDaoImpl;
import com.grocery.pojo.Customer;
import com.grocery.pojo.Order;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	Order order;
	OrderDaoImpl odao = new OrderDaoImpl();
	List<Order> olist = new ArrayList<Order>();
	boolean flag ;
	Customer customer;
	CustomerDaoImpl cdao = new CustomerDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		
		String key=request.getParameter("action");

		
		if(key!=null && key.equals("myorders"))
		{
			String customerEmailId=request.getParameter("custemail");
			customer = cdao.searchCustomerByEmailId(customerEmailId);

			olist = odao.showAllOrder(customerEmailId);
			
			if(!olist.isEmpty())
			{
				session.setAttribute("ordlist", olist);
				response.sendRedirect("orderlist.jsp");
			}
			else
			{
				session.setAttribute("ordlist", olist);
				response.sendRedirect("orderlist.jsp");
			}
		}
		else if(key!=null && key.equals("cancelorder"))
		{
			int orderId=Integer.parseInt(request.getParameter("orderid"));
			flag=odao.cancelOrder(orderId);
			
			if(flag)
			{
				request.setAttribute("status", "Your order has been cancelled successfully for orderId "+ orderId);
			}
			else
			{
				request.setAttribute("status", "Your order has not been cancelled ");
			}
			RequestDispatcher rd = request.getRequestDispatcher("orderlist.jsp");
			rd.forward(request, response);
		}
		else if(key!=null && key.equals("searchorder"))
		{
			String customerEmailId = request.getParameter("custemail");
			olist = odao.searchOrderByCustomerEmailId(customerEmailId);

			session.setAttribute("ordlist", olist);
			response.sendRedirect("orderlist.jsp");
			
		}
		else
		{
			olist = odao.showAllOrder();
			session.setAttribute("ordlist", olist);
			response.sendRedirect("orderlist.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String key = request.getParameter("action");
		HttpSession session = request.getSession();
		String customerEmailId = (String)session.getAttribute("user");//when I login as a customer write user here 
		double totalBill = 0;
		double discount;
		double finalBill=0;
		
		if(key!=null && key.equals("placeorder"))
		{
			String groceryQuantity[] = request.getParameterValues("groqty");
			String groceryPrice[] = request.getParameterValues("groprice");
			
			for(int i=0; i<groceryQuantity.length;i++)
			{
				totalBill = totalBill + (Integer.parseInt(groceryQuantity[i]) * Double.parseDouble(groceryPrice[i]));
			}
			
			discount = (totalBill/100)*15;
			finalBill=(totalBill-discount)+49;

			Order order = odao.placeOrder(customerEmailId, finalBill);

			if(order != null)
			{
				session.setAttribute("placeorder", order);
				request.setAttribute("status", "Your order has been placed successfully & Your order Id is "+order.getOrderId());
			}
			else
			{
				request.setAttribute("status", "Your order has not been placed");
			}
			RequestDispatcher rd = request.getRequestDispatcher("orderreceipt.jsp");
			rd.forward(request, response);
		}
	}

}
