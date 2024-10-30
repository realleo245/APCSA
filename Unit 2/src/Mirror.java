/**
 * Draws a scalable mirror
 * @author s-llian
 * Date 10-5-2023
 */
public class Mirror {
	
	public static final int SIZE = 10;

	public static void main(String[] args) {
		line();
		topHalf();
		bottomHalf();
		line();
	}
	/**
	 * Draws the line figure
	 */
	public static void line() {
		//#
		System.out.print("#");
		//draw 16=s
		for(int i = 1; i <= 4 * SIZE; i++) {
			System.out.print("=");
		}
		//#
		System.out.print("#");
		//new line
		System.out.println();
	}
	/**
	 * This draws the top half of the mirror
	 */
	public static void topHalf() {
		for(int line = 1; line <= SIZE; line++) {
			//|
			System.out.print("|");
			//print -2 * line + 8 spaces
			for(int space = 1; space <= -2 * line + 2 * SIZE; space++) {
				System.out.print(" ");
			}
			//<>
			System.out.print("<>");
			//dots
			for(int dot = 1; dot <= 4 * line - 4; dot++) {
				System.out.print(".");
			}
			//<>
			System.out.print("<>");
			//spaces
			for(int space = 1; space <= -2 * line + 2 * SIZE; space++) {
				System.out.print(" ");
			}
			//|
			System.out.print("|");
			//new line
			System.out.println();
		}
	}
	/**
	 * This draws the bottom half of the mirror
	 */
	public static void bottomHalf() {
		System.out.println("Drawing the bottom half");
	}
}
