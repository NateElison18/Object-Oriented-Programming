import java.util.Scanner;

public class Exercise06_19 {

	public static void main(String[] args) {
		// Get sides from user
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the length of the 3 sides of the triangle: ");
		double sides[];
		sides = new double[3];
		for (int i = 0; i < 3; i++) {
			sides[i] = input.nextDouble();
		}
		if(isValid(sides[0], sides[1], sides[2])) {
			for (int i = 0; i < 3; i++) {
				System.out.println("Side " + (i + 1) + ": " + sides[i]);
			}
			double area = area(sides[0], sides[1], sides[2]);
			System.out.printf("Area: %.1f", area);
		}
		else 
			System.out.println("That is not a valid triangle");
		
		// Print if its valid and the area

	}
	/** Return true if the sum of every two sides is greater than the third side.*/
	public static boolean isValid(double side1, double side2, double side3) {
		boolean isValid = false;
		if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1)
			isValid = true;
		return isValid;
	}

	/** Return the area of the triangle. */
	public static double area(double side1, double side2, double side3) {
		double s = ((side1 + side2 + side3) / 2.0);
		double area = Math.sqrt((s * (s - side1) * (s - side2) * (s - side3))); 
		return area;
	}
}
