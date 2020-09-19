package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cardList;
	
	public Hand() {
		
		cardList = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		
		cardList.add(card);
	}	
	
	public void newHand() {
		
		cardList = new ArrayList<>();
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [cardsInHand=" + cardList + "]";
	}
	
	
}
