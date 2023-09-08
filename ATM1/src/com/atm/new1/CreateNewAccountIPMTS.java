package com.atm.new1;

import java.util.Scanner;

import com.atm.new1.interface1.ICreateAccount;

public class CreateNewAccountIPMTS implements ICreateAccount{

	
	
		Scanner userinput = new Scanner(System.in);
		@Override
			public String createAccount1() {
				System.out.println("..........Bank Of Total Branch..........");
				System.out.println("1. Indian Bank");
				System.out.println("2. State Bank");
				System.out.println("3. Indian Overseas Bank");
				System.out.println("Which bank you want ? : ");
		
				String userSelectBankName = null;
				int bank = userinput.nextInt();
		
				switch (bank) {
				case 1:
					userSelectBankName = "Indian Bank";
					break;
				case 2:
					userSelectBankName = "State Bank";
					break;
				case 3:
					userSelectBankName = "Indian Overseas Bank";
					break;
				default:
					System.out.println("Please click correct choice!");
					break;
		
				}
		
				return userSelectBankName;
		
			}


	}

