
public class Equestria {

	public static void main(String[] args) {
		// Exercise 1
		double length = roadTrip(22.0);
		System.out.println("The length of the road trip is " + length);
		
		// Exercise 2
		double d1 = distance(29, 16, 34, 8);
		// Los Pegasus to Neighagra Falls
		double d2 = distance(6, 19, 22, 7);
		System.out.println("Distance from Los Pegasus to Neighagra Falls " + d2);
		// Badlands to Ponyville
		double d3 = distance(25, 24, 16, 14);
		System.out.println("Distance from Badlands to Ponyville " + d3);
		
		// Exercise 4
		// Manehattan (34, 8)
		// Badlands (24, 24)
		// Canterlot (18, 10)
		double totalTrip = totalTrip(34, 8, 24, 24, 18, 10);
		System.out.println(totalTrip);
	}
	/**
	 * @param diameter
	 * @return the circumference
	 */
	public static double roadTrip(double diameter) {
		return diameter * Math.PI;
	}
	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return the distance between 2 points
	 */
	public static double distance(int x1, int y1, int x2, int y2) {
		int xCoordinateDistance = x2 - x1;
		int yCoordinateDistance = y2 - y1;
		double distance = Math.sqrt(xCoordinateDistance * xCoordinateDistance + yCoordinateDistance * yCoordinateDistance);
		return distance;
	}
	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return the total trip distance
	 */
	public static double totalTrip(int x1, int y1, int x2, int y2, int x3, int y3) {
		double totalTrip = distance(x1, y1, x2, y2) + distance(x2, y2, x3, y3) + distance(x3, y3, x1, y1);
		return totalTrip;
	}

}
