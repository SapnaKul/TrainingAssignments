package com.training.ui;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) { 
		
Scanner sc= new Scanner(System.in);
		
	
			System.out.println("enter the value for product id " );
			int pid =sc.nextInt();
			System.out.println("enter the value for product name " );
			String pname =sc.next();
			System.out.println("enter the value for price " );
			double price = sc.nextDouble();
			System.out.println(pid + " , " + pname + " , " + price);
			Product p = new Product(pid, pname, price);
			ProductDaoImp1 pd1 = new ProductDaoImp1(); // creating the object of ProductDAOImp1
			pd1.insert(p);
			ArrayList productList = pd1.listProductDetails();
			int i = productList.size() - 1;
			System.out.println("Number of products = " + productList.size() + ((Product)productList.get(i)).getpName());
}
}
