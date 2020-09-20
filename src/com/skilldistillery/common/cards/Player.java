package com.skilldistillery.common.cards;

import java.util.Scanner;

public class Player {

	Hand hand;

	Player() {

		hand = new BlackjackHand();
	}

	public boolean takeTurn(Scanner input, Deck deck) {
		boolean notDone = true;
		System.out.println("\nPlayer's total is " + hand.getHandValue());
		if (hand.getHandValue() > 21) {
			System.out.println("Player Busts! Game Over.");
			notDone = false;
			return notDone;
		} else {

			System.out.print("\nWould Player like to (H)it or (S)tay? ");
			String playerChoice = input.next();
			switch (playerChoice.toLowerCase()) {
			case "h":
			case "hit":
				System.out.println("Player hits.");
				hand.addCard(deck.dealCard());
				notDone = true;
				break;
			case "s":
			case "stay":
				System.out.println("\nPlayer stays on " + hand.getHandValue());
				notDone = false;
				break;
			default:
				System.out.println("Please choose (H)it or (S)tay");
				break;
			}
		}
		return notDone;
	}
}
