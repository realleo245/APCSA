import java.util.ArrayList;

/**
 * Tests the law firm class
 * @author s-llian
 *
 */
public class LawFirmTester {
	public static void main(String[] args) {
		Employee e = new Employee(4);
		System.out.println(e);
		
		Secretary s = new Secretary();
		System.out.println(s);
		s.takeDictation("Tell Jane Doe we're suing her");
		
		Lawyer law = new Lawyer(5);
		System.out.println(law);
		law.sue();
		
		Marketer mark = new Marketer(3);
		System.out.println(mark);
		mark.advertise();
		
		LegalSecretary ls = new LegalSecretary();
		System.out.println(ls);
		ls.fileLegalBriefs();
		
		ArrayList<Employee> staff = new ArrayList<>();
		
		staff.add(e);
		staff.add(s);
		staff.add(law);
		staff.add(mark);
		staff.add(ls);
		
		for(int i = 0; i < staff.size(); i++) {
			Employee temp = staff.get(i);
			System.out.println("Employee " + i + ":" + temp);
		}
	}
}
