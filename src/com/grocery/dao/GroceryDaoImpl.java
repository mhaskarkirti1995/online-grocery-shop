package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.grocery.dbutility.DBUtility;
import com.grocery.pojo.Grocery;

public class GroceryDaoImpl implements GroceryDao 
{
	Connection con=DBUtility.getConnection();
	int row;
	PreparedStatement ps;
	ResultSet rs;
	Grocery grocery;
	String addGrocery="insert into grocery_22063(grocery_name,grocery_type,grocery_brand,grocery_description,grocery_qty,mfg_date,expiry_date,available_in,grocery_price,grocery_image) values(?,?,?,?,?,?,?,?,?,?)";
	String updateGrocery="update grocery_22063 set grocery_name=?, grocery_type=?, grocery_brand=?, grocery_description=? ,grocery_qty=? ,mfg_date=?, expiry_date=?, available_in=?, grocery_price=?, grocery_image=? where grocery_id=?";
	String deleteGrocery="delete from grocery_22063 where grocery_id=?";
	String searchById="select * from grocery_22063 where grocery_id=?";
	String searchByName="select * from grocery_22063 where grocery_name=?";
	String searchByBrand="select * from grocery_22063 where grocery_brand=?";
	String showAllGrocery="select * from grocery_22063";
	
	@Override
	public boolean addGrocery(Grocery grocery) 
	{
		try
		{
			ps=con.prepareStatement(addGrocery);
			ps.setString(1, grocery.getGroceryName());
			ps.setString(2, grocery.getGroceryType());
			ps.setString(3, grocery.getGroceryBrand());
			ps.setString(4, grocery.getGroceryDescription());
			ps.setInt(5, grocery.getGroceryQty());
			ps.setString(6, grocery.getMfgDate());
			ps.setString(7, grocery.getExpiryDate());
			ps.setString(8, grocery.getAvailableIn());
			ps.setDouble(9, grocery.getGroceryPrice());
			ps.setBinaryStream(10, grocery.getGroceryImage());
			
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
	public boolean updateGrocery(Grocery grocery) 
	{
		try
		{
			ps=con.prepareStatement(updateGrocery);
			ps.setString(1, grocery.getGroceryName());
			ps.setString(2, grocery.getGroceryType());
			ps.setString(3, grocery.getGroceryBrand());
			ps.setString(4, grocery.getGroceryDescription());
			ps.setInt(5, grocery.getGroceryQty());
			ps.setString(6, grocery.getMfgDate());
			ps.setString(7, grocery.getExpiryDate());
			ps.setString(8, grocery.getAvailableIn());
			ps.setDouble(9, grocery.getGroceryPrice());
			ps.setBinaryStream(10, grocery.getGroceryImage());
			ps.setInt(11, grocery.getGroceryId());

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
	public boolean deleteGrocery(int groceryId) 
	{
		try
		{
			ps=con.prepareStatement(deleteGrocery);
			ps.setInt(1, groceryId);
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
	public Grocery searchGroceryById(int groceryId) 
	{
		try
		{
			ps=con.prepareStatement(searchById);
			ps.setInt(1, groceryId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				grocery=new Grocery
						(
								rs.getString("grocery_name"),
								rs.getString("grocery_type"),
								rs.getString("grocery_brand"),
								rs.getString("grocery_description"),
								rs.getInt("grocery_qty"),
								rs.getString("mfg_date"),
								rs.getString("expiry_date"),
								rs.getString("available_in"),
								rs.getInt("grocery_price")
						);
						grocery.setGroceryId(rs.getInt("grocery_id"));
						grocery.setGroceryImage(rs.getBinaryStream("grocery_image"));
						return grocery;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Grocery> searchGoceryByGroceryName(String groceryName) 
	{
		List<Grocery> grolist=new ArrayList<Grocery>();
		try
		{
			ps=con.prepareStatement("select * from grocery_22063 where grocery_name like ? or grocery_brand like ? ");
			ps.setString(1, "%"+groceryName+"%");
			ps.setString(2, "%"+groceryName+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				grocery = new Grocery
						(
								rs.getString("grocery_name"),
								rs.getString("grocery_type"),
								rs.getString("grocery_brand"),
								rs.getString("grocery_description"),
								rs.getInt("grocery_qty"),
								rs.getString("mfg_date"),
								rs.getString("expiry_date"),
								rs.getString("available_in"),
								rs.getInt("grocery_price")
						);
							grocery.setGroceryId(rs.getInt("grocery_id"));
							grocery.setGroceryImage(rs.getBinaryStream("grocery_image"));
							grolist.add(grocery);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return grolist;
	}

	@Override
	public List<Grocery> searchGoceryByGroceryBrand(String groceryBrand) 
	{
		List<Grocery> grolist=new ArrayList<>();
		try
		{
			ps=con.prepareStatement(searchByBrand);
			ps.setString(1, groceryBrand);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				grocery=new Grocery
						(
								rs.getString("grocery_name"),
								rs.getString("grocery_type"),
								rs.getString("grocery_brand"),
								rs.getString("grocery_description"),
								rs.getInt("grocery_qty"),
								rs.getString("mfg_date"),
								rs.getString("expiry_date"),
								rs.getString("available_in"),
								rs.getInt("grocery_price")
						);
					grocery.setGroceryId(rs.getInt("grocery_id"));
					grocery.setGroceryImage(rs.getBinaryStream("grocery_image"));
					grolist.add(grocery);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return grolist;
	}

	@Override
	public List<Grocery> showAllGrocery() 
	{
		List<Grocery> grolist=new ArrayList<Grocery>();
		try
		{
			ps=con.prepareStatement(showAllGrocery);
			rs=ps.executeQuery();
			while(rs.next())
			{
				grocery=new Grocery
						(
							rs.getString("grocery_name"),
							rs.getString("grocery_type"),
							rs.getString("grocery_brand"),
							rs.getString("grocery_description"),
							rs.getInt("grocery_qty"),
							rs.getString("mfg_date"),
							rs.getString("expiry_date"),
							rs.getString("available_in"),
							rs.getInt("grocery_price")
						);
				grocery.setGroceryId(rs.getInt("grocery_id"));
				grocery.setGroceryImage(rs.getBinaryStream("grocery_image"));
				grolist.add(grocery);
				
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return grolist;
	}

	@Override
	public List<Grocery> sortGroceryByGroceryName(String groceryName) 
	{
		List<Grocery> grolist = new ArrayList<Grocery>();
		try
		{
			ps=con.prepareStatement("select * from grocery_22063 order by grocery_name asc");
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				grocery=new Grocery
						(
							rs.getString("grocery_name"),
							rs.getString("grocery_type"),
							rs.getString("grocery_brand"),
							rs.getString("grocery_description"),
							rs.getInt("grocery_qty"),
							rs.getString("mfg_date"),
							rs.getString("expiry_date"),
							rs.getString("available_in"),
							rs.getInt("grocery_price")
						);
				grocery.setGroceryId(rs.getInt("grocery_id"));
				grocery.setGroceryImage(rs.getBinaryStream("grocery_image"));
				grolist.add(grocery);
				
			}
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return grolist;
	}

	@Override
	public List<Grocery> filterGroceryByGroceryNameAndBrand(String groceryName, String groceryBrand) 
	{
		List<Grocery> grolist=new ArrayList<Grocery>();
		try
		{
			ps=con.prepareStatement("select * from grocery_22063 where grocery_name like ? and grocery_brand like ? ");
			ps.setString(1, "%"+groceryName+"%");
			ps.setString(2, "%"+groceryBrand+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				grocery = new Grocery
						(
								rs.getString("grocery_name"),
								rs.getString("grocery_type"),
								rs.getString("grocery_brand"),
								rs.getString("grocery_description"),
								rs.getInt("grocery_qty"),
								rs.getString("mfg_date"),
								rs.getString("expiry_date"),
								rs.getString("available_in"),
								rs.getInt("grocery_price")
						);
							grocery.setGroceryId(rs.getInt("grocery_id"));
							grocery.setGroceryImage(rs.getBinaryStream("grocery_image"));
							grolist.add(grocery);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return grolist;	
	}

}
