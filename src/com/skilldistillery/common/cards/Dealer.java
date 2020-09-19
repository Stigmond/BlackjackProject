package com.skilldistillery.common.cards;

public class Dealer extends Player{

	Hand hand;
	
	Dealer() {
	
		hand = new BlackjackHand();
	}
	
	public boolean takeTurn(Deck deck) {
		boolean notDone = true;
		System.out.println("\nDealer flips his other card...");
		System.out.println("\nDealer is showing:\n -------------- \n" + hand.cardList.get(0) + "\n" + hand.cardList.get(1));
		System.out.println("Dealer's total is " + hand.getHandValue());
		
		return notDone;
	}


}
