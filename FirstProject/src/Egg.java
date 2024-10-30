/**
 * Draws a series of figures
 * @author s-llian
 *
 */
public class Egg {
	public static void main(String[] args) {
		egg();
		teaCup();
		stopSign();
		hat();
	}
	/**
	 * Draws an egg
	 */
	public static void egg() {
		// egg
		eggTop();
		eggBottom();
		System.out.println();
	}
	/**
	 * Draws a teacup
	 */
	public static void teaCup() {
		// teaCup
		eggBottom();
		line();
		System.out.println();
	}
	/**
	 * Draws a stop sign
	 */
	public static void stopSign() {
		// stopSign
		eggTop();
		System.out.println("|  STOP  | ");
		eggBottom();
		System.out.println();
	}
	/**
	 * Draws a hat
	 */
	public static void hat() {
		// hat
		eggTop();
		line();
	}
	/**
	 * Draws an egg top
	 */
	public static void eggTop() {
		System.out.println("  ______ ");
		System.out.println(" /      \\");
		System.out.println("/        \\");
	}
	/**
	 * Draws an egg bottom
	 */
	public static void eggBottom() {
		System.out.println("\\        /");
		System.out.println(" \\_____ /");
	}
	/**
	 * Draws an egg line
	 */
	public static void line() {
		System.out.println("+-------+");
	}
}
