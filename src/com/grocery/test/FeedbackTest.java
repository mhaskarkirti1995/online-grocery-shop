package com.grocery.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grocery.dao.FeedbackDaoImpl;
import com.grocery.pojo.Feedback;

public class FeedbackTest {

	public static void main(String[] args) throws IOException
	{
		Scanner scanner=new Scanner(System.in);
		BufferedReader bufferreader=new BufferedReader(new InputStreamReader(System.in));
		
		int feedbackId,rateGrocery,choice;
		String customerEmailId,suggestion,rateUs;
		boolean flag;
		Feedback feedback;
		FeedbackDaoImpl fdao= new FeedbackDaoImpl();
		List<Feedback> feedlist=new ArrayList<>();
		
		 while(true)
			{
			System.out.println("Enter\n"
					+ "1. Add Feedback\n"
					+ "2. Show All Feedback\n"
					+ "3. Exit ");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("----Add Feedback----");
				System.out.println("Enter customer emailID : ");
				customerEmailId=bufferreader.readLine();
				System.out.println("Enter rating for grocery : ");
				rateGrocery=scanner.nextInt();
				System.out.println("Enter rating for our service: ");
				rateUs=bufferreader.readLine();
				System.out.println("Enter suggestion : ");
				suggestion=bufferreader.readLine();
				
				feedback = new Feedback(customerEmailId, rateGrocery, rateUs, suggestion);
				
				flag=fdao.addFeedback(feedback);
				if(flag=true)
					System.out.println("Feedback added Successfully");
				else
					System.out.println("Failed");
			break;
			case 2:
				System.out.println("----All Feedback----");
				
				feedlist=fdao.displayAllFeedback();
				
				if(!feedlist.isEmpty())
				{
					for(Feedback feed : feedlist )
					{
						System.out.println(feed);
					}
				}
				else
					System.out.println("No such Feedback");
			break;
			}
			}
		 	 
	}

}
