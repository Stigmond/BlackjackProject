package com.skilldistillery.common.cards;

import java.util.Scanner;

public class Player {

	Hand hand;

	Player() {

		hand = new BlackjackHand();
	}
	
	public boolean takeTurn(Scanner input, Deck deck) {
		boolean notDone = false;
		System.out.println("Player's Total is " + hand.getHandValue());
        System.out.print("Would you like to (H)it or (S)tay? ");
        String playerChoice = input.next();
        switch (playerChoice.toLowerCase()) {
		case "h": case "hit":
			System.out.println("Player hits.");
			hand.addCard(deck.dealCard());
			notDone = true;
			break;
		case "s": case "stay":
			System.out.println("Player stays on " + hand.getHandValue());
			notDone = false;
			break;
		default:
			System.out.println("Please choose (H)it or (S)tay");
			break;
		}
        return notDone;
	}
}
