package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
	
	private CardContainer cardContainer;
	
	int pos;
	
	public CardContainerIterator(CardContainer cardContainer) {
		this.cardContainer = cardContainer;
		this.pos = 0;
	}

	@Override
	public boolean hasNext() {
		return pos < cardContainer.getCardCount();
	}

	@Override
	public Card next() {
		Card card = cardContainer.getCard(pos);
		pos += 1;
		return card;
	}
	
}
