package com.grocery.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.grocery.dao.GroceryDaoImpl;
import com.grocery.pojo.Grocery;

@MultipartConfig
@WebServlet("/GroceryServlet")
public class GroceryServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Grocery grocery;
	GroceryDaoImpl gdao=new GroceryDaoImpl();
	boolean flag;
	List<Grocery> grocerylist=new ArrayList<Grocery>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String key = request.getParameter("action");
		
		if(key !=null && key.equals("delete"))
		{
			int groceryId = Integer.parseInt(request.getParameter("groid"));
			
			flag = gdao.deleteGrocery(groceryId);
			
			if(flag)
			{
				grocerylist = gdao.showAllGrocery();
				session.setAttribute("grolist", grocerylist);
				request.setAttribute("status","Your Item has been deleted");
			}
			else
			{
				request.setAttribute("status","Your Item has not been deleted");
			}
			RequestDispatcher rd = request.getRequestDispatcher("grocerylist.jsp");
			rd.forward(request, response);
		}
		else if(key !=null && key.equals("update"))
		{
			int groceryId = Integer.parseInt(request.getParameter("groid"));
			
			grocery = gdao.searchGroceryById(groceryId);
			session.setAttribute("gro", grocery);
			response.sendRedirect("updategrocery.jsp");
								
		}
		else if(key!=null && key.equals("details"))
		{
			int groceryId = Integer.parseInt(request.getParameter("groid"));
			
			grocery = gdao.searchGroceryById(groceryId);
			
			session.setAttribute("grocery", grocery);
			response.sendRedirect("grocerydetails.jsp");
		}
		else if(key!=null && key.equals("searchproduct"))
		{
			String groceryName = request.getParameter("groname");
			
			grocerylist = gdao.searchGoceryByGroceryName(groceryName);
			System.out.println(grocerylist);
			
			if(!grocerylist.isEmpty())
			{
				session.setAttribute("grolist", grocerylist);
			}
			else
			{
				request.setAttribute("status", "No Such Grocery ");
			}
			RequestDispatcher rd= request.getRequestDispatcher("grocerylist.jsp");
			rd.forward(request, response);
		}
		else if(key!=null && key.equals("sort"))
		{
			String groceryName = request.getParameter("groname");
			grocerylist = gdao.sortGroceryByGroceryName(groceryName);
			
			session.setAttribute("grolist", grocerylist);
			response.sendRedirect("grocerylist.jsp");
		}
		else if(key!=null && key.equals("Filter"))
		{
			String groceryName = request.getParameter("groname");
			String groceryBrand = request.getParameter("grobrand");

			grocerylist = gdao.filterGroceryByGroceryNameAndBrand(groceryName, groceryBrand);
			
			if(!grocerylist.isEmpty())
			{
				session.setAttribute("grolist", grocerylist);
			}
			else
			{
				request.setAttribute("status", "No Such Grocery");
			}
			RequestDispatcher rd = request.getRequestDispatcher("grocerylist.jsp");
			rd.forward(request, response);
		}
		else
		{
			grocerylist = gdao.showAllGrocery();
			session.setAttribute("grolist", grocerylist);
			response.sendRedirect("grocerylist.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String key=request.getParameter("action");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Part part = null;
		
		String groceryName,availableIn,mfgDate,expiryDate,groceryType,groceryBrand,groceryDescription;
		int groceryQty,groceryId;
		double groceryPrice;
		InputStream groceryImage;
		
		if(key !=null && key.equals("add"))
		{
			groceryName=request.getParameter("groname");
			groceryType=request.getParameter("type");
			groceryBrand=request.getParameter("brand");
			groceryDescription=request.getParameter("description");
			groceryQty=Integer.parseInt(request.getParameter("qty"));
			mfgDate=request.getParameter("mfgdate");
			expiryDate=request.getParameter("expirydate");
			availableIn=request.getParameter("availablein");
			groceryPrice=Double.parseDouble(request.getParameter("price"));

			part = request.getPart("groimage");
			groceryImage = part.getInputStream();

			grocery = new Grocery(groceryName, groceryType, groceryBrand, groceryDescription, groceryQty, mfgDate, expiryDate, availableIn, groceryPrice);
			grocery.setGroceryImage(groceryImage);

			flag = gdao.addGrocery(grocery);
			
			if(flag)
			{
				grocerylist = gdao.showAllGrocery();
				session.setAttribute("grolist", grocerylist);
				request.setAttribute("status", "Your Item has been Added");
			}
			else
			{
				request.setAttribute("status", "Your Item has not been Added");
			}
			RequestDispatcher rd=request.getRequestDispatcher("grocerylist.jsp");
			rd.forward(request, response);
				
		}
		else if(key !=null && key.equals("update"))
		{
			groceryId=Integer.parseInt(request.getParameter("groid"));
			groceryName=request.getParameter("groname");
			groceryType=request.getParameter("type");
			groceryBrand=request.getParameter("brand");
			groceryDescription=request.getParameter("description");
			groceryQty=Integer.parseInt(request.getParameter("qty"));
			mfgDate=request.getParameter("mfgdate");
			expiryDate=request.getParameter("expirydate");
			availableIn=request.getParameter("availablein");
			groceryPrice=Double.parseDouble(request.getParameter("price"));
			
			part = request.getPart("groimage");
			
			if(part.getSize()!=0)
			{
				groceryImage = part.getInputStream();
			}
			else
			{
				grocery = gdao.searchGroceryById(groceryId);
				groceryImage=grocery.getGroceryImage();
			}
			
			grocery = new Grocery(groceryName, groceryType, groceryBrand, groceryDescription, groceryQty, mfgDate, expiryDate, availableIn, groceryPrice);
			grocery.setGroceryImage(groceryImage);
			grocery.setGroceryId(groceryId);
			
			flag= gdao.updateGrocery(grocery);
			
			if(flag)
			{
				grocerylist = gdao.showAllGrocery();
				session.setAttribute("grolist", grocerylist);
				request.setAttribute("status", "Your Item has been updated");
			}
			else
			{
				request.setAttribute("status", "Your Item has not been updated");
			}
			RequestDispatcher rd =request.getRequestDispatcher("grocerylist.jsp");
			rd.forward(request, response);
		}
	}

}
