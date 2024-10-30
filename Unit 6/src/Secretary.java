/**
 * Represents a secretary
 * @author s-llian
 *
 */
public class Secretary extends Employee {
	public Secretary() {
		super(0);
	}
	public void takeDictation(String text) {
		System.out.println("Taking dictations of text: " + text);
	}
}