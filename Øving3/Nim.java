package encapsulation;

public class Nim {
	
	private int pile1, pile2, pile3;
	
	public Nim(int pileSize) {
		pile1 = pile2 = pile3 = pileSize;
	}
	
	public Nim() {
		pile1 = pile2 = pile3 = 10;
	}
	
	
	public void removePieces(int number, int targetPile) {
		if (!(isValidMove(number, targetPile))) {
			throw new IllegalStateException("Ugyldig trekk");
		} else {
			if (targetPile == 0) {
				this.pile1 -= number;
			}
			if (targetPile == 1) {
				this.pile2 -= number;
			}
			if (targetPile == 2) {
				this.pile3 -= number;
			}
		}
	}
	
	public boolean isValidMove(int number, int targetPile) {
		if (targetPile < 0 || targetPile > 2) {
			return false;
		}
		if (targetPile == 0) {
			if (pile1 < number) {
				return false;
			}
		}
		if (targetPile == 1) {
			if (pile2 < number){
				return false;
			}
		}
		if (targetPile == 2) {
			if (pile3 < number) {
				return false;
			}
		}
		if (isGameOver()) {
			return false;
		}
		return true;
	}
	
	public boolean isGameOver() {
		if (pile1 == 0 || pile2 == 0 | pile3 == 0) {
			return true;
		}
		return false;
	}
	
	int getPile(int targetPile) {
		if (targetPile == 0) {
			return pile1;
		} else if (targetPile == 1) {
			return pile2;
		} else {
			return pile3;
		}
	}
	
	public String toString() {
		return "Pil 1: " + pile1 + ", Pil 2: " + pile2 + ", Pil 3: " + pile3;
	}
	
	public static void main(String[] args) {
		Nim game = new Nim(8);
		System.out.println(game.toString());
		game.removePieces(7, 2);
		System.out.println(game.toString());
		game.removePieces(1, 2);
		System.out.println(game.toString());
		System.out.println(game.isGameOver());

	}
	
	
	
	
	
	
	
}
