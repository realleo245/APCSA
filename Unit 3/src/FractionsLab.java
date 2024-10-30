import java.util.Scanner;

/**
 * This reads and prompts the user to enter a fraction with the format whole number / numerator & denominator
 * Calculates the double value of the fraction and then prints them
 * @author s-llian
 *
 */
public class FractionsLab {

	public static void main(String[] args) {
		// 1) Create a Scanner to console
		Scanner console = new Scanner(System.in);
		// 2a) Ask user to type in fraction
		System.out.print("Input a fraction in form whole_numerator/denominator:");
		// 2) Read in fraction from the user
		String userInput = console.next();
		// 2c) solve the fraction
		
		double answer = solveFraction(userInput);
		
		
		
		// 8) Prints the fraction
		System.out.println(answer);
	}
	
	public static double solveFraction(String fraction) {
		// 3a) Splits the part of the fraction
		int uIndex = fraction.indexOf("_");
		int sIndex = fraction.indexOf("/");
		
		// 3b) Stores the part of the fraction
		String whole = fraction.substring(0, uIndex);
		String numerator = fraction.substring(uIndex + 1, sIndex);
		String denominator = fraction.substring(sIndex + 1);
		// 4) Convert the string to integer
		int w = Integer.parseInt(whole);
		int n = Integer.parseInt(numerator);
		int d = Integer.parseInt(denominator);
		// 5) Calculate the double value
		double result = w + (double) n/d;
		// 6) return the double value of the fraction
		return result;
	}
}
