package com.skilldistillery.common.cards;

public class Dealer extends Player{

	Dealer() {
	
	}
	
	public void shuffle(Deck deck) {
		deck.shuffleDeck();
	}
}
