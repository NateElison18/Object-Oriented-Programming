/*
Author: Nate Elison
Date: 4/24/23

This program creates an array of 100 randomly generated integers between 0 and 100, and prompts the user for an index. 
It displays the value at that index and throws an exception if the given index is outside the array. 
*/

import java.util.Scanner;

public class Exercise12_03 {

	public static void main(String[] args) {
		// Create Array
		int [] array = new int [100];
		for (int i = 0; i < 100; i++) {
			array [i] = (int) (Math.random() * 100);
		}
		
		//  Prompt user, create exception
		Scanner input = new Scanner(System.in);
		System.out.print("Input array index: ");
		int index = input.nextInt();

		
		
		// Print value or catch exception 
		try {
			if (index < 0 || index > 100) 
				throw new IndexOutOfBoundsException("Outside array range");
			System.out.println("The value at index " + index + " is " + array[index]);
		}
		
		catch (IndexOutOfBoundsException ex){
			System.out.println("Out of Bounds");
		}
	}

}
