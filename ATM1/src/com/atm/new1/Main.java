package com.atm.new1;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		SelectAcType ob = new SelectAcType();
		try {
			ob.displayUser();
		} catch (Exception e) {

			System.out.println("Ther Error " + e);
		}
		finally {
            try {
                
                if ( DbConnection.getConnection()!= null) {
                	DbConnection.getConnection().close();
                }
            } catch (SQLException e) {
      	
          
                e.printStackTrace();
            }
        }
		
	}
}
