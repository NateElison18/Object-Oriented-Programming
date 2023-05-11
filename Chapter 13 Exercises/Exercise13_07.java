/*
 * Author: Nate Elison
 * Date: 4/26/23
 * 
 * This program creates an abstract superclass GeometricObject, it's subclass Triangle, and the interface Colorable that both classes implement. 
 * Then it tests the classes by creating an array of 5 objects and displaying their area and the color instructions.  
 * 
 */
public class Exercise13_07 {

	public static void main(String[] args) {
		// Create array of objects
		GeometricObject[] triangles = new Triangle[5];
		for(int i = 0; i < 5; i++) {
			triangles[i] = new Triangle(i + 1, i + 1, i + 1);
		}
		
		// Display objects' info
		System.out.println("Triangle info: ");
		System.out.println("--------------------------------");
		for (int i = 0; i < 5; i++) {
			System.out.println("   " + (i + 1) + ": ");
			System.out.println("\tArea: " + triangles[i].getArea());
			System.out.print("\tTo color: ");
			triangles[i].howToColor();
			System.out.println("--------------------------------");
		}
	}

}

// Abstract GeometricObject Class
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
	public abstract void howToColor();
			
}

// Triangle subclass class
class Triangle extends GeometricObject implements Colorable {
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
	
	// Implement colorable
	public void howToColor() {
		System.out.println("Color all three sides.");
	}
}

// Colorable interface 
interface Colorable {
	void howToColor(); 
}
