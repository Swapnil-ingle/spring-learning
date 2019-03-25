package com.hibernate.learn.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hims";
		String user = "root";
		String password = "root";
		
		try {
			System.out.println("Connecting to DB: " + url);
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection Successful!!");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
