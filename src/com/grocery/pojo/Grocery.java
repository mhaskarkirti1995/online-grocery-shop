package com.grocery.pojo;

import java.io.InputStream;

public class Grocery 
{
	private int groceryId;
	private String groceryName,groceryType,groceryBrand,groceryDescription;
	private int groceryQty;
	private String mfgDate,expiryDate;
	private double groceryPrice;
	private String availableIn;
	private InputStream groceryImage;
	
	public InputStream getGroceryImage() {
		return groceryImage;
	}
	public void setGroceryImage(InputStream groceryImage) {
		this.groceryImage = groceryImage;
	}
	public int getGroceryId() {
		return groceryId;
	}
	public void setGroceryId(int groceryId) {
		this.groceryId = groceryId;
	}
	public String getGroceryName() {
		return groceryName;
	}
	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}
	public String getGroceryType() {
		return groceryType;
	}
	public void setGroceryType(String groceryType) {
		this.groceryType = groceryType;
	}
	public String getGroceryBrand() {
		return groceryBrand;
	}
	public void setGroceryBrand(String groceryBrand) {
		this.groceryBrand = groceryBrand;
	}
	public String getGroceryDescription() {
		return groceryDescription;
	}
	public void setGroceryDescription(String groceryDescription) {
		this.groceryDescription = groceryDescription;
	}
	public int getGroceryQty() {
		return groceryQty;
	}
	public void setGroceryQty(int groceryQty) {
		this.groceryQty = groceryQty;
	}
	public String getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public double getGroceryPrice() {
		return groceryPrice;
	}
	public void setGroceryPrice(double groceryPrice) {
		this.groceryPrice = groceryPrice;
	}
	
	public String getAvailableIn() {
		return availableIn;
	}
	public void setAvailableIn(String availableIn) {
		this.availableIn = availableIn;
	}
	public Grocery(String groceryName, String groceryType, String groceryBrand,
			String groceryDescription, int groceryQty, String mfgDate, String expiryDate, String availableIn,
			double groceryPrice) {
		super();
	//	this.groceryId = groceryId;
		this.groceryName = groceryName;
		this.groceryType = groceryType;
		this.groceryBrand = groceryBrand;
		this.groceryDescription = groceryDescription;
		this.groceryQty = groceryQty;
		this.mfgDate = mfgDate;
		this.expiryDate = expiryDate;
		this.availableIn = availableIn;
		this.groceryPrice = groceryPrice;
	}
	
	@Override
	public String toString() {
		return "Grocery [groceryId=" + groceryId + ", groceryName=" + groceryName + ", groceryType=" + groceryType
				+ ", groceryBrand=" + groceryBrand + ", groceryDescription=" + groceryDescription + ", groceryQty="
				+ groceryQty + ", mfgDate=" + mfgDate + ", expiryDate=" + expiryDate + ", availableIn=" + availableIn
				+ ", groceryPrice=" + groceryPrice + "]";
	}
	
	
}
