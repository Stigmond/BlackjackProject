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
		
		dealer.hand.newHand();
		player1.hand.newHand();
		boolean playerOneTurn = true;
		boolean DealerTurn = false;
		dealHands();
		while (playerOneTurn) {
			showHands();
			playerOneTurn = player1.takeTurn(input, deck1);
			System.out.println(playerOneTurn);
		} 
	}
	
	public void showHands() {
		System.out.println("\nDealer is showing:\n -------------- \n" + dealer.hand.cardList.get(0));
		System.out.println("\n\nPlayer is showing:\n -------------- \n" + player1.hand.toString());
	}
	
	public void dealHands() {
		
		System.out.print("The deck is shuffled...");
		deck1.shuffleDeck();
		System.out.println("Dealer draws their first card...");
		dealer.hand.addCard(deck1.dealCard());
		System.out.println("Player is dealt their first card...");
		player1.hand.addCard(deck1.dealCard());
		System.out.println("Dealer draws their second card face down...");
		System.out.println("Player is dealt their second card...");
		player1.hand.addCard(deck1.dealCard());
		
	}
}
