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

import com.grocery.dao.CartDaoImpl;
import com.grocery.dao.GroceryDaoImpl;
import com.grocery.pojo.Cart;
import com.grocery.pojo.Grocery;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Grocery grocery;
	CartDaoImpl cdao = new CartDaoImpl();
	boolean flag;
	Cart cart =new Cart();
	List<Cart> clist=new ArrayList<Cart>();
	GroceryDaoImpl gdao=new GroceryDaoImpl();
	List<Grocery> grocerylist=new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String key=request.getParameter("action");
		HttpSession session=request.getSession();
		String customerEmailId =(String)session.getAttribute("user");
		
		if(key !=null && key.equals("addtocart"))
		{
			boolean present = false;
			int groceryId=Integer.parseInt(request.getParameter("groid"));
			clist = cdao.showCart(customerEmailId);
			
			for(Cart c : clist)
			{
				int g = c.getGroceryId();
				
				if(g == groceryId)
				{
					//if grocery already present in cart in this if loop
					present=true;
					int cartgquantity = c.getGroceryQty();
					int groceryQuantity = cartgquantity+1;
					flag = cdao.updateGroceryQuantity(c.getCartId(), groceryQuantity);
					
				}
			}
			if(present == false)
			{
				//if grocery not present in cart then in this if loop
				
				cart.setGroceryQty(1);
				cart.setGroceryId(groceryId);
				cart.setCustomerEmailId(customerEmailId);
				
				flag=cdao.addToCart(cart);
				
			}
			if(flag)
			{
				grocerylist = gdao.showAllGrocery();
				session.setAttribute("grolist", grocerylist);
				request.setAttribute("status","Your Item has been added to cart");
			}
			else
			{
				request.setAttribute("status","Your Item has not been added to cart");
			}
			RequestDispatcher rd = request.getRequestDispatcher("grocerylist.jsp");
			rd.forward(request, response);
		}
		else if(key!=null && key.equals("delete"))
		{
			int cartId=Integer.parseInt(request.getParameter("cartid"));
			flag = cdao.deleteFromCart(cartId);
			
			if(flag)
			{
				clist = cdao.showCart(customerEmailId);
				session.setAttribute("cartlist", clist);
				request.setAttribute("status","Your Item has been deleted from cart");
			}
			else
			{
				request.setAttribute("status","Your Item has not been deleted.");
			}
			RequestDispatcher rd = request.getRequestDispatcher("cartlist.jsp");
			rd.forward(request, response);
		}
		else if(key!=null && key.equals("showcart"))
		{
			clist=cdao.showCart(customerEmailId);
			int count = clist.size();
			if(!clist.isEmpty())
			{
				session.setAttribute("cartlist", clist);
				session.setAttribute("count", count);
				response.sendRedirect("cartlist.jsp");
			}
			else 
			{
				response.sendRedirect("emptycart.jsp");
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int groceryQuantity,cartId;
		String key = request.getParameter("action");
		PrintWriter out = response.getWriter();
		
		if(key!=null && key.equals("updatequantity"))
		{
			groceryQuantity = Integer.parseInt(request.getParameter("groceryQuantity"));
			cartId = Integer.parseInt(request.getParameter("cartId"));
			
			flag = cdao.updateGroceryQuantity(cartId, groceryQuantity);
			
			/*
			 * if(flag) out.print("done"); else out.print("not done");
			 */
		}
	}

}
