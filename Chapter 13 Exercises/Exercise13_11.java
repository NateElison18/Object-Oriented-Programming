/*
 * Author: Nate Elison
 * Date: 4/27/23
 * 
 * This program creates the abstract class GeometricObjects and it's subclass Octagon that implements cloneable and comparable. 
 * It then tests the methods by creating an Octagon object using the constructor and another using clone and finally comparing them using compareTo. 
 */

import java.lang.*;

public class Exercise13_11 {

	public static void main(String[] args) {
		// Create Octagon
		Octagon oct1 = new Octagon(5);
		
		// Clone Octagon to second object
		Octagon oct2 = (Octagon)(oct1.clone());
		
		// Compare Octagons
		System.out.println("Are the two octagons equivilent? ");
		if(oct1.compareTo(oct2) == 0)
			System.out.println("Yes");
		else System.out.println("No");
	}

}
//Abstract GeometricObject Class
abstract class GeometricObject{
	String color = "white";
	boolean filled;
	java.util.Date dateCreated;
			
	// Constructors 
	protected GeometricObject(){
		dateCreated = new java.util.Date();
	}
			
	protected GeometricObject(String newColor, boolean newFilled) {
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
	
	// Abstract methods
	public abstract double getArea();
	public abstract double getPerimeter();
	//public abstract boolean compareTo(Octagon o);
}

// Subclass Octagon
class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>{
	// Create variables
	double sides = 1;
	
	// Constructors 
	Octagon(){
		
	}
	Octagon(double newSides){
		sides = newSides;
	}
	
	// Side Getter 
	public double getSides() {
		return sides;
	}
	
	@Override
	// Inherited Methods
	public double getArea() {
		double area = ((2 + (4 / Math.sqrt(2))) * sides * sides);
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double perimeter = sides * 8;
		return perimeter; 
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		}catch(CloneNotSupportedException ex) {
			ex.printStackTrace();
			return null;
		}
				
	}
	
	@Override
	public int compareTo(Octagon o) {
		if (getSides() == o.getSides())
			return 0;
		else return 1;
	}
}