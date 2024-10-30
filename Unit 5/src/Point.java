
public class Point {
	// data
	private int x;
	private int y;
	// constructor
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
//		this.x = 0;
//		this.y = 0;
		this(0, 0);
	}
	// behavior
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Adds i to x, j to y
	 * @param i
	 * @param j
	 */
	public void translate(int i, int j) {
		x = x + i;
		y = y + j;
	}
	/**
	 * Calculates and returns distance between this point and the other
	 * @param other
	 * @return
	 */
	public double distanceTo(Point other) {
		int dY = this.y - other.y;
		int dX = this.x - other.x;
		double distance = Math.sqrt(dX * dX + dY * dY);
		return distance;
	}
}
