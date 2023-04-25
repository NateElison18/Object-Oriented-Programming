/*
 * Author: Nate Elison
 * Date: 4/25/23
 * 
 * This program creates a .txt file, writes 100 integers to it, and finally displays those integers in increasing order. 
 * The program exits if the file already exists. 
 */

import java.io.File;
import java.util.Scanner;

public class Exercise12_15 {

	public static void main(String[] args) throws java.io.IOException{
		// Create file if it does not exist. Exit program if it does. 
		File file = new java.io.File("Exercise12_15.txt");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}
		
		// Write integers created randomly into the file
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		for(int i = 0; i < 100; i++) {
			output.print((int) (Math.random() * 100) + " ");
		}
		output.close();
		
		
		// Create Scanner, create an array w the file values, sort and print that array. 
		Scanner input = new Scanner(file);
		int[] sorted = new int[100];
		for(int i = 0; i < 100; i++) {
			sorted[i] = input.nextInt();
		}
		java.util.Arrays.sort(sorted);
		for(int i = 0; i < 100; i++)
			System.out.print(sorted[i] + " ");
	}

}
