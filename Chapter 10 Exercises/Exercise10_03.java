/*
 * Author: Nate Elison
 * Date: 4/18/23
 * 
 * This program creates and tests the MyInteger class that can create objects with an int value and has methods to test the value. 
 */
public class Exercise10_03 {

	public static void main(String[] args) {
		// Test class methods
		MyInteger integer1 = new MyInteger(5);
		MyInteger integer2 = new MyInteger(10);
		
		System.out.println("The value of Integer1 is set to " + integer1.getValue());
		System.out.println("Is Integer1 even? " + integer1.isEven());
		System.out.println("Is Integer1 odd? " + integer1.isOdd());
		System.out.println("Is Integer1 prime? " + integer1.isPrime());
		
		System.out.println();
		
		System.out.println("The value of Integer2 is set to " + integer2.getValue());
		System.out.println("Is Integer2 even? " + integer1.isEven(integer2));
		System.out.println("Is Integer2 odd? " + integer1.isOdd(integer2));
		System.out.println("Is Integer2 prime? " + integer1.isPrime(integer2));
		
		System.out.println();
		
		System.out.println("Is Integer1 equal to Integer2? " + integer1.equals(integer2));
		System.out.println("Is Integer 2 equal to 10? " + integer2.equals(10));


	}

}

class MyInteger {
	int value;
	
	// Constructor
	MyInteger(int newValue){
		value = newValue;
	}
	public void setValue(int change) {
		value = change;
	}
	
	// Getter method
	public int getValue() {
		return value;
	}
	
	// Non-static methods to test object's value 
	public boolean isEven() {
		return isEven(value);
	}
	
	public boolean isOdd() {
		return isOdd(value);
	}
	
	public boolean isPrime() {
		return isPrime(value);
	}
	
	// Static methods to test a new given value
	public static boolean isEven(int value) {
		if (value % 2 == 0) return true;
		else 				return false;
	}
	
	public static boolean isOdd(int value) {
		if (value % 2 != 0) return true;
		else				return false;
	}
	
	public static boolean isPrime(int value) {
		boolean isPrime = true;
		for (int i = 0; i < (value - 2); i++) {
			if (value % (i + 2) == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	// Static methods to test value
	public static boolean isEven(MyInteger integer1) {
		return isEven(integer1.getValue());
	}
	
	public static boolean isOdd(MyInteger integer1) {
		return isOdd(integer1.getValue());
	}
	
	public static boolean isPrime(MyInteger integer1) {
		return isPrime(integer1.getValue());
	}
	
	// Non-static methods to compare object's value with a specified value
	public boolean equals(int value) {
		if (this.value == value) return true;
		else 					 return false;
	}
	
	public boolean equals(MyInteger integer1) {
		if (value == integer1.getValue()) return true;
		else 							  return false;
	}
	
	// Static parse methods  
	public static int parseInt(char[] chars) {
		return Integer.parseInt(new String(chars));
	}
	
	public static int parseInt(String number) {
		return Integer.parseInt(number);
	}
}
