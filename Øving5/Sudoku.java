package objectstructures;

import java.util.ArrayList;
import java.util.Scanner;


public class Sudoku {
	
	Scanner in = new Scanner(System.in);
	
	private int nextRow;
	private int nextCol;
	
	private char nextValue;
	
	private ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();
	
	// Konstruktør med tomt brett
	public Sudoku() {
		for (int i = 0; i < 9; i++) {
			board.add(new ArrayList<Cell>());
			for (int j = 0; j < 9; j++) {
				board.get(i).add(new Cell());
			}
		}
	}
	
	//Konstruktør med ferdiglagd brett
	public Sudoku(String brett) {
		int counter = 0;
		for (int i = 0; i < 9; i++) {
			board.add(new ArrayList<Cell>());
			for (int j = 0; j < 9; j++) {
				char currentChar = brett.charAt(counter);
				Cell cell = new Cell(currentChar);
				if (currentChar != '.') {
					cell.setUnchangeable();
					board.get(i).add(cell);
				} else board.get(i).add(cell);
				counter++;
			}
		}
	}
	
	//Henter ut celle i rad r (fra 0) og kolonne c
	private Cell getCell(int r, int c) {
		return board.get(r).get(c);
	}
	
	// Setter verdi på cellen hvis den er changeable og valid
	private void setCell(int r, int c, char value) {
		if (getCell(r, c).isChangeable()) getCell(r,c).setValue(value);
	}
	
	//Setter cellen usikker. Senere om denne er true printes den med stjerne etter
	private void setUncertain(int r, int c, char value) {
		setCell(r, c, value); getCell(r,c).setCertainty(true);
	}
	
	//Metode for å fjerne et element
	private void removeCell(int r, int c) {
		if (getCell(r,c).isChangeable()) setCell(r,c, '.'); 
	}
	
	
	//Bygger metode for at sudokuspillet skal fungere. Om det er konflikt skal setUncertain bli true
	//Sjekker rader
	private boolean checkRows() {
		ArrayList<Character> chars = new ArrayList<Character>();
		for (int i = 0; i < 9; i++) {
			chars.clear();
			for (int j = 0; j < 9; j++) {
				if (chars.contains(getCell(i,j).getValue())) {
					return false;
				}
				chars.add(getCell(i,j).getValue());
			}
		}
		return true;
	}
	
	
	//Sjekker kolonner
	private boolean checkColons() {
		ArrayList<Character> chars = new ArrayList<Character>();
		for (int j = 0; j < 9; j++) {
			chars.clear();
			for (int i = 0; i < 9; i++) {
				if (chars.contains(getCell(i,j).getValue())) {
					return false;
				}
				chars.add(getCell(i,j).getValue());
			}
		}
		return true;
	}
	
	
	//Sjekker punkter
	private boolean checkFull() {
		for (int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if (getCell(i,j).getValue() == '.') return false;		
			}
		}
		return true;
	}
	
	
	//Sjekker om spiller har vunnet
	private boolean hasWon() {
		if (checkRows() && checkColons() && checkFull()) return true;
		return false;
	}
	
	//Metode for stringmodifier
	public String stringModifier(int r, int c) {
		String out = "";
		Cell cell = getCell(r,c);
		if (!cell.isChangeable()) {
			out += "(" + cell + ")";
			return out;
		}
		if (cell.isUncertain()) {
			out += " " + cell + "*";
			return out;
		}
		out += " " + cell + " ";
		return out;
	}
	
	//Metode for å printe ut toString
	public String toString() {
		String out = "";
		out += "+--------------+--------------+--------------+\n";
		for (int r = 0; r < 9; r++) {
			if (r == 3 || r == 6) {
				out += "+--------------+--------------+--------------+\n";
				out += "|  ";
			}
			else {
				out += "|  ";
			}
			for (int c = 0; c < 9; c++) {
				if (c == 3 || c == 6) {
					out += "|  ";
				}
				out += stringModifier(r,c) + " ";
			}
			out += "|\n";
		}
		out += "+--------------+--------------+--------------+\n";
		return out;
	}
	
	//Tar input fra bruker
	public void getInput(String in) {
		if (in.length() == 2) {
			this.nextRow = Character.getNumericValue(in.charAt(0));
			this.nextCol = Character.getNumericValue(in.charAt(1));
			removeCell(nextRow, nextCol);
		}
		if (in.length() == 3) {
			this.nextRow = Character.getNumericValue(in.charAt(0));
			this.nextCol = Character.getNumericValue(in.charAt(1));
			this.nextValue = in.charAt(2);
			setCell(this.nextRow, this.nextCol, this.nextValue);
		}
	}
	
	//Metode for å spille
	public void play() {
		System.out.println();
		
		while (!hasWon()) {
			String input = in.nextLine();
			getInput(input);
			
		}
	}
	
	public static void main(String[] args) {
		Sudoku board = new Sudoku(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");
		System.out.println(board.toString());
	}
	
}
