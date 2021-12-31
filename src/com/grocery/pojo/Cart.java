package com.grocery.pojo;

public class Cart 
{
	private int cartId,groceryId,groceryQty;
	private String customerEmailId,groceryName;
	private double groceryPrice;
	
	public Cart()
	{
		
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getGroceryId() {
		return groceryId;
	}
	public void setGroceryId(int groceryId) {
		this.groceryId = groceryId;
	}
	public int getGroceryQty() {
		return groceryQty;
	}
	public void setGroceryQty(int groceryQty) {
		this.groceryQty = groceryQty;
	}
	public double getGroceryPrice() {
		return groceryPrice;
	}
	public void setGroceryPrice(double groceryPrice) {
		this.groceryPrice = groceryPrice;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getGroceryName() {
		return groceryName;
	}
	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}
	public Cart(int groceryId, String customerEmailId, int groceryQty) {
		super();
		this.groceryId = groceryId;
		this.customerEmailId = customerEmailId;
		this.groceryQty = groceryQty;
	}
	public Cart(int cartId, int groceryId, String groceryName, String customerEmailId, int groceryQty,
			double groceryPrice) {
		super();
		this.cartId = cartId;
		this.groceryId = groceryId;
		this.groceryName = groceryName;
		this.customerEmailId = customerEmailId;
		this.groceryQty = groceryQty;
		this.groceryPrice = groceryPrice;
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", groceryId=" + groceryId + ", groceryName=" + groceryName
				+ ", customerEmailId=" + customerEmailId + ", groceryQty=" + groceryQty + ", groceryPrice="
				+ groceryPrice + "]";
	}
	
	
	
	
		
	
	
}
