/**
 * @author s-llian
 * Date: 10/5/2023
 * Period: 5
 */
public class SpaceNeedle {
	public static final int SIZE = 5;
	public static void main(String[] args) {
		topPipes();
		observationDeck();
		middlePipes();
		percentSigns();
		bottomColons();
		floor();
	}
	/**
	 * Prints the very top of the Space Needle
	 */
	public static void topPipes() {
		pipes();
	}
	/**
	 * Prints the Space Needle observation deck
	 */
	public static void observationDeck() {
		colons();
		quotes();
		ears();
	}
	/**
	 *  Print the narrowest part of the Space Needle
	 */
	public static void middlePipes() {
		pipes();
	}
	/**
	 * Prints the part of the Space Needle with the percent signs
	 */
	public static void percentSigns() {
		for(int i = 0; i < SIZE * SIZE; i++) {
			// Prints spaces
			int numSpaces = 2 * SIZE + 1;
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}
			// Prints weird figure with pipes and percent signs
			int numPercentSigns = SIZE - 2;
			System.out.print("|");
			for(int j = 0; j < numPercentSigns; j++) {
				System.out.print("%");
			}
			System.out.print("||");
			for(int j = 0; j < numPercentSigns; j++) {
				System.out.print("%");
			}
			System.out.print("|");
			// Prints spaces
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	/**
	 * Prints the bottom part that expands to the floor
	 */
	public static void bottomColons() {
		colons();
	}
	/**
	 * Prints the floor
	 */
	public static void floor() {
		quotes();
	}
	/**
	 * Prints the pipe pattern
	 */
	public static void pipes() {
		for(int i = 0; i < SIZE; i++) {
			int numSpaces = 3 * SIZE;
			// Prints spaces
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}     
			// Prints the pipes
			System.out.print("||");
			// Prints spaces
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}
			// New line  
			System.out.println();
		}
	}
	/**
	 * Prints entire colon pattern
	 */
	public static void colons() {
		for(int i = 0; i < SIZE; i++) {
			int numSpaces = -3 * i + 3 * SIZE - 2;
			// Print spaces
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}  
			// Prints -/
			System.out.print("_/");
			int numColons = 3 * i;
			// Prints colons
			for(int j = 0; j < numColons; j++) {
				System.out.print(":");
			}
			System.out.print("||");
			// Prints colons
			for(int j = 0; j < numColons; j++) {
				System.out.print(":");
			}
			// Prints \_
			System.out.print("\\_");
			// Prints spaces
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}
			// New line
			System.out.println();
		}
	}
	/**
	 * Prints the quote pattern
	 */
	public static void quotes() {
		// Print |
		System.out.print("|");
		// Print 24 "
		for(int i = 0; i < 6 * SIZE; i++) {
			System.out.print("\"");
		}
		// Print |
		System.out.print("|");
		// New line
		System.out.println();
	}
	public static void ears() {
		for(int i = 0; i < SIZE; i++) {
			// Print spaces
			int numSpaces = 2 * i;
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}
			// Print \_
			System.out.print("\\_");
			// Print ears
			int numEars = -2 * i + 3 * SIZE - 1;
			for(int j = 0; j < numEars; j++) {  
				System.out.print("/\\");
			}  
			// print _/
			System.out.print("_/");
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}
			// Print spaces
			for(int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}
			// New line
			System.out.println();   
		}
		  
	}
}