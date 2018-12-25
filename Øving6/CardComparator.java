package interfaces;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
	
	
	
	private String suits = "SHDC";
	private char trumf;
	private boolean isAceHighest;
	
	
	public CardComparator(boolean bool, char ch) {
		super();
		this.isAceHighest = bool;
		this.trumf = ch;	
	}
	
	@Override
	public int compare(Card card1, Card card2) {
		int suit1 = suits.indexOf(card1.getSuit());
		int suit2 = suits.indexOf(card2.getSuit());
		if (card1.getSuit() == trumf) {
			suit1 = suits.length();
		}
		if (card2.getSuit() == trumf) {
			suit2 = suits.length();
		}
		int diff = suit1 - suit2;
		if (diff == 0) {
			int digit1 = card1.getFace();
			int digit2 = card2.getFace();
			if (isAceHighest) {
				if (digit1 == 1) {
					digit1 = 14;
				}
				if (digit2 == 1) {
					digit2 = 14;
				}
			}
			diff = digit1 - digit2;
		}
		return diff;
	}
}
