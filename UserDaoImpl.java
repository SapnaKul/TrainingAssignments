package com.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

	@Override
	public int insert(User u) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			Connection conn =getconnection();
			System.out.println(conn.toString());// checking connection
			Statement stmt = conn.createStatement();
			String sqlstring = "insert into User_table values (" + u.getUserId() + ",'" + u.getUserName() + "','" + u.getEmail() + "','" + u.getCountry() + "')";
			System.out.println("SQL String = " + sqlstring);
			i = stmt.executeUpdate(sqlstring);
			if (i>0) {
			System.out.println ("User is inserted successfully");
		} else{
			System.out.println ("User is  not inserted successfully");
			
		}
		}
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return i;
	
	}
	

	@Override
	public ArrayList listUsers() {
		// TODO Auto-generated method stub
		ArrayList userList = new ArrayList();
		Connection conn;
		try {
			conn = getconnection();
			System.out.println(conn.toString());// checking connection
			Statement stmt = conn.createStatement();
			String sqlstring = "select id,name,email,country from user_Table";
			System.out.println("SQL String = " + sqlstring);
			ResultSet rs=stmt.executeQuery(sqlstring);
			while(rs.next()) {
				User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				userList.add(u);
			}
			rs.close();
	           stmt.close();
	           conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	

	
	  @Override
	public User getUser(int userId) {// // TODO Auto-generated
		  Connection conn;
		  User u = null;
			try {
				conn = getconnection();
				System.out.println(conn.toString());// checking connection
				Statement stmt = conn.createStatement();
				String sqlstring = "select id,name,email,country from user_Table where id = " + userId;
				System.out.println("SQL String = " + sqlstring);
				ResultSet rs=stmt.executeQuery(sqlstring);
				while(rs.next()) {
					u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
					System.out.println("User Name = " + rs.getString(2));
				}
				rs.close();
		           stmt.close();
		           conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  return u; }
	  
	  @Override public int updateUser(User u) { // TODO Auto-generated method stub
		  Connection conn;
		  int i = 0;
		  try {
			conn = getconnection();
			Statement stmt = conn.createStatement();
			String sqlstring = "update user_table set name = '" + u.getUserName() + "', email = '" + u.getEmail() + "' , country = '" +u.getCountry() +"' where id = " + u.getUserId();
			System.out.println("SQL String = " + sqlstring);
			i = stmt.executeUpdate(sqlstring);
			if (i>0) {
			System.out.println ("User is update successfully");
		} else{
			System.out.println ("User is  not updated successfully");
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  return i; }
	  
	  @Override public int deleteUser(int userId) { // TODO Auto-generated method stub 
		  Connection conn;
		  int i = 0;
		  
		  try {
			conn = getconnection();
			Statement stmt = conn.createStatement();
			  String sqlstring = "delete from user_table where id = " + userId;
				System.out.println("SQL String = " + sqlstring);
				i = stmt.executeUpdate(sqlstring);
				if (i>0) {
				System.out.println ("User is Delete successfully");
			} else{
				System.out.println ("User is  not Deleted successfully");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return 1; }
	  
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println ("Trying to get connection from mysql database");
		try {
			Connection conn = getconnection();
			System.out.println(conn.toString());// checking connection
			UserDaoImpl ud1 = new UserDaoImpl();
			User u = new User(3, "Derek", "derek@outlook.com", "USA");
			int result = ud1.insert(u);
			System.out.println(" result is = " + result); 
			conn.close();
			ArrayList userList = ud1.listUsers(); 
			System.out.println("Number of Users = " +
			userList.size() + ((User)userList.get(1)).getUserName());
		    // getting User with userid = 1
			User user1 = ud1.getUser(3);
			System.out.println("User Name = " + user1.getUserName()); 
			User user2 = new User(1, "Buddy", "buddy@outlook.com", "Australia");
			
			int y = ud1.updateUser(user2);
			int z = ud1.deleteUser(3);
			/*
			 * ProductDaoImp1 pd1 = new ProductDaoImp1(); Product p = new
			 * Product(1004,"air fryer Oven",5500); int result =pd1.insert(p);
			 * System.out.println(" result is = " + result); 
			 * ArrayList productList =
			 * pd1.listProductDetails(); System.out.println("Number of products = " +
			 * productList.size() + ((Product)productList.get(0)).getpName());
			 */
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static Connection getconnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement","root","Quinnox!23$");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		}
}
