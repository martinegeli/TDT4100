package interfaces;


public class Card implements Comparable {
	public char valør;
	public int digit;
	
	public static final String suits = "SHDC";
	
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

	@Override
	public int compareTo(Card card) {
		int diff = suits.indexOf(card.getSuit()) - suits.indexOf(this.getSuit());
		if (diff == 0) {
			diff = this.getFace() - card.getFace();
		}
		return diff;
		
	}
}
