/*
 * Author: Nate Elison
 * Date: 4/24/23
 * 
 * This program creates an account superclass and two subclasses for checking and savings accounts. 
 * The program then tests the classes by creating account, checking account, and savings account objects and printing out their toString methods. 
 */

import java.util.Date;

public class Exercise11_03 {

	public static void main(String[] args) {
		// Create Accounts print out their toStrings
		Account generalAccount = new Account(001, 300, 2.5);
		CheckingAccount checkingAccount = new CheckingAccount(002, 500, 2.5, 50);
		SavingsAccount savingsAccount = new SavingsAccount(003, 1000, 3.5);
		
		System.out.println(generalAccount.toString());
		System.out.println("----------------------------------");
		System.out.println(checkingAccount.toString());
		System.out.println("----------------------------------");
		System.out.println(savingsAccount.toString());

	}

}
class Account{
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new Date();
	
	Account(){
	}
	
	Account(int newId, double newBalance, double newAnnualInterestRate){
		id = newId;
		balance = newBalance;
		annualInterestRate = newAnnualInterestRate;
	}
	
	// ID mutator and accessor methods
	public void setId(int newId) {
		id = newId;
	}
	public int getId() {
		return id;
	}
	
	//  Balance mutator and accessor methods
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	public double getBalance() {
		return balance;
	}
	
	// AnnualInterestRate mutator and accessor methods
	public void setAnnualInterestRate(double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	// Accessor method for dateCreated
	public Date getDateCreated() {
		return dateCreated;
	}
	
	// Method to return the monthly interest rate
	public double monthlyInterestRate() {
		double monthlyInterestRate;
		monthlyInterestRate = annualInterestRate / 12.0;
		return monthlyInterestRate;
	}
	
	// Method to return the monthly interest
	public double monthlyInterest() {
		double monthlyInterest;
		monthlyInterest = balance * monthlyInterestRate() / 100.0;
		return monthlyInterest;
	}
	
	// Method to withdraw a specified amount from the account
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	// Method to deposit a specified amount from the account 
	public void deposit(double amount) {
		balance += amount;
	}
	
	public String toString() {
		return "Account info: \n\t Account Type: None Specificed \n\t ID: " + getId() + "\n\t Balance: " + getBalance() + "\n\t Annual Interest Rate: " + getAnnualInterestRate();
	}
	
}

// Subclasses
class CheckingAccount extends Account {
	double overDraftLimit = 100;
	
	CheckingAccount(){
	}
	
	CheckingAccount(int id, double balance, double annualInterestRate, double overdraftLimit){
		super(id, balance, annualInterestRate);
		this.overDraftLimit = overdraftLimit;
	}
	
	// OverDraftLimit getter and setter
	public double getOverDraftLimit() {
		return overDraftLimit;
	}
	
	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}
	
	// Overriding withdraw method to incorporate an overdraft limit. 
	public void withdraw(double amount) {
		if (amount > (getBalance() + overDraftLimit)) 
			 System.out.println("Error. Withdraw would be over the over draft limit set on this account.");
		else withdraw(amount);
	}
	
	public String toString() {
		return "Account info: \n\t Account Type: Checking \n\t ID: " + getId() + "\n\t Balance: " + getBalance() + "\n\t Overdraft Limit: " + getOverDraftLimit() + "\n\t Annual Interest Rate: " + getAnnualInterestRate();
	}
}

class SavingsAccount extends Account {
	SavingsAccount(){
	}
	
	SavingsAccount(int id, double balance, double annualInterestRate){
		super(id, balance, annualInterestRate);
	}
	
	// Overriding withdraw method to not allow overdraft. 
	public void withdraw(double amount) {
		if (amount > getBalance()) 
			 System.out.println("Error. Insufficient funds");
		else withdraw(amount);
	}
	
	public String toString() {
		return "Account info: \n\t Account Type: Savings \n\t ID: " + getId() + "\n\t Balance: " + getBalance() + "\n\t Annual Interest Rate: " + getAnnualInterestRate();
	}
	
}
