package com.grocery.dao;

import java.util.List;

import com.grocery.pojo.Grocery;

public interface GroceryDao 
{
	boolean addGrocery(Grocery grocery);
	boolean updateGrocery(Grocery grocery);
	boolean deleteGrocery(int groceryId);
	Grocery searchGroceryById(int groceryId);
	List<Grocery> searchGoceryByGroceryName(String groceryName);
	List<Grocery> searchGoceryByGroceryBrand(String groceryBrand);
	List<Grocery> sortGroceryByGroceryName(String groceryName);
	List<Grocery> filterGroceryByGroceryNameAndBrand(String groceryName,String groceryBrand);
	List<Grocery> showAllGrocery();
}
