import graphics.Graphics;

/**
 * Description: Prints...
 * @author s-llian
 * Date: 10-24-2023
 * Period: 5
 */
public class CafeArt {

	public static void main(String[] args) {
		Graphics.cafeWall.open();
		
		double totalArea = 0.0;
		
		totalArea += drawRow(0, 0, 4, 20);
		totalArea += drawRow(50, 70, 5, 30);

		totalArea += drawGrid(10, 150, 4, 25, 0);
		totalArea += drawGrid(250, 200, 3, 25, 10);
		totalArea += drawGrid(425, 180, 5, 20, 10);
		totalArea += drawGrid(400, 20, 2, 35, 35);
		
		System.out.println(totalArea);
		// Prints to 2 decimal places
		System.out.println(Math.round(percentage(totalArea, totalCafeWallArea()) * 100) / 100.0);
		
		Graphics.cafeWall.pause();
		
		Graphics.cafeWall.close();
	}
	/**
	 * Draws a row. Returns the area
	 * @param x
	 * @param y
	 * @param numPairs
	 * @param size
	 */
	public static double drawRow(int x, int y, int numPairs, int size) {
		int currentX = x;
		int currentY = y;
		double area = 0.0;
		for(int i = 0; i < numPairs; i++) {
			Graphics.cafeWall.drawDarkSquare(currentX, currentY, size);
			currentX += size;
			area += size * size;
			Graphics.cafeWall.drawBrightSquare(currentX, currentY, size);
			currentX += size;
			area += size * size;
		}
		return area;
	}
	/**
	 * Draw a grid
	 * @param x
	 * @param y
	 * @param numPairs
	 * @param size
	 * @param offset
	 * @return the area
	 */
	public static double drawGrid(int x, int y, int numPairs, int size, int offset) {
		int currentX = x;
		int currentY = y;
		double area = 0.0;
		for(int i = 0; i < numPairs; i++) {
			area += drawRow(currentX, currentY, numPairs, size);
			//System.out.println(currentX + " " + currentY + " " +  numPairs + " " + size);
			currentX += offset;
			currentY += size + 2;
			area += drawRow(currentX, currentY, numPairs, size);
			//System.out.println(currentX + " " + currentY + " " + numPairs + " " + size);
			currentX -= offset;
			currentY += size + 2;
		}
		return area;
	}
	/**
	 * 
	 * @return the total area of the Cafe Wall
	 */
	public static double totalCafeWallArea() {
		return Graphics.cafeWall.getHeight() * Graphics.cafeWall.getWidth();
	}
	/**
	 * 
	 * @param drawnArea
	 * @param totalArea
	 * @return the percentage of the area that is drawn
	 */
	public static double percentage(double drawnArea, double totalArea) {
		return 100 * (drawnArea / totalArea);
	}
	

}
