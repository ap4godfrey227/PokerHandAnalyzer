import java.util.*;
public class MenuDisplay {

	private static Hand hand = new Hand();
	
	public static void createHand() { // The initial hand creating process as prompted by the computer

		Scanner scan = new Scanner(System.in);
		System.out.println("What does your hand look like?");
		System.out.println("Please enter the value of the card and then the first letter of the suit. Then press enter. Repeat until you have entered your hand");
		System.out.println("Ex: 10s for 10 of spades or kh for the king of hearts");
		for (int i = 0; i < 5; i++) {
			hand.add(scan.nextLine().toUpperCase());
		}
		suitFailsafe(); // Calling failsafe now to avoid issues later on 
		valueFailsafe();
	}
	
	public static void rearrangeHand() { // implements the sorting algorithm on the cards to help other methods run correctly
		System.out.println("The hand you entered looks like");
		System.out.println();
		for(int i = 0; i < 5; i++) {
			System.out.print(hand.get(i) + " ");
		}
		System.out.println();
		System.out.println();
		Hand.sort(hand);
		System.out.println("Your hand sorted looks like");
		System.out.println();
		for(int i = 0; i < 5; i++) {
			System.out.print(hand.get(i) + " ");
		}
	}
	
	public static void showPlays() { // Shows the plays that the card has
		String bestPlay = "High Card"; // Will be updated as it goes along the hierarchy of the plays. Displayed at the end
		System.out.println(); // Lines to make the display easier to read
		System.out.println();
		System.out.println();
		System.out.println("The plays you can make are:"); // All code below checks if the card has the play before it prints that it does
		System.out.println("High Card: " +  Plays.highCard(hand));
		if(Plays.onePair(hand).equals("") == false) {
			System.out.println("Pair: " +  Plays.onePair(hand) + "'s");
			bestPlay = "Pair: " +  Plays.onePair(hand) + "'s";
		}
		if(Plays.twoPair(hand).equals("") == false) {
			System.out.println("Pair: " +  Plays.twoPair(hand) + "'s");
			bestPlay = "Pair: " +  Plays.twoPair(hand) + "'s";
		}
		if(Plays.twoPair(hand).equals("") == false) {
			System.out.println("Two Pair: " +  Plays.onePair(hand) + "'s and " + Plays.twoPair(hand) + "'s");
			bestPlay = "Two Pair: " +  Plays.onePair(hand) + "'s and " + Plays.twoPair(hand) + "'s";
		}
		if(Plays.threeOfAKind(hand).equals("") == false) {
			System.out.println("Three of a Kind: " +  Plays.threeOfAKind(hand) + "'s");
			bestPlay = "Three of a Kind: " +  Plays.threeOfAKind(hand) + "'s";
		}
		if(Plays.straight(hand).equals("") == false) {
			System.out.println(Plays.straight(hand));
			bestPlay = Plays.straight(hand);
		}
		if(Plays.flush(hand).equals("") == false) {
			System.out.println(Plays.flush(hand));
			bestPlay = Plays.flush(hand);
		}
		if(Plays.fullHouse(hand).equals("") == false) {
			System.out.println(Plays.fullHouse(hand));
			bestPlay = Plays.fullHouse(hand);
		}
		if(Plays.fourOfAKind(hand).equals("") == false) {
			System.out.println("Four of a Kind: " +  Plays.fourOfAKind(hand) + "'s");
			bestPlay = "Four of a Kind: " +  Plays.fourOfAKind(hand) + "'s";
		}
		if(Plays.straightFlush(hand).equals("") == false) {
			System.out.println(Plays.straightFlush(hand));
			bestPlay = Plays.straightFlush(hand);
		}
		if(Plays.royalFlush(hand).equals("") == false) {
			System.out.println(Plays.royalFlush(hand));
			Plays.royalFlush(hand);
		}
		System.out.println();
		System.out.println("The best play would be the " + bestPlay);
	}

	public static void suitFailsafe() { // Ensures that the user does not put in an invalid suit
		int suitCheck = 0;
		for (int i = 0; i < 5; i++) { // Checks if the inputs were valid suits
			if(hand.getSuit(hand, i).equals("S") || hand.getSuit(hand, i).equals("D") || hand.getSuit(hand, i).equals("H") || hand.getSuit(hand, i).equals("C")) {
				suitCheck++;
			}
		}
		if(suitCheck == 5) { // only ends the failsafe if each card passed the test
			return;
		}
		
		
		
		System.out.println("There was an error with the suits in your card inputs. Please refer to the instructions and try again."); 
		System.out.println();
		System.out.println();
		for (int i = 4; i >= 0; i--) {
			hand.remove(i);
		}
		createHand(); // Restarts the hand making process if the failsafe is triggered
	}
	
	public static void valueFailsafe() { // Ensures that the user does not put in an invalid card value
		int valueCheck = 0;
		for (int i = 0; i < 5; i++) { // Checks if the inputs were valid values
			if(hand.get(i).length() == 2) {
				if(hand.getValue(hand, i) > 1) { // prevents inputs of 1 or 0
					valueCheck++;
				}
			}
			if(hand.getValue(hand, i) == 10) {
				valueCheck++;
			}
		}
		if(valueCheck == 5) { // indicates if it passed the test
			return;
		}
		
		System.out.println("There was an error with the values in your card inputs. Please refer to the instructions and try again.");
		System.out.println();
		System.out.println();
		for (int i = 4; i >= 0; i--) {
			hand.remove(i);
		}
		createHand(); // Restarts the hand making process if the failsafe is triggered
	}
}
