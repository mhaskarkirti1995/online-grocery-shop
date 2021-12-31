package com.grocery.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grocery.dao.GroceryDaoImpl;
import com.grocery.pojo.Grocery;

@WebServlet("/ImageController")
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int groceryId = Integer.parseInt(request.getParameter("groid"));
		
		GroceryDaoImpl gdao = new GroceryDaoImpl();
		
		Grocery grocery = gdao.searchGroceryById(groceryId);
		
		InputStream medicineImage = grocery.getGroceryImage();
		
		OutputStream out = response.getOutputStream();
		
		int i;
		
		while((i=medicineImage.read())!=-1)
		{
			out.write(i);
		}
		
		medicineImage.close();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
