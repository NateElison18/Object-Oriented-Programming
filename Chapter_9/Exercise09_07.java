/*
 * Author: Nate Elison
 * Date: 4/17/23
 * 
 * This program creates the Account class and tests it using the class' different methods to display the test account info. 
 */

import java.util.Date;

public class Exercise09_07 {

	public static void main(String[] args) {
		// Test account object created w specified parameters 
		Account testAccount1 = new Account(1122, 20000, 4.5);
		
		// Withdraw 2500, deposit 3000, and display test account balance, monthly interest, and date created
		testAccount1.withdraw(2500);
		testAccount1.deposit(3000);
		System.out.println("The test account now has a balance of $" + testAccount1.getBalance());
		System.out.printf("Monthly interest: $%.2f \n", testAccount1.monthlyInterest());
		System.out.println("Date created: " + testAccount1.getDateCreated());
		
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
	
}
