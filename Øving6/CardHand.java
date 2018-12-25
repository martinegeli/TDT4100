package interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public class CardHand implements CardContainer {
	public ArrayList<Card> cardHand;
	
	
	public CardHand() {
		cardHand = new ArrayList<Card>();
	}
	
	
	public int getCardCount() {
		return cardHand.size();	
	}
	
	public Card getCard(int n) {
		if (n < 0 || n > cardHand.size()) {
			throw new IllegalArgumentException("Må være i kortstokken");
		} else return cardHand.get(n);
	}
	
	public void addCard(Card card) {
		this.cardHand.add(card);
	}
	
	public Card play(int n) {
		return cardHand.remove(n);
	}
	
	public Iterator<Card> iterator(){
		return cardHand.iterator();
	}
	
}
