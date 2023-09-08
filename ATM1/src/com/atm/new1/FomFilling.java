package com.atm.new1;

import java.util.Scanner;

public class FomFilling {

	Scanner userinput = new Scanner(System.in);

	public FormFillGetSet fomFilling(String ff) {

		FormFillGetSet fillGetSet = new FormFillGetSet();

		fillGetSet.setBank(ff);

		try {

			System.out.println("Enter your Name : ");
			fillGetSet.setName(userinput.next());

			System.out.println("Age : ");
			fillGetSet.setAge(userinput.nextInt());

			System.out.println("Gender : ");
			fillGetSet.setGender(userinput.next());

			System.out.println("Mobile Number : ");
			fillGetSet.setMobileNumber(userinput.next());

			System.out.println("Adhar : ");
			fillGetSet.setAdhar(userinput.next());

			System.out.println("Email : ");
			fillGetSet.setEmail(userinput.next());

			System.out.println("Account Number : ");
			fillGetSet.setAccountNumber(userinput.next());

			System.out.println("Pass : ");
			fillGetSet.setPass(userinput.next());

			System.out.println("Amount : ");
			fillGetSet.setAmount(userinput.nextDouble());

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("The error block While processing the form" + e.getMessage());

		}

		return fillGetSet;
	}

}
