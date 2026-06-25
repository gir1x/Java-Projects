package com.g1rix.javalearning.EmployeeDetails;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDetails {

    public static void addEmployee(Connection connect, Scanner scan) {
        try {
            System.out.println("Insert Employee details");

            System.out.print("Enter Employee ID: ");
            int id = scan.nextInt();

            System.out.print("Enter Employee Name: ");
            String name = scan.next();

            System.out.print("Enter Employee Salary: ");
            int salary = scan.nextInt();

            System.out.print("Enter Department: ");
            String dept = scan.next();

            String query = "INSERT INTO EMPLOYEERECORD VALUES(?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, salary);
            ps.setString(4, dept);

            int row = ps.executeUpdate();
            System.out.println(row + " record inserted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void viewEmployee(Connection connect) {
        try {
            String query = "SELECT * FROM EMPLOYEERECORD";
            PreparedStatement ps = connect.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getInt("id") +
                        " | EMPName: " + rs.getString("EMPname") +
                        " | Salary: " + rs.getInt("salary") +
                        " | Department: " + rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void updateSalary(Connection connect, Scanner scan) {
        try {
        	System.out.print("Enter Employee ID: ");
        	int id = scan.nextInt();
        	
            System.out.print("Enter updated salary: ");
            int salary = scan.nextInt();

            String query = "UPDATE EMPLOYEERECORD SET SALARY = ? WHERE ID = ?";
            PreparedStatement ps = connect.prepareStatement(query);

            ps.setInt(1, salary);
            ps.setInt(2, id);

            int row = ps.executeUpdate();
            System.out.println(row + " row(s) affected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public static void deleteEmployee(Connection connect, Scanner scan) {
        try {
            System.out.print("Enter Employee ID to delete: ");
            int id = scan.nextInt();

            String query = "DELETE FROM EMPLOYEERECORD WHERE ID = ?";
            PreparedStatement ps = connect.prepareStatement(query);

            ps.setInt(1, id);

            int row = ps.executeUpdate();
            System.out.println(row + " row(s) deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void displayByDepartment(Connection connect, Scanner scan) {
        try {
            System.out.print("Enter department name: ");
            String dept = scan.next();

            String query = "SELECT * FROM EMPLOYEERECORD WHERE department = ?";
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setString(1, dept);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getInt("id") +
                        " | Name: " + rs.getString("EMPname") +
                        " | Salary: " + rs.getInt("salary") +
                        " | Department: " + rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void sortBySalary(Connection connect, Scanner scan) {
        try {
            String query = "SELECT * FROM EMPLOYEERECORD ORDER BY salary DESC";
            PreparedStatement ps = connect.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("Employees sorted by salary:");

            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getInt("id") +
                        " | Name: " + rs.getString("EMPname") +
                        " | Salary: " + rs.getInt("salary") +
                        " | Department: " + rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exitProgram() throws InterruptedException {
        System.out.print("Exiting From This Process");
        Thread.sleep(1000);
        System.out.println("...");
    }
}