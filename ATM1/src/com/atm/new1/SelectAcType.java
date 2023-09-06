package com.atm.new1;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectAcType {
	
		boolean exitFlag = false;
		String bank2 ;
		Scanner userinput = new Scanner(System.in);

		public void displayUser() throws SQLException {
			
			while (!exitFlag) {
				System.out.println("1.Create Account");
				System.out.println("2.Already have Account");
				System.out.println("3. Exit");
				System.out.print("Choose Option : ");
				
				int userSelectAccountType = userinput.nextInt();
				
				switch (userSelectAccountType) {
				case 1: {
					
					
					CreateNewAccount creatAccountObject = new CreateNewAccount();
					String bank2 = creatAccountObject.createAccount1();
					
					FomFilling fomfilling1 = new FomFilling();
					 FormFillGetSet ll=fomfilling1.fomFilling(bank2 );
					
//					fillGetSet.setBank(bank2);
//					
//					System.out.println("Enter your Name : ");
//					fillGetSet.setName(userinput.next());
//					
//					
//					
//					System.out.println("Age : ");
//					fillGetSet.setAge(userinput.nextInt());
//					
//					System.out.println("Gender : ");
//					fillGetSet.setGender(userinput.next());
//					
//					System.out.println("Mobile Number : ");
//					fillGetSet.setMobileNumber(userinput.next());
//					
//					
//					System.out.println("Adhar : ");
//					fillGetSet.setAdhar(userinput.next());
//					
//					System.out.println("Email : ");
//					fillGetSet.setEmail(userinput.next());
//					
//					System.out.println("Account Number : ");
//					fillGetSet.setAccountNumber(userinput.next());
//					
//					System.out.println("Pass : ");
//					fillGetSet.setPass(userinput.next());
//					
//					System.out.println("Amount : ");
//					fillGetSet.setAmount(userinput.nextDouble());
					
					
					
				
					FormFillingDAO formfillObDb = new FormFillingDAO ();
					formfillObDb.insertDb(ll);
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
			userinput.close();
		}

	}

