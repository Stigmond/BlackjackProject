package com.skilldistillery.common.cards;

public class Dealer extends Player{

	Hand hand;
	
	Dealer() {
	
		hand = new BlackjackHand();
	}
	
	public void takeTurn(Deck deck) {
		
		boolean notDone = true;
		System.out.println("\nDealer flips his other card...");
		System.out.println("\n\nDealer is showing:\n -------------- \n" + hand.toString());
	    do {
		if (hand.getHandValue() > 17) {
			notDone = false;
		}
		if (hand.getHandValue() < 17) {
			while (hand.getHandValue() < 17) {
				System.out.println("Dealer draws a card...");
				hand.addCard(deck.dealCard());
				System.out.println("\n\nDealer is showing:\n -------------- \n" + hand.toString());
				notDone = true;
			}
			
		}
	    } while (notDone == true);
	}

	

}
