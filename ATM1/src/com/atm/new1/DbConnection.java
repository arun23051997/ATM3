package com.atm.new1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;



public class DbConnection {
	private static final String url = "jdbc:mysql://localhost:3306/ATM2";
	private static final String userName = "root";
	private static final String passWord = "Ch@ngep0nd@123";
	

	public static Connection getConnection() throws SQLException{
		return  DriverManager.getConnection(url,userName,passWord);
	}
	LocalDateTime dateTime = LocalDateTime.now();
	Scanner Scanner = new Scanner(System.in);
	public void checkBalance(String accountnumber1) throws SQLException {
		System.out.println("............Check Banlance.............");
		Connection con = getConnection();
		String qry = "SELECT * FROM Form WHERE AccountNumber =" + accountnumber1;
		PreparedStatement pst = con.prepareStatement(qry);
		//Statement st = con.createStatement();
		ResultSet rs = pst.executeQuery();
		rs.next();
		Double amount = rs.getDouble("Amount");
		System.out.println("Your balance now : " + amount);
		
		 rs.close();
         pst.close();
         con.close();
		
	}
	public void deposit () throws SQLException {
		System.out.println("............Deposit.............");
		System.out.println("How much deposit amount : ");
		double deposit = Scanner.nextDouble();
		System.out.println("Which account deposit : ");
		String accountnumber2 = Scanner.next();
		Connection con = getConnection();
		String qry = "SELECT * FROM Form WHERE AccountNumber =" + accountnumber2;
		PreparedStatement pst = con.prepareStatement(qry);
		//Statement st = con.createStatement();
		ResultSet rs = pst.executeQuery();
		rs.next();
		Double name = rs.getDouble("Amount");
		Double name1 = name + deposit;
		String dateTime1 = dateTime.toString();
		qry = "UPDATE Form SET Amount =" + name1 + ",Withdraw_or_deposit_time="+" ' " +dateTime1+" ' " +"WHERE AccountNumber=" + accountnumber2;
		PreparedStatement st1 = con.prepareStatement(qry);
		st1.executeUpdate(qry);
		System.out.println("Deposite Success!");	
		 rs.close();
         pst.close();
         con.close();
         
	}
	public void withdraw (String accountnumber1) throws SQLException {
		System.out.println("............Withdraw.............");
		System.out.println("How much withdraw amount : ");
		double withdraw = Scanner.nextDouble();
		Connection con = getConnection();

		String qry = "SELECT * FROM Form WHERE AccountNumber = "+ accountnumber1;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		rs.next();
		Double name = rs.getDouble("Amount");
		Double name1 = name - withdraw;
		
		String dateTime1 = dateTime.toString();
		
		qry = "UPDATE Form SET Amount =" + name1 + ",Withdraw_or_deposit_time=" + " ' " + dateTime1 + " ' " +" WHERE AccountNumber=" + accountnumber1;
		PreparedStatement  st1 = con.prepareStatement(qry);
		
		
		st1.executeUpdate(qry);
		System.out.println("Withdraw Success!");	
		 rs.close();
         st.close();
         con.close();
         
}
	
}

