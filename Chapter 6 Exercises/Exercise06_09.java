/*
 * Author: Nate Elison
 * Date: 5/6/23
 * 
 * This program contains methods to convert from feet to meters and from meters to feet. 
 * It tests those methods by printing out a matrix of conversions. 
 */
public class Exercise06_09 {

	public static void main(String[] args) {
		// Printing out the test matrix
		System.out.println("Feet\tMeters\t\tMeters\tFeet");
		System.out.println("--------------------------------------");
		for(int i = 0; i < 10; i++) {
			double meters = 20 + (5 * i);
			double feet = i + 1;
			double convertedToMeters = footToMeter(feet);
			double convertedToFeet = meterToFoot(meters);
			System.out.printf("%.1f\t%.3f\t\t%.1f\t%.3f", feet, convertedToMeters, meters, convertedToFeet);
			System.out.println();
		}
	}
	// Convert from feet to meters 
	public static double footToMeter(double foot) {
		double meter;
		final double conversionFactor = 0.305;
		
		meter = conversionFactor * foot;
		return meter;
	}

	// Convert from meters to feet
	public static double meterToFoot(double meter) {
		double foot;
		final double conversionFactor = 3.279;
		
		foot = conversionFactor * meter;
		return foot;
		
	}

}
