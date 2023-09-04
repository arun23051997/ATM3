package com.atm.new1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FomFilling {

	String name;
	int age;
	String gender;
	String mobileNumber;
	String adhar;
	String email;
	String accountNumber;
	String pass;
	double amount;
	String userSelectBankName;
	Scanner scanner = new Scanner(System.in);

	FomFilling() {
	}

	void formFilling() {

		System.out.println("Ener you name : ");
		name = scanner.next();

		System.out.println("Age : ");
		age = scanner.nextInt();
		System.out.println("Gender : ");
		gender = scanner.next();
		System.out.println("Mobile Number : ");
		mobileNumber = scanner.next();
		System.out.println("Adhar : ");
		adhar = scanner.next();
		System.out.println("Email : ");
		email = scanner.next();
		System.out.println("Account Number : ");
		accountNumber = scanner.next();
		System.out.println("Pass : ");
		pass = scanner.next();
		System.out.println("Amount : ");
		amount = scanner.nextDouble();
	
	}

	public void insertDb(String userSelectBankName) throws SQLException {
		String query = "Insert into Form (Name,Age,Gender,MobileNumber,Adhar,Email,AccountNumber,"
				+ "Pass,Amount,Bank,Create_account_date,withdraw_or_deposit_time)" + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

		LocalDateTime dateTime = LocalDateTime.now();
		String dateTime1 = dateTime.toString();

		Connection con = DbConnection.getConnection();

		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, name);
		pst.setInt(2, age);
		pst.setString(3, gender);
		pst.setString(4, mobileNumber);
		pst.setString(5, adhar);
		pst.setString(6, email);
		pst.setString(7, accountNumber);
		pst.setString(8, pass);
		pst.setDouble(9, amount);
		pst.setString(10, userSelectBankName);
		pst.setString(11, dateTime1);
		pst.setString(12, dateTime1);

		pst.executeUpdate();

		pst.close();
		con.close();
		System.out.println("Account Created sucess!");
	}

}
