import java.util.Random;
import java.util.Scanner;
/**
 * A guessing game
 * @author s-llian
 * P5
 */
public class GuessingGame {
	public static final int MAX = 100;
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Random random = new Random();
		printHaiku();
		String stats = playGame(console, random);
		printStats(stats);
	}
	/**
	 * Prints the welcome haikiu
	 */
	public static void printHaiku() {
		System.out.println("Welcome user!");
		System.out.println("This game is very fun!");
		System.out.println("Or is it funny?");
	}
	/**
	 * Runs the main game loop
	 * @param console
	 * @param random
	 * @return
	 */
	public static String playGame(Scanner console, Random random) {
		String guesses = "";
		boolean playAgain = true;
		do {
			// Converts the integer result of an int to a String
			guesses += Integer.toString(play1Game(console, random)) + " ";
			System.out.print("Do you want to play again?");
			String response = console.next();
			// Plays the game again if the responses begins with Y or y
			playAgain = response.charAt(0) == 'Y' || response.charAt(0) == 'y';
		}
		while(playAgain);
		return guesses;
	}
	/**
	 * Runs one game
	 * @param console
	 * @param random
	 * @return
	 */
	public static int play1Game(Scanner console, Random random) {
		System.out.println("I'm thinking of a number between 1 and 100...");	
		int number = random.nextInt(MAX) + 1;
		System.out.println("HINT: It's" + number);
		int guess = 0;
		int numGuesses = 0;
		do {
			System.out.print("Your guess? ");
			guess = console.nextInt();
			if(guess > number) {
				System.out.println("It's lower.");
			}
			else if(guess < number) {
				System.out.println("It's higher.");
			}
			numGuesses++;
		}
		while(guess != number);
		if(numGuesses == 1) {
			System.out.println("You got it in " + numGuesses + " guess!");
		} 
		else {
			System.out.println("You got it in " + numGuesses + " guesses!");
		}
		return numGuesses;
	}
	/**
	 * Prints the stats
	 * @param guesses
	 */
	public static void printStats(String guesses) {
		int totalGames = 0;
		int totalGuesses = 0;
		int bestGame = Integer.MAX_VALUE;
		Scanner scnr = new Scanner(guesses);
		while(scnr.hasNextInt()) {
			int currentGuesses = scnr.nextInt();
			totalGuesses += currentGuesses;
			totalGames++;
			if(currentGuesses < bestGame) {
				bestGame = currentGuesses;
			}
		}
		System.out.println("Total games       = "+ totalGames);
		System.out.println("Total guesses     = "+ totalGuesses);
		System.out.println("Guesses per games  = "+ Math.round((double)totalGuesses / totalGames) * 10 / 10.0);
		System.out.println("Best game         = " + bestGame);
	}
}
