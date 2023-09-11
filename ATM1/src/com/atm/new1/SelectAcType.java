package com.atm.new1;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectAcType {
	
		boolean exitFlag = false;
		String bank2 ;
		Scanner userInput = new Scanner(System.in);

		public void displayUser() throws SQLException {
			
			while (!exitFlag) {
				System.out.println("1.Create Account");
				System.out.println("2.Already have Account");
				System.out.println("3. Exit");
				System.out.print("Choose Option Click Number Only : ");
				
				int userSelectAccountType = userInput.nextInt();
				
				switch (userSelectAccountType) {
				case 1: {
					
					
					CreateNewAccountIPMTS creatAccountObject = new CreateNewAccountIPMTS();
					String bank2 = creatAccountObject.createAccount1();
					
					FomFilling fomfilling1 = new FomFilling();
					 FormFillGetSet formFillGetSet1=fomfilling1.fomFilling(bank2 );					
				
					FormFillingDAO formfillObDb = new FormFillingDAO ();
					formfillObDb.insertDb(formFillGetSet1);
					break;
				}
				case 2: {
					
					AlreadyHaveAccount alreadyHaveAccountObject = new AlreadyHaveAccount(new AlreadyHaveAccountDAO());
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
			userInput.close();
		}

	}

