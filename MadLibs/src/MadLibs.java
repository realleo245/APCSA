import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args) throws FileNotFoundException {
		//fileTest("files/clothes.txt", "files/out.txt");
		intro();
		Scanner console = new Scanner(System.in);
		String command = "X";
		while(!command.equals("Q")) {
			System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit?");
			command = console.nextLine().substring(0, 1).toUpperCase();
			if(command.equals("C")) {
				System.out.println("Create!");
				Scanner input = getInputFile(console);
				PrintStream output = getOutputFile(console);
				createMadLib(console, input, output);
				input.close();
				output.close();
			}
			else if(command.equals("V")) {
				//System.out.println("View!");
				
				Scanner input = getInputFile(console);
				viewFile(input);
				input.close();
			}
		}
		console.close();
	}
	public static void createMadLib(Scanner console, Scanner inputFile, PrintStream output) {
		while(inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()) {
				String token = lineScan.next();
				if(token.startsWith("<") && token.endsWith(">")) {
					token = token.substring(1, token. length()-1); //removes the < >
					System.out.print("Please type a/an " + token + ": ");
					token = console.nextLine();
				}
				output.print(token + " ");
			}
			lineScan.close();
			output.println();
		}
	}
	// Views a file and prints it to the console;
	public static void viewFile(Scanner inputFile) {
		while(inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()) {
				String token = lineScan.next();
				System.out.print(token + " ");
			}
			lineScan.close();
			System.out.println();
		}
	}

	//Reads a file name from the user and return a Scanner to that file
	public static Scanner getInputFile(Scanner console) throws FileNotFoundException {
		boolean foundFile = false;
		Scanner input = null;
		System.out.print("Input file name: ");
		while(!foundFile) {
			File f = new File("files/" + console.nextLine());
			if(f.exists()) {
				input = new Scanner(f);
				foundFile = true;
			}
			else {
				System.out.print("File not found. Try again: ");
			}
		}
		return input;
	}
	// Reads a file name from a user and returns a PrintStream to that file

	public static PrintStream getOutputFile(Scanner console) {
		boolean foundFile = false;
		PrintStream output = null;
		System.out.print("Output file name: ");
		while(!foundFile) {
			try {
				File f = new File("files/" + console.nextLine());
				output = new PrintStream(f);
				foundFile = true;
			}
			catch(FileNotFoundException e) {
				System.out.print("File not found. Try again: ");
			}
		}
		return output;
	}
	public static void intro() {
		System.out.println("Welcome to the game of Mad Libs");
		System.out.println("I will ask you to provide various words");
		System.out.println("and phrases to fill in a story");
		System.out.println("The results will be printed to an output file.");
		System.out.println();
	}
	
	public static void fileTest(String inputName, String outputName) throws FileNotFoundException {
		File iF = new File(inputName);
		File oF = new File(outputName);
		Scanner fileScan = new Scanner(iF);
		PrintStream ps = new PrintStream(oF);
		while(fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()) {
				String token = lineScan.next();
				ps.print(token + " ");
			}
			ps.println();
			lineScan.close();
		}
		
		fileScan.close();
		ps.close();
	}
}

