/**
 * A class to represent generic employees
 * @author s-llian
 *
 */
public class Employee {
	private int years;
	public Employee(int years) {
		this.years = years;
	}
	// methods
	public int getYears() {
		return years;
	}
	public int getHours() {
		return 40;
	}
	public double getSalary() {
		return 50000;
	}
	public int getVacationDays() {
		return 10 + 2 * years;
	}
	public String getVacationForm() {
		return "yellow";
	}
	public String toString() {
		return "hours: " + getHours() + "salary: " + getSalary() + "vacation days: " + getVacationDays()
			+ "vacation form: " + getVacationForm();
	}
}
