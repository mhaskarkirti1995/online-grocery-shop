package com.grocery.dao;

import java.util.List;

import com.grocery.pojo.Cart;

public interface CartDao
{
	boolean addToCart(Cart cart);
	boolean deleteFromCart(int cartId);
	boolean clearCart(String customerEmailId);
	List<Cart> showCart(String customerEmailId);
	boolean updateGroceryQuantity(int cartId, int groceryQuantity);
	
}
