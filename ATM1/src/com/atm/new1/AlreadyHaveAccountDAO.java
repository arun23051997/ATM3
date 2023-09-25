package com.atm.new1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AlreadyHaveAccountDAO implements IAlreadyHaveAccount{
	String name;
	String bank;

	LocalDateTime dateTime = LocalDateTime.now();
	Scanner Scanner = new Scanner(System.in);
	
	@Override
	public void userIdentify(String accountNumber) {
		Connection con = DbConnection.getConnection();
		String qry = "SELECT * FROM Form WHERE AccountNumber =" + accountNumber;
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(qry);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		try {
			if (rs.next()) {
				name = rs.getString("Name");
				bank = rs.getString("Bank");
				System.out.println("Hello " + name + " Welcome to " + bank);

			} else {

				System.out.println("Wrong A/C Number or You have no Account!!!!! ");
				SelectAcType ob1 = new SelectAcType();
				ob1.displayUser();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void checkBalance(String accountnumber1) {
		try {
			System.out.println("............Check Banlance.............");
			Connection con = DbConnection.getConnection();
			String qry = "SELECT * FROM Form WHERE AccountNumber =" + accountnumber1;
			PreparedStatement pst = con.prepareStatement(qry);
			// Statement st = con.createStatement();
			ResultSet rs = pst.executeQuery();
			rs.next();
			Double amount = rs.getDouble("Amount");
			System.out.println("Your balance now : " + amount);
			con.close();
			rs.close();
			pst.close();

		} catch (Exception e) {
			System.err.println("The Error occured CheckBalance!" + e);
		}

	}
	@Override
	public void deposit() {
		try {
			System.out.println("............Deposit.............");
			System.out.println("How much deposit amount : ");
			double deposit = Scanner.nextDouble();
			System.out.println("Which account deposit : ");
			String accountnumber2 = Scanner.next();
			Connection con =DbConnection.getConnection();
			String qry = "SELECT * FROM Form WHERE AccountNumber =" + accountnumber2;
			PreparedStatement pst = con.prepareStatement(qry);
			// Statement st = con.createStatement();
			ResultSet rs = pst.executeQuery();
			rs.next();
			Double name = rs.getDouble("Amount");
			Double name1 = name + deposit;
			String dateTime1 = dateTime.toString();
			qry = "UPDATE Form SET Amount =" + name1 + ",Withdraw_or_deposit_time=" + " ' " + dateTime1 + " ' "
					+ "WHERE AccountNumber=" + accountnumber2;
			PreparedStatement st1 = con.prepareStatement(qry);
			st1.executeUpdate(qry);
			System.out.println("Deposite Success!");
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.err.println("The Error occured  Deosit!" + e);
		}

	}
	@Override
	public void withdraw(String accountnumber1){
		try {
			System.out.println("............Withdraw.............");
			System.out.println("How much withdraw amount : ");
			double withdraw = Scanner.nextDouble();
			Connection con = DbConnection.getConnection();

			String qry = "SELECT * FROM Form WHERE AccountNumber = " + accountnumber1;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);
			rs.next();
			Double name = rs.getDouble("Amount");
			Double name1 = name - withdraw;

			String dateTime1 = dateTime.toString();

			qry = "UPDATE Form SET Amount =" + name1 + ",Withdraw_or_deposit_time=" + " ' " + dateTime1 + " ' "
					+ " WHERE AccountNumber=" + accountnumber1;
			PreparedStatement st1 = con.prepareStatement(qry);

			st1.executeUpdate(qry);
			System.out.println("Withdraw Success!");
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			System.err.println("The Error occured Withdraw!" + e);
		}
	}
	
	
	
	
	
}

	

	

	