package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.grocery.dbutility.DBUtility;
import com.grocery.pojo.Cart;

public class CartDaoImpl implements CartDao
{

	PreparedStatement ps;
	ResultSet rs;
	int row;
	Connection con=DBUtility.getConnection();
	Cart cart;
	
	String addToCart="insert into cart_22063(grocery_id,customer_emailid,grocery_qty) values(?,?,?) ";
	String deleteCart="delete from cart_22063 where cart_id=?";
	String clearCart="delete from cart_22063 where customer_emailid=?";
	String showCart="select c.cart_id, c.grocery_id , g.grocery_name,c.customer_emailid,c.grocery_qty,g.grocery_price "
			+ "from grocery_22063 g inner join cart_22063 c on c.grocery_id=g.grocery_id where c.customer_emailid=?";
	
	@Override
	public boolean addToCart(Cart cart) 
	{
		try
		{
			ps=con.prepareStatement(addToCart);
			ps.setInt(1, cart.getGroceryId());
			ps.setString(2, cart.getCustomerEmailId());
			ps.setInt(3, cart.getGroceryQty());
			
			row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteFromCart(int cartId) 
	{
		try
		{
			ps=con.prepareStatement(deleteCart);
			ps.setInt(1, cartId);
			
			row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean clearCart(String customerEmailId)
	{
		try
		{
			ps=con.prepareStatement(clearCart);
			ps.setString(1, customerEmailId);
			
			row=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		if(row>0)
			return true;
		else	
			return false;
		
	}

	@Override
	public List<Cart> showCart(String customerEmailId) 
	{
		List<Cart> cartlist=new ArrayList<Cart>();
		try
		{
			ps=con.prepareStatement(showCart);
			ps.setString(1, customerEmailId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				cart =new Cart
						(
								rs.getInt("cart_id"),
								rs.getInt("grocery_id"),
								rs.getString("grocery_name"),
								rs.getString("customer_emailid"),
								rs.getInt("grocery_qty"),
								rs.getDouble("grocery_price")
						);
				cartlist.add(cart);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return cartlist;
	}

	@Override
	public boolean updateGroceryQuantity(int cartId, int groceryQuantity) 
	{
		try
		{
			ps = con.prepareStatement("update cart_22063 set grocery_qty=? where cart_id=?");
			ps.setInt(1, groceryQuantity);
			ps.setInt(2, cartId);
			
			row = ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(row > 0)
			return true;
		else
			return false;
		
	}

}
