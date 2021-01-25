package main;

import java.util.Scanner;

import SalesInsertion.Dao;
import bean.SalesBean;

import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class SalesMain {
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[]) throws ClassNotFoundException, SQLException {	
		SalesBean sb=new SalesBean();
		Dao db=new Dao();
		while(true) {
			System.out.println("Enter option\n");
			System.out.println("1.INSERTION\n");
			System.out.println("2.DISPLAY\n");
			System.out.println("3.TOTAL\n");
			int option=sc.nextInt();
			switch(option) {
				case 1:	System.out.println("No of items you bought");
						int n=sc.nextInt();
						for(int i=0;i<n;i++) {
							System.out.println("Enter itemId");
					    	 int id=sc.nextInt();
					    	 System.out.println("Enter itemName");
					    	 String name=sc.next();
					    	 System.out.println("Enter cost");
					    	 int cost=sc.nextInt();
								sb.setItemid(id);
								sb.setItemname(name);
								sb.setCost(cost);
							int a=db.SalesInsert(sb);
							if(a>0) {
								System.out.println("Insertion sucessful!!");
							}
							else {
								System.out.println("Insertion failed");
							}
							
						}
						break;
						
				case 2:db.Salesdisplay(sb);
						break;
				case 3:db.TotalCost(sb);
						break;
			}
		
	}
	}
}