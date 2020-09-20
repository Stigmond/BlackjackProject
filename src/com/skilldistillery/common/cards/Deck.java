package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	protected List<Card> playingCardsDeck;

	public Deck() {
		playingCardsDeck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				playingCardsDeck.add(new Card(suit, rank));
			}

		}
	}

	public int checkDeckSize() {

		return playingCardsDeck.size();

	}

	public Card dealCard() {

		return playingCardsDeck.remove(0);

	}

	public void shuffleDeck() {

		Collections.shuffle(playingCardsDeck);

	}
}
