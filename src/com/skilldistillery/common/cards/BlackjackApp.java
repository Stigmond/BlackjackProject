package com.skilldistillery.common.cards;

public class BlackjackApp {


	public static void main(String[] args) {
		
		BlackjackApp app = new BlackjackApp();
		app.go();
	}
	
	public void go() {

		BlackjackTable table1 = new BlackjackTable();
		table1.playBlackjack();
		
		//Temporary code to test proper instantiation and calling of methods.
		
//		Deck deck1 = new Deck();
//		deck1.shuffleDeck();
//		deck1.shuffleDeck();
//		BlackjackHand hand1 = new BlackjackHand();
//		System.out.println(deck1.checkDeckSize());
//		hand1.addCard(deck1.dealCard());
//		hand1.addCard(deck1.dealCard());
//		System.out.println(deck1.checkDeckSize());
//		System.out.println(hand1.getHandValue());
//		System.out.println(hand1.isBlackjack());
//		System.out.println(hand1);
//		hand1.addCard(deck1.dealCard());
//		System.out.println(hand1.getHandValue());		
//		System.out.println(hand1.isBust());
//		System.out.println(hand1);
		
	}
}


