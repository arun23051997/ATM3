package com.atm.new1;

public class FormFillGetSet {

	private String name;
	private int age;
	private String gender;
	private String bank;
	private String mobileNumber;
	private String adhar;
	private String email;
	private String accountNumber;
	private String pass;
	private double amount;
	private IAlreadyHaveAccount IAlreadyHaveAccount;

	FormFillGetSet() {
	}

	public FormFillGetSet(String name, int age, String gender, String mobileNumber, String adhar, String email,
			String accountNumber, String pass, String bank, double amount,IAlreadyHaveAccount IAlreadyHaveAccount) {

		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.adhar = adhar;
		this.email = email;
		this.accountNumber = accountNumber;
		this.pass = pass;
		this.amount = amount;
		this.bank = bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public IAlreadyHaveAccount getIAlreadyHaveAccount() {
		return IAlreadyHaveAccount;
	}

public void setIAlreadyHaveAccount(IAlreadyHaveAccount iAlreadyHaveAccount) {
		IAlreadyHaveAccount = iAlreadyHaveAccount;
	}	
}
