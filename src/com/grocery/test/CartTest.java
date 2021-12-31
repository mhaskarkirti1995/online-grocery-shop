package com.grocery.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grocery.dao.CartDaoImpl;
import com.grocery.pojo.Cart;

public class CartTest 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Cart cart;
		CartDaoImpl cdao=new CartDaoImpl();
		boolean flag;
		
		int cartId,groceryId,groceryQty,choice;
		String customerEmailId,groceryName;
		double groceryPrice;
		List<Cart> cartlist =new ArrayList<>();
		
		 while(true)
		 {
			 System.out.println("Enter\n"
			 				+ "1. AddToCart \n"
			 				+ "2. Delete From Cart\n"
			 				+ "3. Clear Cart \n"
			 				+ "4. Show Cart\n"
			 				+ "5. Exit");
			 
			 choice=scanner.nextInt();
			 
			 switch(choice)
			 {
			 case 1:
				 System.out.println("----Add To Cart----");
				 System.out.println("Enter Grocery Id");
				 groceryId=scanner.nextInt();
				 System.out.println("Enter Customer Email Id");
				 customerEmailId=br.readLine();
				 System.out.println("Enter Quantity");
				 groceryQty=scanner.nextInt();
				 
				 cart =new Cart(groceryId, customerEmailId, groceryQty);
				 flag=cdao.addToCart(cart);
				 
				 if(flag)
					 System.out.println("sucessfully added");
				 else
					 System.out.println("Failed");
				 break;
			 case 2:
				 System.out.println("----Delete From Cart----");
				 System.out.println("Enter Existing Cart Id");
				 cartId=scanner.nextInt();
				 
				 flag=cdao.deleteFromCart(cartId);
				 if(flag=true)
					 System.out.println("Grocery deleted successfully");
				 else
					 System.out.println("Failed");
				 break;
			 case 3:
				 System.out.println("----Clear Cart----");
				 System.out.println("Enter Existing Customer Email Id");
				 customerEmailId=br.readLine();
				 
				 flag=cdao.clearCart(customerEmailId);
				 if(flag)
					 System.out.println("Successfully clear cart");
				 else
					 System.out.println("Failed");
				 break;
			 case 4:
				 System.out.println("----Show Cart----");
				 System.out.println("Enter Existing Customer Email Id");
				 customerEmailId=br.readLine();
				 
				 cartlist=cdao.showCart(customerEmailId);
				 if(!cartlist.isEmpty())
				 {
					 for(Cart obj : cartlist)
					 {
						 System.out.println(obj);
					 }
				 }
				 else
					 System.out.println("No such order");
				 
				 break;
			 case 5:
				 System.exit(0);
			default:
				System.out.println("Enter valid choice");
			 }
		 }
		 
	}

}
