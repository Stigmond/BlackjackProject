package com.skilldistillery.common.cards;

import java.util.Scanner;

public class BlackjackTable {

	private Player player1;
	private Dealer dealer;
	private Deck deck1;
	private Scanner input;

	BlackjackTable() {

		player1 = new Player();
		dealer = new Dealer();
		deck1 = new Deck();
		input = new Scanner(System.in);
	}

	public void playBlackjack() {

		boolean playAgain = false;
		
		do {
		
			
			
			
			dealHands();
			boolean playerOneTurn = true;
			boolean dealerTurn = false;
			while (playerOneTurn) {
				showHands();
				playerOneTurn = player1.takeTurn(input, deck1);
			}
			dealer.takeTurn(deck1);
			System.out.println("Dealer's Total is " + dealer.hand.getHandValue());
		
		
		
		} while (playAgain);
		
		
		
		
		
		
		input.close();
	}

	public void showHands() {
		System.out.println("\nDealer is showing:\n -------------- \n" + dealer.hand.cardList.get(0));
		System.out.println("\n\nPlayer is showing:\n -------------- \n" + player1.hand.toString());
	}

	public void dealHands() {

		dealer.hand.newHand();
		player1.hand.newHand();
		System.out.println("The deck is shuffled...");
		deck1.shuffleDeck();
		System.out.println("Dealer draws their first card face up...");
		dealer.hand.addCard(deck1.dealCard());
		System.out.println("Player is dealt their first card face up...");
		player1.hand.addCard(deck1.dealCard());
		System.out.println("Dealer draws their second card face down...");
		dealer.hand.addCard(deck1.dealCard());
		System.out.println("Player is dealt their second card face up...");
		player1.hand.addCard(deck1.dealCard());
	}

//	public void checkForBlackjack() {
//		if (((BlackjackHand)player1.hand).isBlackjack() && ((BlackjackHand)dealer.hand).isBlackjack()){
//		
//		}

//}

}
