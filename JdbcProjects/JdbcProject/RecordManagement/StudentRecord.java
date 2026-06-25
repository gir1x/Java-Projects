package com.g1rix.javalearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentRecord {
	public static void insert(Connection connect,Scanner scan) {
		System.out.println("Insert student records...");
		try {
			System.out.println("Enter id");
			int id = scan.nextInt();
			
			System.out.println("Enter name");
			String name = scan.next();
			
			System.out.println("Enter age");
			int age = scan.nextInt();			
			
			System.out.println("Enter course");
			String course = scan.next();
			
			String Query = "INSERT INTO STUDENTRECORD VALUES(?,?,?,?)";
			
			PreparedStatement ps = connect.prepareStatement(Query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, course);
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				System.out.println("Inserted Record");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void viewAll(Connection connect) {
		try {
//			System.out.println("Enter Id");
//			int id = scan.nextInt();
			
			String Query = "SELECT * FROM STUDENTRECORD";
			
			PreparedStatement ps = connect.prepareStatement(Query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(
						"\nId: " + rs.getInt("id") +
						"\tName: " + rs.getString("name") +
						"\tAge: " + rs.getInt("age") +"\t" +
						"\tCourse: " + rs.getString("course")
				);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void searchById(Connection connect,Scanner scan) {
		try {
			System.out.println("Enter Id");
			int id = scan.nextInt();
			
			String Query = "SELECT * FROM STUDENTRECORD WHERE ID = ?";
			
			PreparedStatement ps = connect.prepareStatement(Query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(
						"\nId: " + rs.getInt("id") +
						"\tName: " + rs.getString("name") +
						"\tAge: " + rs.getInt("age") +"\t" +
						"\tCourse: " + rs.getString("course")
				);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void updateCourse(Connection connect,Scanner scan) {
		try {
			System.out.println("Enter Id");
			int id = scan.nextInt();
			scan.nextLine();
			
			System.out.println("Enter Column to update");
			String courseColumn = scan.nextLine();
			
			System.out.println("Enter course detail");
			String course = scan.nextLine();
			
			String Query = "UPDATE STUDENTRECORD SET " + courseColumn + " = ? WHERE ID = ?";
			PreparedStatement ps = connect.prepareStatement(Query);
			ps.setInt(2, id);
			ps.setString(1, course);
	        int rows = ps.executeUpdate();
	        System.out.println(rows + " record updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public static void deleteRecord(Connection connect,Scanner scan) {
		try {
			System.out.println("Enter Id");
			int id = scan.nextInt();
			String Query = "DELETE FROM STUDENTRECORD WHERE ID = ?";
			PreparedStatement ps = connect.prepareStatement(Query);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
	        System.out.println(rows + " record updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public static void exitApplication() throws InterruptedException {
		System.out.print("Exiting From Program");
        Thread.sleep(1000);
        System.out.println("...");
		
	}

}
