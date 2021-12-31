package com.grocery.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grocery.dbutility.DBUtility;
import com.grocery.pojo.Order;

public class OrderDaoImpl implements OrderDao
{
	Connection con=DBUtility.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	String status="Processing";
	double totalBill;
	Order order=new Order();
	long ms=System.currentTimeMillis();
	Date orderDate= new Date(ms);
	//Date date=new Date();
	//String orderDate=date.toString();
	CartDaoImpl cdao=new CartDaoImpl();
	int row;
	
	String placeOrder="insert into orders_22063 (customer_emailid,order_status,order_date,total_bill) values(?,?,?,?)";
	String showOrdersToCust="select * from orders_22063 where customer_emailid=?";
	String showOrdersToAdmin="select * from orders_22063";
	String searchOrderByEmailId="select * from orders_22063 where customer_emailid like ?";
	
	@Override
	public Order placeOrder(String customerEmailId) //core
	{
		try
		{
			//totalBill
			ps=con.prepareStatement("select sum(g.grocery_price * c.grocery_qty) as TotalBill from grocery_22063 g inner join "
					+ "cart_22063 c on g.grocery_id=c.grocery_id where customer_emailid=?");
			
			ps.setString(1, customerEmailId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				totalBill=rs.getDouble("TotalBill");
				ps=con.prepareStatement(placeOrder);
				
				ps.setString(1, customerEmailId);
				ps.setString(2, status);
				ps.setDate(3, orderDate);
				ps.setDouble(4, totalBill);
				
				row=ps.executeUpdate();
				cdao.clearCart(customerEmailId);//for clear cart once order placed
				
				if(row>0)
				{
					ps=con.prepareStatement("select * from orders_22063 where customer_emailid=? and order_date=?");
					ps.setString(1,customerEmailId);
					ps.setDate(2, orderDate);
					
					rs=ps.executeQuery();
					if(rs.next())
					{
						order.setOrderId(rs.getInt("order_id"));
						order.setCustomerEmailId(rs.getString("customer_emailid"));
						order.setOrderStatus(rs.getString("order_status"));
						order.setOrderDate(rs.getString("order_date"));
						order.setTotalBill(rs.getDouble("total_bill"));
					}
					
				}
			}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();;
		}
		return order;
	}

	@Override
	public Order placeOrder(String customerEmailId, double totalBill)//advanced 
	{
		try
		{
			ps=con.prepareStatement(placeOrder);
			ps.setString(1, customerEmailId);
			ps.setString(2, status);
			ps.setDate(3, orderDate);
			ps.setDouble(4, totalBill);
			
			row=ps.executeUpdate();
			cdao.clearCart(customerEmailId);//for clear cart once order placed
			
			if(row>0)
			{
				ps=con.prepareStatement("select * from orders_22063 where customer_emailid=? and order_date=? order by order_id desc");
				ps.setString(1,customerEmailId);
				ps.setDate(2, orderDate);
				
				rs=ps.executeQuery();
				if(rs.next())
				{
					order.setOrderId(rs.getInt("order_id"));
					order.setCustomerEmailId(rs.getString("customer_emailid"));
					order.setOrderStatus(rs.getString("order_status"));
					order.setOrderDate(rs.getString("order_date"));
					order.setTotalBill(rs.getDouble("total_bill"));
				}
			}
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> showAllOrder(String customerEmailId) 
	{
		List<Order> orderlist=new ArrayList<Order>();
		try
		{
			ps=con.prepareStatement(showOrdersToCust);
			
			ps.setString(1, customerEmailId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				order=new Order
					(
						rs.getString("customer_emailid"),
						rs.getString("order_status"),
						rs.getString("order_date"),
						rs.getDouble("total_bill")
						
					);
				order.setOrderId(rs.getInt("order_id"));
				orderlist.add(order);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return orderlist;
	}

	@Override
	public List<Order> showAllOrder() 
	{
		List<Order> orderlist=new ArrayList<Order>();
	try
	{
		ps=con.prepareStatement(showOrdersToAdmin);
		
		rs=ps.executeQuery();
		
		while(rs.next())
		{
			order=new Order
				(
					rs.getString("customer_emailid"),
					rs.getString("order_status"),
					rs.getString("order_date"),
					rs.getDouble("total_bill")
					
				);
			order.setOrderId(rs.getInt("order_id"));
			orderlist.add(order);
			
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return orderlist;
	}

	@Override
	public boolean cancelOrder(int orderId)
	{
		try
		{
			ps=con.prepareStatement("update orders_22063 set order_status=? where order_id=?");
			ps.setString(1, "Cancelled");
			ps.setInt(2, orderId);
			
			row=ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public List<Order> searchOrderByCustomerEmailId(String customerEmailId) 
	{
		List<Order> ordlist = new ArrayList<Order>();
		try
		{
			ps=con.prepareStatement("select * from orders_22063 where customer_emailid like ?");
			ps.setString(1,"%"+ customerEmailId + "%");
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				order=new Order
					(
						rs.getString("customer_emailid"),
						rs.getString("order_status"),
						rs.getString("order_date"),
						rs.getDouble("total_bill")
						
					);
				order.setOrderId(rs.getInt("order_id"));
				ordlist.add(order);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ordlist;
	}

	
}
