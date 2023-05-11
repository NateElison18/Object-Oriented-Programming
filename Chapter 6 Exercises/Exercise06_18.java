/*
 * Author: Nate Elison
 * Date: 04/06/23
 * 
 * This program gets a potential password from the user and prints if its a valid password or not. 
 */

import java.util.Scanner;

public class Exercise06_18 {

	public static void main(String[] args) {
		// Get password
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a password: ");
		String password = input.nextLine();

		// Check if valid, print results 
		if(isValid(password)) System.out.println("Valid Password");
		else 				  System.out.println("Invalid Password");
		System.out.println(lettersAndDigits(password));
	}
	
	// Method to check validity of password
	public static boolean isValid(String s) {
		if(digitCount(s) < 1)   			  return false;
		else if(s.length() < 7) 			  return false;
		else if(lettersAndDigits(s) == false) return false;
		else 								  return true;
	}

	// Method to count digits and return the count as an int. 
	public static int digitCount(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) > 47 && s.charAt(i) < 58)
				count ++;
		}
		return count;
	}
	
	// Method to check if the characters are only letters and numbers. 
	public static boolean lettersAndDigits(String s) {
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i) > 0 && s.charAt(i) < 48) || 
					(s.charAt(i) > 57 && s.charAt(i) < 65) || 
					(s.charAt(i) > 90 && s.charAt(i) < 97) || 
					(s.charAt(i) > 122)) 
				return false;
			
			
		}
		return true;
	}
}
