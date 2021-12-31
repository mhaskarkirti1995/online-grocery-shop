package com.grocery.dao;

import java.util.List;

import com.grocery.pojo.Order;

public interface OrderDao 
{
	Order placeOrder(String customerEmailId);//core
	Order placeOrder(String customerEmailId, double totalBill);//adv
	List<Order> showAllOrder(String customerEmailId);//customer
	List<Order> showAllOrder();//admin
	List<Order> searchOrderByCustomerEmailId(String customerEmailId );
	boolean cancelOrder(int orderId);
}
