package com.grocery.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.grocery.dao.GroceryDaoImpl;
import com.grocery.pojo.Grocery;

public class GroceryTest {

	public static void main(String[] args) throws IOException 
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int groceryId;
		String groceryName,groceryType,groceryBrand,groceryDescription;
		int groceryQty,choice;
		String mfgDate,expiryDate;
		double groceryPrice;
		String availableIn;
		GroceryDaoImpl gdao=new GroceryDaoImpl();
		Grocery grocery;
		boolean flag;
		List<Grocery> list=new ArrayList<Grocery>();
		
		while(true)
		{
			System.out.println("Enter \n"
					+ "1. Add Grocery Details\n"
					+ "2. Update Grocery Details \n"
					+ "3. Delete Grocery \n"
					+ "4. Search Grocery By ID \n"
					+ "5. Search Grocery By Grocery Name\n"
					+ "6. Search Grocery By Grocery Brand\n"
					+ "7. Show All Grocery\n"
					+ "8. Exit");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				
				System.out.println("----Add Grocery Details----");
				System.out.println("Enter Grocery Name : ");
				groceryName=br.readLine();
				System.out.println("Enter Grocery Type : ");
				groceryType=br.readLine();
				System.out.println("Enter Grocery Brand : ");
				groceryBrand=br.readLine();
				System.out.println("Enter Grocery Description : ");
				groceryDescription=br.readLine();
				System.out.println("Enter Grocery Quantity : ");
				groceryQty=scanner.nextInt();
				System.out.println("Enter Manufacture Date : ");
				mfgDate=br.readLine();
				System.out.println("Enter Expiry Date : ");
				expiryDate=br.readLine();
				System.out.println("Enter Grocery Available In : ");
				availableIn=br.readLine();
				System.out.println("Enter Grocery Price : ");
				groceryPrice=scanner.nextDouble();
				
				grocery=new Grocery(groceryName, groceryType, groceryBrand, groceryDescription, groceryQty, mfgDate, expiryDate, availableIn, groceryPrice);
				flag=gdao.addGrocery(grocery);
				if(flag==true)
					System.out.println("Grocery Added Successfully");
				else
					System.out.println("Failed");
				
			break;
			case 2:
				System.out.println("----Update Grocery Details----");
				System.out.println("Enter Existing Grocery Id :");
				groceryId=scanner.nextInt();
				
				list=gdao.showAllGrocery();
				Grocery objGrocery=null;
				Iterator<Grocery> itr=list.iterator();
				while(itr.hasNext())
				{
					Grocery gro=itr.next();
					if(gro.getGroceryId()==groceryId)
					{
						objGrocery=gro;
					}
				}
				if(objGrocery !=null && objGrocery.getGroceryId()>0)
				{
					System.out.println("Enter Grocery Name : ");
					groceryName=br.readLine();
					System.out.println("Enter Grocery Type : ");
					groceryType=br.readLine();
					System.out.println("Enter Grocery Brand : ");
					groceryBrand=br.readLine();
					System.out.println("Enter Grocery Description : ");
					groceryDescription=br.readLine();
					System.out.println("Enter Grocery Quantity : ");
					groceryQty=scanner.nextInt();
					System.out.println("Enter Manufacture Date : ");
					mfgDate=br.readLine();
					System.out.println("Enter Expiry Date : ");
					expiryDate=br.readLine();
					System.out.println("Enter Grocery Available In : ");
					availableIn=br.readLine();
					System.out.println("Enter Grocery Price : ");
					groceryPrice=scanner.nextDouble();
					
					grocery=new Grocery(groceryName, groceryType, groceryBrand, groceryDescription, groceryQty, mfgDate, expiryDate, availableIn, groceryPrice);
					grocery.setGroceryId(groceryId);
					flag=gdao.updateGrocery(grocery);
					if(flag==true)
					{
						System.out.println("Grocery updated successfully");
					}
					else
					{
						System.out.println("Failed");
					}
				}
				else
				{
					System.out.println("Enter valid Grocery Id");
				}
				
				
			break;
			case 3:
				System.out.println("----Delete Grocery----");
				System.out.println("Enter Existing Grocery Id :");
				groceryId=scanner.nextInt();
				flag=gdao.deleteGrocery(groceryId);
				if(flag==true)
				{
					System.out.println("Grocery deleted successfully");
				}
				else
				{
					System.out.println("Enter valid Grocery Id");
				}
			break;
			case 4:
				System.out.println("----Search Grocery By ID----");
				System.out.println("Enter Existing Grocery Id :");
				groceryId=scanner.nextInt();
				
				grocery=gdao.searchGroceryById(groceryId);
				
				if(grocery !=null)
				{
					System.out.println(grocery);
				}
				else
				{
					System.out.println("No such id");
				}
				
			break;
			case 5:
				System.out.println("----Search Grocery By Name----");
				System.out.println("Enter Grocery Name :");
				groceryName=br.readLine();
				
				list=gdao.searchGoceryByGroceryName(groceryName);
				
				if(!list.isEmpty())
				{
					for(Grocery gro:list)
					{
						System.out.println(gro);
					}
				}
				else
				{
					System.out.println("No such grocery");
				}
			break;
			case 6:
				System.out.println("----Search Grocery By  Brand----");
				System.out.println("Enter Grocery Brand :");
				groceryBrand=br.readLine();
				list=gdao.searchGoceryByGroceryBrand(groceryBrand);
				if(!list.isEmpty())
				{
					for(Grocery gro:list)
					{
						System.out.println(gro);
					}
				}
				else
				{
					System.out.println("No such Brand");
				}
			break;
			case 7:
				System.out.println("----All Grocery Details----");
				list=gdao.showAllGrocery();
				if(!list.isEmpty())
				{
					for(Grocery grolist:list)
					{
						System.out.println(grolist);
					}
				}
				else
				{
					System.out.println("No such Grocery........");
				}
			break;
			case 8:
				System.exit(0);
			default:
				System.out.println("Please Enter valid choice");
			}
			
		}
		
	}

}
