package com.skilldistillery.common.cards;

public class BlackjackHand extends Hand {

	private int handValue;
	
	public BlackjackHand() {
		super();
		}

	@Override
	public int getHandValue() {

		handValue = 0;
		for (Card card : cardList) {
			handValue = handValue + card.getValue();
		}
		return handValue;
	}
	
	public boolean isBlackjack() {
		
		return (handValue == 21) ? true : false;
	}
	
	public boolean isBust() {
		
		return (handValue > 21) ? true : false;
	}
	
	@Override
	public String toString() {
		StringBuilder cardString = new StringBuilder();
		for (Card card : cardList) {
			cardString.append(card.toString())
			.append("\n");
		}
		return cardString.toString();
	}
}
