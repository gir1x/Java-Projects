package com.g1rix.javalearning.loginSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.g1rix.javalearning.EmployeeDetails.*;


public class LoginSystem {
	public static void userRegistration(Connection connect,Scanner scan) {
		try {
			System.out.println("Enter a Unique Username");
			String name = scan.next();
			System.out.println("Enter a Strong Password");
			String password = scan.next();		
			String Query = "INSERT INTO LOGINSYSTEM VALUES(?,?)";
			PreparedStatement ps = connect.prepareStatement(Query);
			ps.setString(1, name);
			ps.setString(2, password);
			int row = ps.executeUpdate();
			System.out.println(row + "rows affected");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	public static void loginValidation(Connection connect,Scanner scan) {
		try {
			System.out.println("Enter the Username");
			String name =scan.next();
			System.out.println("Enter the Password");
			String password =scan.next();			
			String Query = "SELECT PASSWORD FROM LOGINSYSTEM WHERE USERNAME = ?";
			PreparedStatement ps = connect.prepareStatement(Query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				String UserPassword = rs.getString("password");
				if(password.equals(UserPassword)) { 					
					System.out.println("Login Successful");
					EmployeeAccess(connect,scan);
				}
				else System.out.println("Password didn't match!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void ExitProgram() throws InterruptedException {
		System.out.print("Exiting From Program");
        Thread.sleep(1000);
        System.out.println("...");
	}
	private static void EmployeeAccess(Connection connect,Scanner scan) throws InterruptedException {
		Scanner scn = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employee List");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Display Employees By Department");
            System.out.println("6. Sort by Salary");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            choice = scn.nextInt();

            switch (choice) {
                case 1 -> EmployeeDetails.addEmployee(connect, scan);
                case 2 -> EmployeeDetails.viewEmployee(connect);
                case 3 -> EmployeeDetails.updateSalary(connect, scan);
                case 4 -> EmployeeDetails.deleteEmployee(connect, scan);
                case 5 -> EmployeeDetails.displayByDepartment(connect, scan); 
                case 6 -> EmployeeDetails.sortBySalary(connect, scan);
                case 7 -> EmployeeDetails.exitProgram();
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 7); 
	}
}
