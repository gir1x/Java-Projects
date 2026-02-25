package com.g1rix.javalearning.EmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class mainOfEmployee extends EmployeeDetails {

    private static final String DB_URL =
            "jdbc:postgresql://localhost:5432/studentdatabase";
    private static final String DB_USER = "giri";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {

        try {
            Connection connection =
                    DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Scanner scan = new Scanner(System.in);
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

                choice = scan.nextInt();

                switch (choice) {
                    case 1 -> addEmployee(connection, scan);
                    case 2 -> viewEmployee(connection);
                    case 3 -> updateSalary(connection, scan);
                    case 4 -> deleteEmployee(connection, scan);
                    case 5 -> displayByDepartment(connection, scan); 
                    case 6 -> sortBySalary(connection, scan);
                    case 7 -> exitProgram();
                    default -> System.out.println("Invalid choice!");
                }

            } while (choice != 7); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}