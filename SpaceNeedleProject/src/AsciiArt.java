
public class AsciiArt {
	/*
	 * Reference picture
	 *          /\
	 *         /  \
	 *        /    \
	 *       |      |
	 *       |      |
	 *       |      |
	 *       |      |
	 *  -----|      | -----
	 * |     |      |      |
	 *  -----|      | -----
	 *  	 |      |
	 *  	 |      |
	 *  	 |      |
	 *  	 |      |
	 *  	/        \
	 *     /          \
	 *    /            \
	 *   /              \
	 *  /                \
	 *	------------------ 
	 */
	public static void main(String[] args) {
		nose();
		narrowTop();
		wings();
		narrowBottom();
		bottom();
	}
	public static void nose() {
		for(int i = 0; i < 3; i++) {
			 int numBeginningSpaces = -1 * i + 9;
			 for(int j = 0; j < numBeginningSpaces; j++) {
				 System.out.print(" ");
			 }
			 System.out.print("/");
			 int numMiddleSpaces = 2 * i;
			 for(int j = 0; j < numMiddleSpaces; j++) {
				 System.out.print(" ");                          
			 }
			 System.out.print("\\");
			 System.out.println();
		}
	}
	public static void narrowTop() {
		narrow();
	}
	public static void wings() {
		System.out.println(" -----|      | -----");
		System.out.println("|                   |");
		System.out.println(" -----|      | -----");
	}
	public static void narrowBottom() {
		narrow();
	}
	public static void bottom() {
		for(int i = 0; i < 5; i++) {
			int numBeginningSpaces = -1 * i + 5;
			for(int j = 0; j < numBeginningSpaces; j++) {
				System.out.print(" ");
			}
			System.out.print("/");
			int numMiddleSpaces = 2 * i + 8;
			for(int j = 0; j < numMiddleSpaces; j++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			System.out.println();
		}
		System.out.println(" ------------------");
	}
	public static void narrow() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			for(int j = 0; j < 6; j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			System.out.println();
		}
	}
}
