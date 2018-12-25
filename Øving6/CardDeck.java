package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;


public class CardDeck implements CardContainer, Predicate<Card> {
	
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
		for (int k = 0; k < i; k++) {
			cardHand.addCard(cards.remove(getCardCount() -1));
		}
	}
	
	public Iterator<Card> iterator(){
		return cards.iterator();
	}

	@Override
	public boolean test(Card arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean hasCard(Predicate<Card> predicate) {
		for (int i = 0; i < cards.size(); i++) {
			if (predicate.test(cards.get(i))) return true;
		} return false;
	}
	
	public int getCardCount(Predicate<Card> predicate) {
		int count = 0;
		for (int i = 0; i < cards.size(); i++) {
			if (predicate.test(cards.get(i))) count++;
		}
		return count;
	}
	
	public List<Card> getCards(Predicate<Card> predicate){
		List<Card> kort = new ArrayList<Card>();
		for (int i = 0; i < cards.size(); i++) {
			if (predicate.test(cards.get(i))) kort.add(cards.get(i));
		}
		return kort;
	}
	
	
}
