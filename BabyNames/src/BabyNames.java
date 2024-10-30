import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Prompts the user for a name and shows them a graph of that names popularity between 1890 and 201
 * @author s-llian
 *
 */

public class BabyNames {

	public static void main(String[] args) throws FileNotFoundException {
		//Opens all the files
		File fNames = new File("names.txt");
		Scanner sNames = new Scanner(fNames);
		File fMeanings = new File("meanings.txt");
		Scanner sMeanings = new Scanner(fMeanings);
		Scanner console = new Scanner(System.in);
	
		
		intro();
		System.out.print("Name: ");
		String name = console.nextLine();
		String popularity = getMatch(name, sNames);
		String meaning = getMatch(name, sMeanings);
		if(popularity != null && meaning != null) {
			System.out.println(popularity);
			System.out.println(meaning);
			drawGraph(popularity,  meaning);
		} else {
			System.out.println("Name was not in the 1890-2010 chart");
		}
		
		console.close();
		sNames.close();
		sMeanings.close();
	}
	
	public static void intro() {
		System.out.println("This program allows us to search through the");
		System.out.println("data from the Social Security Administration");
		System.out.println("to see how popular a particular name has been");
		System.out.println("from 1890-2010");
		System.out.println();
	}




	public static String getMatch(String name, Scanner s) {
		Scanner lineScan = null;
		while(s.hasNextLine()) {
			String line = s.nextLine();
			lineScan = new Scanner(line);
			if(lineScan.next().toLowerCase().equals(name.toLowerCase())) {
				lineScan.close();
				return line;

			}
		}
		if(lineScan != null) lineScan.close();
		return null; //we were not able to find
	}

	public static void drawGraph(String popularity, String meaning) {
		DrawingPanel panel = new DrawingPanel(780, 560);
		Graphics g = panel.getGraphics();
		//draw the top + bottom
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 780, 30);
		g.fillRect(0,530, 780, 30);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 780, 30);
		g.drawRect(0,530, 780, 30);
		g.drawString(meaning, 0, 16);
		
		int year = 1890;
		int colWidth = 60;
		//Make a scanner of the popularity
		Scanner pScanner = new Scanner(popularity);
		//burn the name and gender
		pScanner.next();
		pScanner.next();
		//draw the 13 columns
		for(int i = 0; i < 13; i++) {
			int x = i * colWidth;
			g.drawString("" + year, x, 545);
			year += 10;
			int rank = pScanner.nextInt();
			if(rank == 0) rank = 1000;
			int yTop = 30 + rank/2;
			int yBottom = 530;
			if(rank == 1000) rank = 0;
			//draw the column
			g.setColor(new Color(220, 250, 220));
			g.fillRect(x, yTop, 30, yBottom-yTop);
			//draw the column outline
			g.setColor(Color.BLACK);
			g.drawRect(x, yTop, 30, yBottom-yTop);
			g.drawString("" + rank, x, yTop);
		}
		pScanner.close();
	}
}