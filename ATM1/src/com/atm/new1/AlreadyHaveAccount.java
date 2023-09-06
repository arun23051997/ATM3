package com.atm.new1;

import java.sql.SQLException;
import java.util.Scanner;

public class AlreadyHaveAccount {
	String accountNumber1;
	String pass1;
	
	boolean exitFlag = false;

	public void alreadyHaveAccount() throws SQLException {
		
		Scanner Scanner = new Scanner(System.in);
		
		System.out.println("Enter your AccountNumber : ");
		accountNumber1 = Scanner.next();
		System.out.println("Enter Your Password : ");
		pass1 = Scanner.next();
		AlreadyHaveAccountDAO ob = new AlreadyHaveAccountDAO();
	//	try {
		ob.userIdentify(accountNumber1);
		//}catch(Exception e) {
			///System.out.println("Already Have Account : " + e.getMessage());
		//}
		

		
		//System.out.println("Hello " + name + " Welcome to " + bank);

		while (!exitFlag) {
			System.out.println("ATM Options:");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Main");
			System.out.print("Enter choice: ");
			int choice = Scanner.nextInt();
			
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
				SelectAcType  ob1 = new SelectAcType ();
				ob1.displayUser();

				break;
			default:
				System.out.println("Please click correct choice!");
			}
		}
		Scanner.close();
		
		
	}
}
