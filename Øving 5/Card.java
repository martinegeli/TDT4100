package objectstructures;

public class Card {

	public char valør;
	public int digit;
	
	public static final char[] suits = {'S', 'H', 'D', 'C'};
	public static final int siffer[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	
	
	public Card(char suit, int number) {
		if (number < 1 || number > 13) {
			throw new IllegalArgumentException("Må være gyldig siffer");
		} else {
			this.valør = suit;
			this.digit = number;
		}
		if (!(suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C')) {
			throw new IllegalArgumentException("Må være gyldig valør");
		}
	}
	
	public char getSuit() {
		return valør;
	}
	
	public int getFace() {
		return digit;
	}
	
	public String toString() {
		return Character.toString(valør) + Integer.toString(digit);
	}
	
	public static void main(String[] args) {
		Card card = new Card('H', 4);
		System.out.println(card.getSuit());
		System.out.println(card.getFace());
		System.out.println(card.toString());
		
		Card card2 = new Card('D', 8);
		System.out.println(card2.toString());
		
		Card card3 = new Card('C', 12);
		System.out.println(card3.getFace());
		System.out.println(card3.toString());

		

	}
}
