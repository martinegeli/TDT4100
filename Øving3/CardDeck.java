package encapsulation;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CardDeck {
	
	
	//List<String> kortstokk = new ArrayList<String>();
	//public String[] kortstokk;
	
	private ArrayList<Card> cards;
	
	public static final char[] suits = {'S', 'H', 'D', 'C'};
	
	public CardDeck(int n){
		if (n > 13 || n < 1) {
			throw new IllegalArgumentException("Ugyldig antall");
		} 
		/*for (int i = 0; i < suits.length; i++) {
			for ( int j = 0; j < n; j++) {
				Card card = new Card(suits[i], (j+1));
				kortstokk.add(card.toString());
			}
		}*/
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
		/*if (!(kortstokk.size() == 0)) {
			return kortstokk.size();
		} else{
			return 0;
		}*/
		return cards.size();	
	}
	
	public Card getCard(int n) {
		/*if (!(kortstokk.size() == 0)) {
			if (n < 0 || n > kortstokk.size()) {
				throw new IllegalArgumentException("Må være i kortstokken");
			} else {
				return kortstokk.get(n);
			}
		} else throw new IllegalArgumentException("Må være i kortstokken");
		*/
		if (n < 0 || n > cards.size()) {
			throw new IllegalArgumentException("Må være i kortstokken");
		} else return cards.get(n);
	}
	
	public void shufflePerfectly() {
		/*if (!(kortstokk.size() == 0)) {
			List<String> deck1 = new ArrayList<String>(kortstokk.subList(0, (kortstokk.size())/2));
			List<String> deck2 = new ArrayList<String>(kortstokk.subList((kortstokk.size()/2), kortstokk.size()));

			
			List<String> shuffle = new ArrayList<String>();
			
			for(int i = 0; i < deck1.size(); i++) {
				shuffle.add(deck1.get(i));
				shuffle.add(deck2.get(i));
			}
			kortstokk.clear();
			kortstokk.addAll(shuffle);
		}*/
		
		int halfSize = cards.size() / 2;
		for (int i = 0; i < halfSize; i++) {
			Card card = cards.remove(halfSize + i);
			cards.add(i * 2 + 1, card);
		}
	}

	
	public static void main(String[] args) {
		CardDeck cd = new CardDeck(8);
		System.out.println(cd.getCardCount());
		System.out.println(cd.getCard(8));
		System.out.println(cd.getCard(31));
		System.out.println(cd.getCard(0));
		System.out.println(cd.kortstokk);

		cd.shufflePerfectly();
		System.out.println(cd.getCard(31));
		System.out.println(cd.kortstokk);
		cd.shufflePerfectly();
		System.out.println(cd.kortstokk);


	}
	
	
}
