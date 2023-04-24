/*
 * Author: Nate Elison
 * 
 * Date: 4/20/23
 * 
 * This program creates a superclass GeometricObject and it's subclass Triangle, 
 * and tests both by allowing a user to input triangle info before displaying the shape's info. 
 */

import java.util.Scanner;

public class Exercise11_01 {

	public static void main(String[] args) {
		
		// Prompt user for triangle info
		Scanner input = new Scanner(System.in);
		System.out.print("Enter side 1: ");
		double side1 = input.nextDouble();
		
		System.out.print("Enter side 2: ");
		double side2 = input.nextDouble();
		
		System.out.print("Enter side 3: ");
		double side3 = input.nextDouble();
		
		// Create Triangle
		Triangle triangle = new Triangle(side1, side2, side3);
		
		// Get color, filled status and apply to the object
		System.out.print("Enter color: ");
		input.nextLine();
		String color = input.nextLine();
		triangle.setColor(color);		

		
		System.out.print("Is the triangle filled? (yes or no): ");
		String filled = input.next();
		if (filled.equalsIgnoreCase("no")) triangle.setFilled(false);
		else 							   triangle.setFilled(true);
		
		
		// Display triangle description 
		System.out.println("Trangle Details");
		System.out.println("------------------");
		System.out.println("Area " + triangle.getArea());
		System.out.println("Perimeter: " + triangle.getPerimeter());
		System.out.println("Color: " + triangle.getColor());
		System.out.println("Date created: " + triangle.getDateCreated());
		System.out.println("Filled? " + triangle.isFilled());
				
	} 

}


class GeometricObject{
	String color = "white";
	boolean filled;
	java.util.Date dateCreated;
	
	// Constructors 
	public GeometricObject(){
		dateCreated = new java.util.Date();
	}
	
	public GeometricObject(String newColor, boolean newFilled) {
		dateCreated = new java.util.Date();
		color = newColor;
		filled = newFilled;
	}
	
	// Getter and setter methods
	public String getColor() {
		return color;
	}
	
	public void setColor(String newColor) {
		color = newColor;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated(){
		return dateCreated;
	}
	
	// toString method
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}
	
}

class Triangle extends GeometricObject{
	double side1 = 1;
	double side2 = 1;
	double side3 = 1;
	
	// Constructors 
	Triangle(){
	}
	
	Triangle(double newSide1, double newSide2, double newSide3){
		side1 = newSide1;
		side2 = newSide2;
		side3 = newSide3;
	}
	
	// Get perimeter and area methods
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public double getArea() {
		double s = getPerimeter() / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	// toString method
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}
