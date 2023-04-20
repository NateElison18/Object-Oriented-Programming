/*
 * Author: Nate Elison
 * Date: 4/19/23
 * 
 * This program uses the account class to create an fake ATM. 
 * It creates an array of 10 account objects and the user can withdraw, deposit, and check the balance of the 10 accounts. 
 */

import java.util.Date;
import java.util.Scanner;

public class Exercise10_07 {

	public static void main(String[] args) {
		// Create and initialize account array
		Account[] accounts = new Account[10];
		for(int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 100);
		}
		
		// Implement methods
		Scanner input = new Scanner(System.in);
		input.nextLine();
		int id = getId();
		
		while (true) {
			displayMenu();
			
			input.nextLine();
			
			int choice = getChoice();
			
			if 		(choice == 1) checkBalance(accounts[id]);
			else if (choice == 2) withdraw(accounts[id]);
			else if (choice == 3) deposit(accounts[id]);
			else {
				System.out.println();
				id = getId();
			}
			
		}

	}
	
	// Method for prompting user for the id
	public static int getId() {
		Scanner input = new Scanner(System.in);
		int answer;
		
		do {
			System.out.print("Enter an id: ");
			answer = input.nextInt();
		} while (answer < 0 || answer > 9);
			
		return answer; 
	}
	
	// Method for prompting user for the choice
	public static int getChoice() {
		Scanner input = new Scanner(System.in);
		int answer;
		
		do {
			System.out.print("Enter a choice: ");
			answer = input.nextInt();
		} while (answer < 1 || answer > 4);
			
		return answer; 
	}
	
	// Method to display main menu
	public static void displayMenu() {
		System.out.println("Main Menu");
		System.out.println("----------------");
		System.out.println("1: Check Balance");
		System.out.println("2: Withdraw");
		System.out.println("3: Deposit");
		System.out.println("4: Exit");
	}
	
	// Method to check the balance
	public static void checkBalance(Account account) {
		System.out.println("The balance is $" + account.getBalance());
	}
	
	// Method to withdraw
	public static void withdraw(Account account) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an amount to withdraw: ");
		double amount = input.nextDouble();
		account.withdraw(amount);
	}
	
	// Method to deposit
	public static void deposit(Account account) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an amount to depoit: ");
		double amount = input.nextDouble();
		account.deposit(amount);
	}

}
class Account{
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new Date();
	
	Account(){
	}
	
	Account(int newId, double newBalance){
		id = newId;
		balance = newBalance;
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
