/**
 * Project 1: This project will...
 * @author s-llian
 * Date: 9/19/23
 * Period 5
 */
public class Song {
	public static void main(String[] args) {
		printFirstVerse();
		System.out.println();
		printSecondVerse();
		System.out.println();
		printThirdVerse();
		System.out.println();
		printFourthVerse();
		System.out.println();
		printFifthVerse();
		System.out.println();
		printSixthVerse();
		System.out.println();
		printSeventhVerse();
	}
	/**
	 * Prints the first verse
	 */
	public static void printFirstVerse() {
		System.out.println("There was an old woman who swallowed a fly.");
		printFlyInquiry();
		printDeathWarning();
	}
	/**
	 * Prints the second verse
	 */
	public static void printSecondVerse() {
		System.out.println("There was an old woman who swallowed a spider,");
		System.out.println("That wriggled and iggled and jiggled inside her.");
		printSpiderStatement();
		printFlyInquiry();
		printDeathWarning();
	}
	/**
	 * Prints the third verse
	 */
	public static void printThirdVerse() {
		System.out.println("There was an old woman who swallowed a bird,");
		System.out.println("How absurd to swallow a bird.");
		printBirdStatement();
		printSpiderStatement();
		printFlyInquiry();
		printDeathWarning();
	}
	/**
	 * Prints the fourth verse
	 */
	public static void printFourthVerse() {
		System.out.println("There was an old woman who swallowed a cat,");
		System.out.println("Imagine that to swallow a cat.");
		printCatStatement();
		printBirdStatement();
		printSpiderStatement();
		printFlyInquiry();
		printDeathWarning();
	}
	/**
	 * Prints the fifth verse
	 */
	public static void printFifthVerse() {
		// This may appear redundant, but the difference at the end makes it impossible
		// to eliminate this redundancy with just static methods without parameters with only println statements.
		System.out.println("There was an old woman who swallowed a dog,");
		System.out.println("What a hog to swallow a dog.");
		printDogStatement();
		printCatStatement();
		printBirdStatement();
		printSpiderStatement();
		printFlyInquiry();
		printDeathWarning();
	}
	/**
	 * Prints the sixth verse
	 */
	public static void printSixthVerse() {
		System.out.println("There was an old woman who swallowed a wolf");
		System.out.println("What a strange woman to swallow a wolf");
		System.out.println("She swallowed the wolf to catch the dog");
		printDogStatement();
		printCatStatement();
		printBirdStatement();
		printSpiderStatement();
		printFlyInquiry();
		printDeathWarning();
	}
	/**
	 * Prints the seventh verse
	 */
	public static void printSeventhVerse() {
		System.out.println("There was an old woman who swallowed a horse, She");
		System.out.println("died of course");
	}
	public static void printDogStatement() {
		System.out.println("She swallowed the dog to catch the cat,");
	}
	/**
	   * Prints "She swallowed the cat to catch the bird,"
	 */
	public static void printCatStatement() {
		System.out.println("She swallowed the cat to catch the bird,");
	}
	/**
	 * Prints "She swallowed the bird to catch the spider,"
	 */
	public static void printBirdStatement() {
		System.out.println("She swallowed the bird to catch the spider,");
	}
	/**
	 * Prints "She swallowed the spider to catch the fly"
	 */
	public static void printSpiderStatement() {
		System.out.println("She swallowed the spider to catch the fly,");
	}
	/**
	 * Prints fly inquiry 
	 */
	public static void printFlyInquiry() {
		System.out.println("I don't know why she swallowed that fly,");
	}
	/**
	 * Prints "Perhaps, she'll died"
	 */
	public static void printDeathWarning() {
		System.out.println("Perhaps she'll die.");
	}
}
