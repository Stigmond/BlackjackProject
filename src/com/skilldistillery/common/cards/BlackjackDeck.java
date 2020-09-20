package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackjackDeck extends Deck {

	private List<Card> shoe = new ArrayList<>();

	public BlackjackDeck(int sizeOfShoe) {

		for (int i = 0; i < sizeOfShoe; i++) {
			playingCardsDeck = new ArrayList<>(52);
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					playingCardsDeck.add(new Card(suit, rank));
					
				}
				
			}
			shoe.addAll(playingCardsDeck);
		}

	}
	
	@Override
	public int checkDeckSize() {

		return shoe.size();

	}
	
    @Override
	public Card dealCard() {

		return shoe.remove(0);

	}
    @Override
	public void shuffleDeck() {

		Collections.shuffle(shoe);

	}

	@Override
	public String toString() {
		return "BlackjackDeck [card(s) in shoe=" + shoe + "]";
	}

}
