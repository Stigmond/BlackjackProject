package com.skilldistillery.common.cards;

import java.util.Scanner;

public class BlackjackTable {

	private Player player1;
	private Dealer dealer;
	private Deck deck1;
	private Scanner input;
    private int shoeSize;
    
	public BlackjackTable(int shoeSize) {
		this.shoeSize = shoeSize;
		player1 = new Player();
		dealer = new Dealer();
		deck1 = new BlackjackDeck(this.shoeSize);
		deck1.shuffleDeck();
		deck1.shuffleDeck();
		deck1.shuffleDeck();
		input = new Scanner(System.in);
	}
	
	public void playBlackjack() {

		System.out.println("\n\nWelcome to Nero's Palace! Please take a seat!\n");
		
		int shuffleSize = (int)(deck1.checkDeckSize() * .40);
		boolean keepPlaying = false;

		do {
			if (deck1.checkDeckSize() <= shuffleSize) {
				System.out.println("\nThe shoe is getting small, so it is reloaded...");
				deck1 = new BlackjackDeck(this.shoeSize);
				System.out.println("\nThe cards are shuffled...");
				deck1.shuffleDeck();
				deck1.shuffleDeck();
				deck1.shuffleDeck();
			}

			dealHands();
			if (checkForBlackjack()) {

			} else {
				playHands();
				findWinner();
			}
			keepPlaying = playAgain(input);

		} while (keepPlaying);

		input.close();
	}

	public void showHands() {
		System.out.println("\n\nDealer is showing:\n-------------- \n" + dealer.hand.cardList.get(0));
		System.out.println("\n\nPlayer is showing:\n-------------- \n" + player1.hand.toString());
	}

	public void dealHands() {

		dealer.hand.newHand();
		player1.hand.newHand();
		System.out.println("\nDealer draws their first card face up from the shoe...");
		dealer.hand.addCard(deck1.dealCard());
		System.out.println("Player is dealt their first card face up from the shoe...");
		player1.hand.addCard(deck1.dealCard());
		System.out.println("Dealer draws their second card face down from the shoe...");
		dealer.hand.addCard(deck1.dealCard());
		System.out.println("Player is dealt their second card face up from the shoe...");
		player1.hand.addCard(deck1.dealCard());
	}

	public boolean checkForBlackjack() {

		player1.hand.getHandValue();
		dealer.hand.getHandValue();

		if (((BlackjackHand) player1.hand).isBlackjack() && ((BlackjackHand) dealer.hand).isBlackjack()) {
			System.out.println("Dealer flips their other card...");
			System.out.println("\nDealer is showing:\n-------------- \n" + dealer.hand.toString());
			System.out.println("\n\nPlayer is showing:\n-------------- \n" + player1.hand.toString());
			System.out.println("Both players have Blackjack! It's a draw!");
			return true;
		} else if (((BlackjackHand) player1.hand).isBlackjack()) {
			System.out.println("Dealer flips their other card...");
			System.out.println("\nDealer is showing:\n-------------- \n" + dealer.hand.toString());
			System.out.println("\n\nPlayer is showing:\n-------------- \n" + player1.hand.toString());
			System.out.println("Player has Blackjack!  Player wins!");
			return true;
		} else if (((BlackjackHand) dealer.hand).isBlackjack()) {
			System.out.println("Dealer flips their other card...");
			System.out.println("\nDealer is showing:\n-------------- \n" + dealer.hand.toString());
			System.out.println("\n\nPlayer is showing:\n-------------- \n" + player1.hand.toString());
			System.out.println("Dealer has Blackjack!  Dealer wins!");
			return true;
		}
		return false;
	}

	public void playHands() {

		boolean playerOneTurn = true;

		while (playerOneTurn) {
			showHands();
			playerOneTurn = player1.takeTurn(input, deck1);
		}

		if (player1.hand.getHandValue() <= 21) {
			dealer.takeTurn(deck1);
			System.out.println("Dealer's Total is " + dealer.hand.getHandValue());
		}

	}

	public void findWinner() {
		if (player1.hand.getHandValue() > 21) {

		} else if (dealer.hand.getHandValue() > 21) {
			System.out.println("\nDealer Busts! Player Wins!");
		} else if (dealer.hand.getHandValue() <= 21) {
			if (player1.hand.getHandValue() > dealer.hand.getHandValue()) {
				System.out.println("\nCongratulations! Player Wins!");
			} else if (player1.hand.getHandValue() < dealer.hand.getHandValue()) {
				System.out.println("\nSorry, Dealer Wins...");
			} else {
				System.out.println("\nIt's a Push!");
			}
		}
	}

	public boolean playAgain(Scanner input) {
		boolean keepPlaying = false;
		boolean rightAnswer = false;
		do {
			System.out.print("\nWould you like to play again (Y/N)? ");
			String playAgain = input.next();
			switch (playAgain.toLowerCase()) {
			case "y":
			case "yes":
				keepPlaying = true;
				rightAnswer = true;
				break;
			case "n":
			case "no":
				System.out.println("\nGoodbye! Thanks for playing!");
				keepPlaying = false;
				rightAnswer = true;
				break;
			default:
				System.out.println("Please enter (Y)es or (N)o.");
				break;
			}
		} while (!rightAnswer);
		return keepPlaying;
	}

}
