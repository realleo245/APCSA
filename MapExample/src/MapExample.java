import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Reads in a book
 */
public class MapExample {
	public static final String BOOK = "mobydick.txt";
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File(BOOK);
		Scanner s = new Scanner(f);
		Scanner console = new Scanner(System.in);
		
		Map<String, Integer> map = buildMap(s);
		String question = "";
		while(!question.equals("quit")) {
			System.out.print("word (quit to exit)? ");
			question = console.nextLine();
			if(map.containsKey(question)) {
				System.out.println(question + "occurs " + map.get(question) + " times.");
			} else {
				System. out. println(question + " does not occur in the book.");
			}
		}
		print500(map);
		s.close();
		console.close();
	}
	public static String filter(String str) {
		str = str.toLowerCase();
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 'a' && c <= 'z') {
				result = result + c;
			}
		}
		return result;
	}
	
	public static Map<String, Integer> buildMap(Scanner book){
		Map<String, Integer> map = new TreeMap<String, Integer>();

		//loop through the book
		while(book.hasNext()) {
			String curWord = filter(book.next());
			if(curWord.length() >= 1) {
				//is it in the map already?
				if(map.containsKey(curWord)) {
					int value = map.get(curWord);
					map.put(curWord, value + 1);
				}
				else{
					map.put(curWord, 1);
				}

			}

		}
		return map;

	}

	public static void print500(Map<String, Integer> map) {
		for(String key : map.keySet()) {
			int frequency = map.get(key);
			if(frequency >= 500) {
				System.out.println(key + ":" + frequency);
		
			}	
		
		}
	}
}
