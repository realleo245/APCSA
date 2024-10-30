
public class LegalSecretary extends Secretary {
	@Override
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + 5000;
	}
	public void fileLegalBriefs() {
		System.out.println("You're screwed");
	}
}
