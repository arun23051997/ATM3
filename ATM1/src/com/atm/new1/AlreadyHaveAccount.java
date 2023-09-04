package com.atm.new1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlreadyHaveAccount {
	String accountNumber1;
	String pass1;
	String name;
	String bank;
	boolean exitFlag = false;

	public void alreadyHaveAccount() throws SQLException {

		Scanner Scanner = new Scanner(System.in);

		System.out.println("Enter your AccountNumber : ");
		accountNumber1 = Scanner.next();
		System.out.println("Enter Your Password : ");
		pass1 = Scanner.next();

		Connection con = DbConnection.getConnection();
		String qry = "SELECT * FROM Form WHERE AccountNumber =" + accountNumber1;
		PreparedStatement pst = con.prepareStatement(qry);
		ResultSet rs = pst.executeQuery(qry);
		if (rs.next()) {
			name = rs.getString("Name");
			bank = rs.getString("Bank");

		}
		System.out.println("Hello " + name + " Welcome to " + bank);

		while (!exitFlag) {
			System.out.println("ATM Options:");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Main");
			System.out.print("Enter choice: ");
			int choice = Scanner.nextInt();
			DbConnection ob = new DbConnection();
			switch (choice) {
			case 1:

				ob.checkBalance(accountNumber1);

				break;
			case 2:

				ob.deposit();

				break;
			case 3:

				ob.withdraw(accountNumber1);

				break;

			case 4:
				PerformATM ob1 = new PerformATM();
				ob1.displayUser();

				break;
			default:
				System.out.println("Please click correct choice!");
			}
		}
		Scanner.close();
	}
}
