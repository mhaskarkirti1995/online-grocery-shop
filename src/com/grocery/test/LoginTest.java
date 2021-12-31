package com.grocery.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.grocery.dao.LoginDaoImpl;
import com.grocery.pojo.Login;

public class LoginTest 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		Login login;
		int choice;
		String userName,password,newPassword;
		boolean flag;
		LoginDaoImpl ldao=new LoginDaoImpl();
				
		 while(true)
		 {
			 System.out.println("Enter\n"
			 				+ "1. Admin Login \n"
			 				+ "2. Admin Change Password\n"
			 				+ "3. User Login  \n"
			 				+ "4. User Change Password\n"
			 				+ "5. Exit");
			 
			 choice=scanner.nextInt();
			 
			 switch(choice)
			 {
			 case 1:
				 System.out.println("----Admin Login----");
				 System.out.println("Enter User Name");
				 userName=br.readLine();
				 System.out.println("Enter Password");
				 password=br.readLine();
				 
				 flag=ldao.adminLogin(userName, password);
				 
				 if(flag)
					 System.out.println("Successfully Login");
				 else
					 System.out.println("Failed");
				 break;
				 
			 case 2:
				 System.out.println("----Admin Change Password----");
				 System.out.println("Enter User Name");
				 userName=br.readLine();
				 System.out.println("Enter Password");
				 newPassword=br.readLine();
				 
				 flag= ldao.adminChangePassword(userName, newPassword);
				 
				 if(flag)
					 System.out.println("Successfully Changed Password");
				 else
					 System.out.println("Failed");
				 break;
			 case 3:
				 System.out.println("----User Login----");
				 System.out.println("Enter User Name");
				 userName=br.readLine();
				 System.out.println("Enter Password");
				 password=br.readLine();
				 
				 flag=ldao.userLogin(userName, password);
				 
				 if(flag)
					 System.out.println("Successfully Login");
				 else
					 System.out.println("Failed");
				 break;
			 case 4:
				 System.out.println("----User Change Password----");
				 System.out.println("Enter User Name");
				 userName=br.readLine();
				 System.out.println("Enter New Password");
				 newPassword=br.readLine();
				 
				 flag=ldao.userChangePassword(userName, newPassword);
				 if(flag)
					 System.out.println("Successfully chnage password");
				 else
					 System.out.println("Failed");

			break;
			 }
		 }
		
	}

}
