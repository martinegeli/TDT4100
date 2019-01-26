package objectstructures;

import java.util.ArrayList;

public class CardDeck {
	
	private ArrayList<Card> cards;
	
	public static final char[] suits = {'S', 'H', 'D', 'C'};
	
	public CardDeck(int n){
		cards = new ArrayList<Card>();
		if (n > 13 || n < 1) {
			throw new IllegalArgumentException("Ugyldig antall");
		}
		for (int k = 0; k < suits.length; k++) {
			for ( int h = 0; h < n; h++) {
				Card card = new Card(suits[k], (h+1));
				cards.add(card);
			}
		}
	}
	
	@Override
	public String toString() {
		return "[Deck " + cards.toString();
	}
	
	public int getCardCount() {
		return cards.size();	
	}
	
	public Card getCard(int n) {
		if (n < 0 || n > cards.size()) {
			throw new IllegalArgumentException("Må være i kortstokken");
		} else return cards.get(n);
	}
	
	
	public void shufflePerfectly() {
		int halfSize = cards.size() / 2;
		for (int i = 0; i < halfSize; i++) {
			Card card = cards.remove(halfSize + i);
			cards.add(i * 2 + 1, card);
		}
	}
	
	public void deal(CardHand cardHand, int i) {
		/*int digit = 0;
		int oldDigit;
		
		for (int j = 0; j < i; j++) {
			for (int k = 0; k < getCardCount() -1; k++) {
				oldDigit = getCard(k).getFace();
				if (oldDigit > digit) {
					digit = oldDigit;
				}
			}
			for (int h = 0; h < getCardCount() -1; h++) {
				if (getCard(h).getFace() == digit) {
					Card card = getCard(h);
					cards.remove(card);
					cardHand.addCard(card);
					digit = 0;
					oldDigit = 0;
				}
			}
		}*/
		for (int k = 0; k < i; k++) {
			cardHand.addCard(cards.remove(getCardCount() -1));
		}
		
	}
	
}

