
public class Program {

	public static void main(String[] args) {
		Point a = new Point(8, 1);
//		a.x = 8;
//		a.y = 1;
		
		Point b = new Point();
		b.setX(11);
		b.setY(5);
		
		System.out.println(a.getX() + " " + a.getY());
		System.out.println(b.toString());
		System.out.println(b);
		
		b.translate(a.getX(), b.getY());
		
		System.out.println(b.toString());
		
		System.out.println(a.distanceTo(b));
		System.out.println(b.distanceTo(a));
	}

}
