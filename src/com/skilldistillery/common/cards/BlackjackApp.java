package com.skilldistillery.common.cards;

public class BlackjackApp {


	public static void main(String[] args) {
		
		BlackjackApp app = new BlackjackApp();
		app.go();
	}
	
	public void go() {

		BlackjackTable table1 = new BlackjackTable();
		table1.playBlackjack();
				
	}
}


