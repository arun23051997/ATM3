package com.atm.new1;

import java.sql.SQLException;
import java.util.Scanner;

class PerformATM {
	boolean exitFlag = false;
	

	public void displayUser() throws SQLException {
		Scanner Userinput = new Scanner(System.in);
		while (!exitFlag) {
			System.out.println("1.Create Account");
			System.out.println("2.Already have Account");
			System.out.println("3. Exit");
			System.out.print("Choose Option : ");

			int userSelectAccountType = Userinput.nextInt();
			
			switch (userSelectAccountType) {
			case 1: {
				
				CreateNewAccount creatAccountObject = new CreateNewAccount();
				creatAccountObject.createAccount1();
				FomFilling formob = new FomFilling();
				formob.formFilling();

				formob.insertDb(creatAccountObject.userSelectBankName);
				break;
			}
			case 2: {
				
				AlreadyHaveAccount alreadyHaveAccountObject = new AlreadyHaveAccount();
				alreadyHaveAccountObject.alreadyHaveAccount();

				break;
			}
			case 3: {
				exitFlag = true;
				System.out.println("Thank you for using our ATM. Goodbye!");
				System.exit(0);

				break;
			}
			default: {
				System.out.println("Please click correct choice!");
				break;
			}
				
				
			}
			
		}
		Userinput.close();
	}

}

public class Main {

	public static void main(String[] args) {

		PerformATM ob = new PerformATM();
		try {
			ob.displayUser();
		} catch (Exception e) {

			System.out.println("Ther Error " + e);
		}
		
	}
}
