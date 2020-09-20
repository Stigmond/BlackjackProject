package com.skilldistillery.common.cards;

import java.util.Scanner;

public class BlackjackApp {

	public static void main(String[] args) {

		BlackjackApp app = new BlackjackApp();
		app.go();
	}

	public void go() {

		Scanner kb = new Scanner(System.in);
		boolean invalidEntry = true;
		int shoeSize = 1;

		do {
			System.out.print("How many decks of cards would you like in your shoe? (1-3)");
			try {
				shoeSize = kb.nextInt();
				if (shoeSize < 1 || shoeSize > 3) {
					System.out.println("Please choose between 1 - 3");
					invalidEntry = true;
				} else {
					invalidEntry = false;
				}
			} catch (Exception e) {
				System.out.println("Invalid entry.");
				invalidEntry = true;
				kb.nextLine();
			}

		} while (invalidEntry);

		BlackjackTable table1 = new BlackjackTable(shoeSize);
		table1.playBlackjack();
		kb.close();

	}
}
