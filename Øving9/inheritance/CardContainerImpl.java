package inheritance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import interfaces.Card;
import interfaces.CardContainer;

public class CardContainerImpl implements CardContainer {

	protected List<Card> cards = new ArrayList<Card>();
	
	protected CardContainerImpl() {
		
	}
	
	
	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}

	@Override
	public int getCardCount() {
		return cards.size();
	}

	@Override
	public Card getCard(int n) throws IllegalArgumentException {
		if (getCardCount() >= n) throw new IllegalArgumentException("Ikke nok kort");
		return cards.get(n);
	}
	
	
	
}
