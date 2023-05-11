/*
 * Author: Nate Elison
 * Date: 04/06/23
 * 
 * This program gets a string from the user and prints the number of characters and the number of letters of the string. 
 */
import java.util.Scanner;

public class Exercise06_20 {

	public static void main(String[] args) {
		// Get String
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String answer = input.nextLine();
		
		// Get character count and letter count
		int characters = answer.length();
		int letters = countLetters(answer);
		
		// Print results 
		System.out.println("'" + answer + "' is " + characters + " characters long.");
		System.out.println("There are " + letters + " letters in '" + answer + "'.");

	}
	
	// Method to count only the letters in a string
	public static int countLetters(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i) > 64 && s.charAt(i) < 91) || (s.charAt(i) > 96 && s.charAt(i) < 123))
				count ++;
		}
		return count;
	}


}
