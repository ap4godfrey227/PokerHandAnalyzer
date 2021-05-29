
public class Plays extends Hand {

	public static String highCard(Hand hand) { // When sorted, the last card will always be the high card
		return hand.get(4);
	}
	
	public static String onePair(Hand hand) { // Checks if the hand has a pair
		String pair = "";
		for (int i = 0; i<4;i++) {
			if(hand.getValue(hand, i) == hand.getValue(hand, i+1)) {
				pair += hand.getCard(hand, i);
				if (pair.length() == 1) { // ends the program after one pair is found
					return pair;
				}
			}
		}
		return pair;
	}

	public static String twoPair(Hand hand) {// Checks if the hand has a second pair
		String pair = onePair(hand);
		String pair2 = "";
		if(pair.equals("")) { //If there is no single pair, there cannot be a two pair
			return "";
		}
		for (int i = 0; i<4;i++) {
			if(hand.getValue(hand, i) == hand.getValue(hand, i+1) && hand.getCard(hand, i).equals(pair) == false) { // Checks if the second pair is not equal to the first pair
				pair2 += hand.getCard(hand, i);
				if (pair2.length() == 1) { // ends the program after one pair is found
					return pair2;
				}
			}
		}
		return pair2;
	}
	
	public static String threeOfAKind(Hand hand) { // Checks if the hand has a 3 of a kind
		String trip = "";
		if(onePair(hand).equals("")) { //If there is no single pair, there cannot be a 3 of a kind
			return "";
		}
		for (int i = 0; i<3;i++) {
			if(hand.getValue(hand, i) == hand.getValue(hand, i+1) && hand.getValue(hand, i) == hand.getValue(hand, i+2)) { // Checks if the current card value is equivalent to the next card and the one after
				trip += hand.getCard(hand, i);
				if (trip.length() == 1) { // ends the program after one trip is found
					return trip;
				}
			}
		}
		return trip;
	}
	
	public static String straight(Hand hand) { // Checks if the hand has a straight
		String straight = "";
		if(onePair(hand).equals("") == false) { //If there is a pair, there cannot be a straight
			return "";
		}
		for (int i = 0; i < 4; i++) {
			if(hand.getValue(hand, i+1) - hand.getValue(hand, i) == 1) { // If numbers are in sequential order, the difference between neighboring values should be 1
				straight = "Straight";
			}
			else {
				straight = "";
				return straight;
			}
		}
		return straight;
	}
	
	public static String flush(Hand hand) { // Checks if the hand has a flush
		String flush = "";
		for (int i = 0; i < 4; i++) {
			if(hand.getSuit(hand, i).equals(hand.getSuit(hand, i+1))) { // if each card's suits are the same, its a flush
				flush = "Flush";
			}
			else {
				flush = "";
				return flush;
			}
		}
		return flush;
	}
	
	public static String fullHouse(Hand hand) { // Checks if the hand has a full house
		if (onePair(hand).equals("") == false && threeOfAKind(hand).equals("") == false) { // A full house needs both a pair and a three of a kind to happen
			if(onePair(hand).equals(threeOfAKind(hand)) == false) {
				return "Full House";
			}
			if(twoPair(hand).equals(threeOfAKind(hand)) == false && twoPair(hand).equals("") == false) { // This accounts for if the three of a kind has card values lower than the pair
				return "Full House";
			}
		}
		
		return "";
	}
	
	public static String fourOfAKind(Hand hand) { // Checks if the hand has a 4 of a kind
		String quad = "";
		if (threeOfAKind(hand).equals("")){ // if you don't have a three of a kind, you do not have a four of a kind
			return "";
		}
		for (int i = 0; i<2;i++) {
			if(hand.getValue(hand, i) == hand.getValue(hand, i+1) && hand.getValue(hand, i) == hand.getValue(hand, i+2) && hand.getValue(hand, i) == hand.getValue(hand, i+3)) { // Checks if the current card value is equivalent to the next card and the one after and the one after
				quad += hand.getCard(hand, i);
				if (quad.length() == 1) { // ends the program after one trip is found
					return quad;
				}
			}
		}
		return quad;
	}
	
	public static String straightFlush(Hand hand) { // Checks if the hand has a straight flush
		if (straight(hand).equals("Straight") && flush(hand).equals("Flush")) { // cannot have a straight flush without a straight and a flush
			return "Straight Flush";
		}
		else {
			return "";
		}
	}
	
	public static String royalFlush(Hand hand) { // Checks if the hand has a royal flush
		if (straightFlush(hand).equals("Straight Flush") && hand.getValue(hand, 0) == 10) { // need a straight flush starting at a 10 to have a royal flush
			return "Royal Flush";
		}
		else {
			return "";
		}
	}
}
