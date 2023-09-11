package com.atm.new1;

import java.sql.SQLException;
import java.util.Scanner;

public class AlreadyHaveAccount {
	String accountNumber1;
	String pass1;

	boolean exitFlag = false;
	private IAlreadyHaveAccount IAlreadyHaveAccount;
	public AlreadyHaveAccount(IAlreadyHaveAccount iAlreadyHaveAccount ) {
		IAlreadyHaveAccount=iAlreadyHaveAccount;
	}

	public void alreadyHaveAccount() throws SQLException {

		Scanner Scanner = new Scanner(System.in);

		System.out.println("Enter your AccountNumber : ");
		accountNumber1 = Scanner.next();
		System.out.println("Enter Your Password : ");
		pass1 = Scanner.next();
		//AlreadyHaveAccountDAO myAccount = new AlreadyHaveAccountDAO();

		IAlreadyHaveAccount.userIdentify(accountNumber1);

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

				IAlreadyHaveAccount.checkBalance(accountNumber1);

				break;
			case 2:

				IAlreadyHaveAccount.deposit();

				break;
			case 3:

				IAlreadyHaveAccount.withdraw(accountNumber1);

				break;

			case 4:
				SelectAcType acType = new SelectAcType();
				acType.displayUser();

				break;
			default:
				System.out.println("Please click correct choice!");
			}
		}
		Scanner.close();

	}

	
}
