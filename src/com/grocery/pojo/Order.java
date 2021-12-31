package com.grocery.pojo;

public class Order 
{
	private int orderId;
	private String customerEmailId,orderDate,orderStatus;
	private double totalBill;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	public Order()
	{
		
	}
	public Order(String customerEmailId, String orderStatus, String orderDate, double totalBill) {
		super();
	//	this.orderId = orderId;
		this.customerEmailId = customerEmailId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalBill = totalBill;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerEmailId=" + customerEmailId + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + ", totalBill=" + totalBill + "]";
	}
	
	
	
	
	
}
