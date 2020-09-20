package com.skilldistillery.common.cards;

public class Dealer {

	Hand hand;
	
	Dealer() {
	
		hand = new BlackjackHand();
	}
	
	public void takeTurn(Deck deck) {
		
		boolean notDone = true;
		System.out.println("\nDealer flips their other card...");
		System.out.println("\n\nDealer is showing:\n-------------- \n" + hand.toString());
	    do {
		if (hand.getHandValue() >= 17) {
			notDone = false;
		}
		if (hand.getHandValue() < 17) {
			while (hand.getHandValue() < 17) {
				System.out.println("Dealer draws a card from the shoe...");
				hand.addCard(deck.dealCard());
				System.out.println("\n\nDealer is now showing:\n-------------- \n" + hand.toString());
				notDone = true;
			}
			
		}
	    } while (notDone == true);
	}

	

}
