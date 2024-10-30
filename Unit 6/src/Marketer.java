
public class Marketer extends Employee {
	public Marketer(int years) {
		super(years);
	}
	@Override
	public double getSalary() {
		return super.getSalary() + 10000;
	}
	public void advertise() {
		System.out.println("We will get your speeding ticket removed");
	}
}