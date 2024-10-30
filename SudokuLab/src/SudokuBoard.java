import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gameBoards.SudokuGUI;

public class SudokuBoard {
	private SudokuGUI gui;
	private int[][] board;
	public SudokuBoard() {
		this.gui = new SudokuGUI();
		this.board = new int[9][9];
	}
	public void loadPuzzle(String file) throws FileNotFoundException {
		File f = new File(file);
		Scanner s = new Scanner(f);
		int row = 0;
		while(s.hasNextLine()) {
			String line = s.nextLine();
			if(line.length() > 0) {
				int col = 0;
				for(int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if(c >= '0' && c <= '9') {
						board[row][col] = (int) (c - '0');
						gui.draw(board);
					}
					if(c != ' ') {
						col++;
					}
				}
				row++;
			}
		}
	}
	public void solvePuzzle() {
		
	}
	public void drawPuzzle() {
		
	}
}
