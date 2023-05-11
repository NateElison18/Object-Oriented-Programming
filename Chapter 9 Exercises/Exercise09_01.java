/*
 * Author: Nate Elison
 * Date: 4/17/23
 * 
 * This program creates a Rectangle class and tests that class by 
 * creating two rectangle objects and displays their width, height, area, and perimeter in that order. 
 */
public class Exercise09_01 {

	public static void main(String[] args) {
		// Create the rectangle objects
		Rectangle rectangle1 = new Rectangle(4, 40);
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		
		// Display width, height, area, and perimeter in that order
		System.out.println("Rectangle 1 specs: " + rectangle1.width + ", " + rectangle1.height + ", " +
				rectangle1.getArea() + ", " + rectangle1.getPerimeter());
		System.out.println("Rectangle 2 specs: " + rectangle2.width + ", " + rectangle2.height + ", " +
				rectangle2.getArea() + ", " + rectangle2.getPerimeter());
	}

}

class Rectangle{
	double width = 1;
	double height = 1;
	
	// Constructors: default and specified width, height
	Rectangle(){
	}
	
	Rectangle(double newWidth, double newHeight){
		width = newWidth;
		height = newHeight;
	}
	
	// Method to get and return the area of the rectangle.  
	double getArea() {
		double area;
		area = width * height;
		return area;
	}
	
	// Method to get and return the perimeter of the rectangle. 
	double getPerimeter() {
		double perimeter;
		perimeter = (width * 2) + (height * 2);
		return perimeter;
	}
}