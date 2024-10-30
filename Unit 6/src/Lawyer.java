
public class Lawyer extends Employee {
	public Lawyer(int years) {
		super(years);
	}
	public void sue() {
		System.out.println("I'll see you in court.");
	}
	@Override
	public String getVacationForm() {
		return "pink";
	}
	@Override
	public int getVacationDays() {
		return super.getVacationDays() + 5;
	}
	@Override
	public double getSalary() {
		return super.getSalary() + super.getYears() * 5000;
	}
}
