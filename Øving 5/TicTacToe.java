package objectstructures;



public class TicTacToe {
	
	String board;
	
	public TicTacToe() {
		String newBoard = "         ";
		this.board = newBoard;
	}
	
	public char getCell(int x, int y) {
		if (x > 2 || x < 0 || y > 2 || y < 0) {
			throw new IllegalArgumentException("Må være innenfor brettet");
		}
		String str = board.substring(x, x*3);
		return str.charAt(y);
	}
	
	public boolean setCell(char c, int x, int y) {
		String str = board.substring(x*3, (x+1)*3);
		char posisjon = str.charAt(y);
		if (posisjon == ' ') {
			char[] myBoard = board.toCharArray();
			myBoard[x*3+y] = c;
			this.board = String.valueOf(myBoard);
			return true;
		}
		else return false;
	}
	
	public boolean isOccupied(int x, int y) {
		if (!(board.charAt(x*3+y) == ' ')){
			return true;
		}
		return false;
	}
	
	public char getCurrentPlayer() {
		int countX = 0;
		int countO = 0;
		for (int i = 0; i < board.length(); i++) {
			if (board.charAt(i) == 'X' ) {
				countX++;
			}
			if (board.charAt(i) == 'O' ) {
				countO++;
			}
		}
		if (countX > countO) {
			return 'O';
		}
		return 'X';
	}
	
	public char getNextPlayer() {
		int countX = 0;
		int countO = 0;
		for (int i = 0; i < board.length(); i++) {
			if (board.charAt(i) == 'X' ) {
				countX++;
			}
			if (board.charAt(i) == 'O' ) {
				countO++;
			}
		}
		if (countX > countO) {
			return 'X';
		}
		return 'O';
	}
	
	public String toString() {
		String print = board.charAt(0) + " | " + board.charAt(1) + " | " + board.charAt(2) + "\n----------" + '\n' + board.charAt(3) + " | " + board.charAt(4) + " | " + board.charAt(5) + "\n----------" + '\n' + board.charAt(6) + " | " + board.charAt(7) + " | " + board.charAt(8);
		return print;
	}
	
	public String toString2() {
		return board;
	}
	
	
	public void play(int x, int y) {
		char player = getCurrentPlayer();
		if (!isOccupied(x, y) && !isFinished()) {
			setCell(player, x, y);
		}
	}
	
	public boolean isWinner(char c) {
		int counter = 0;
		int counter2 = 0;
		int counter3 = 0;
		
		//Sjekker alle radene
		for (int i = 0; i < 3; i++) {
			if (board.charAt(i) == c) {
				counter++;
			}
			if (counter == 3) {
				counter = 0;
				return true;
			}
		}
		for (int i = 3; i < 6; i++) {
			if (board.charAt(i) == c) {
				counter2++;
			}
			if (counter2 == 3) {
				counter2 = 0;
				return true;
			}
		}
		for (int i = 6; i < 9; i++) {
			if (board.charAt(i) == c) {
				counter3++;
			}
			if (counter3 == 3) {
				counter3 = 0;
				return true;
			}
		}
		
		//Sjekker alle kolonnene
		if (board.charAt(0) == c && board.charAt(3) == c && board.charAt(6) == c) {
			return true;
		}
		if (board.charAt(1) == c && board.charAt(4) == c && board.charAt(7) == c) {
			return true;
		}
		if (board.charAt(2) == c && board.charAt(5) == c && board.charAt(8) == c) {
			return true;
		}
		
		//Sjekker diagonalt
		
		if (board.charAt(0) == c && board.charAt(4) == c && board.charAt(8) == c) {
			return true;
		}
		if (board.charAt(2) == c && board.charAt(4) == c && board.charAt(6) == c) {
			return true;
		}
		
		//Returnerer false om ingen utløser true
		return false;
	}
	
	public boolean hasWinner() {
		if (isWinner('X') || isWinner('O')) {
			return true;
		}
		return false;
	}
	
	public boolean isFinished() {
		int counter = 0;
		for (int i = 0; i < board.length(); i++) {
			if (board.charAt(i) == ' ') {
				counter++;
			}
		}
		if (counter == 0 || hasWinner()) {
				return true;
		}
		return false;
	}
	
	/*public void getInput(String in) {
		Scanner input = new Scanner(System.in);
		
	}*/
	
	
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		ttt.setCell('X', 2, 1);
		System.out.println(ttt.toString());


	}
	
}
