package com.training.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDaoImp1 implements ProductDao{

	public  int insert(Product p) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			Connection conn =getconnection();
			System.out.println(conn.toString());// checking connection
			Statement stmt = conn.createStatement();
			String sqlstring = "insert into Product values (" + p.getpId() + ",'" + p.getpName() + "'," + p.getPrice() + ")";
			System.out.println("SQL String = " + sqlstring);
			i = stmt.executeUpdate(sqlstring);
			if (i>0) {
			System.out.println ("Product is inserted successfully");
		} else{
			System.out.println ("Product is  not inserted successfully");
			
		}
		}
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return i;
	
	}
	@Override
	public ArrayList listProductDetails() {
		// TODO Auto-generated method stub
		ArrayList productList = new ArrayList();
		Connection conn;
		try {
			conn = getconnection();
			System.out.println(conn.toString());// checking connection
			Statement stmt = conn.createStatement();
			String sqlstring = "select pid,pname,price from product";
			System.out.println("SQL String = " + sqlstring);
			ResultSet rs=stmt.executeQuery(sqlstring);
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				productList.add(p);
			}
			rs.close();
	           stmt.close();
	           conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}
private static Connection getconnection() throws SQLException {
	Connection conn = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","Quinnox!23$");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
	}
public static void main(String[] args) {
System.out.println ("Trying to get connection from mysql database");
try {
	Connection conn = getconnection();
	System.out.println(conn.toString());// checking connection
	conn.close();
	ProductDaoImp1 pd1 = new ProductDaoImp1();
	Product p = new Product(1004,"air fryer Oven",5500);
	int result =pd1.insert(p);
	System.out.println(" result is = " + result);
	ArrayList productList = pd1.listProductDetails();
	System.out.println("Number of products = " + productList.size() + ((Product)productList.get(0)).getpName());
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}