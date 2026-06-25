package com.g1rix.javalearning.loginSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
public class Main {
	private static final String DB_URL ="jdbc:postgresql://localhost:5432/studentdatabase";
	private static final String DB_USER = "giri";
	private static final String DB_PASSWORD = "root";
	public static void main(String[] args) {
		try {
			Connection connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Scanner scan = new Scanner(System.in);
			int choice;
			do {
				System.out.println("Choose Operation -> \n1.New Registration \n2.Login \n3.Exit ");
				choice = scan.nextInt();
				switch (choice) {
				case 1:LoginSystem.userRegistration(connect, scan);
				break;
				case 2:LoginSystem.loginValidation(connect, scan);
				break;
				case 3:LoginSystem.ExitProgram();
					break;
				default:System.out.println("Invalid Input");
				break;
				}
			} while (choice!=3);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
