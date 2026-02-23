package com.g1rix.javalearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
	
    private static final String DB_URL ="jdbc:postgresql://localhost:5432/studentdatabase";
    private static final String DB_USER = "giri";
    private static final String DB_PASSWORD = "root";

	
	public static void main(String[] args) {
		
        try (
                Connection connection =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Scanner scan = new Scanner(System.in)
        ) {

            int choice;

            do {
            	System.out.println("\n1. Insert");
            	System.out.println("2. View All");
            	System.out.println("3. Get by ID");
            	System.out.println("4. Update name|course");
            	System.out.println("5. Delete Specific");
            	System.out.println("6. Exit");
            	System.out.print("Choose: ");

            	choice = scan.nextInt();

            	switch (choice) {
            	    case 1:
            	        StudentRecord.insert(connection, scan);
            	        break;
            	    case 2:
            	        StudentRecord.viewAll(connection);
            	        break;
            	    case 3:
            	        StudentRecord.searchById(connection, scan);
            	        break;
            	    case 4:
            	        StudentRecord.updateCourse(connection, scan);
            	        break;
            	    case 5:
            	        StudentRecord.deleteRecord(connection, scan);
            	        break;
            	    case 6:
            	        StudentRecord.exitApplication();
            	        break;
            	    default:
            	        System.out.println("Invalid choice!");
            	}


            } while (choice != 6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}


