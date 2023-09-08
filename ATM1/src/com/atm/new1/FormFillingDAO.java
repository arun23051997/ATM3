package com.atm.new1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class FormFillingDAO {
	public void insertDb(FormFillGetSet form) throws SQLException {
		String query = "Insert into Form (Name,Age,Gender,MobileNumber,Adhar,Email,AccountNumber,"
				+ "Pass,Amount,Bank,Create_account_date,withdraw_or_deposit_time)" + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

		LocalDateTime dateTime = LocalDateTime.now();
		String dateTime1 = dateTime.toString();

		Connection con = DbConnection.getConnection();

		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, form.getName());
		pst.setInt(2, form.getAge());
		pst.setString(3, form.getGender());
		pst.setString(4, form.getMobileNumber());
		pst.setString(5, form.getAdhar());
		pst.setString(6, form.getEmail());
		pst.setString(7, form.getAccountNumber());
		pst.setString(8, form.getPass());
		pst.setDouble(9, form.getAmount());
		pst.setString(10, form.getBank());
		pst.setString(11, dateTime1);
		pst.setString(12, dateTime1);

		pst.executeUpdate();
		pst.close();
		con.close();

		System.out.println("Account Created sucess!");
	}
}
