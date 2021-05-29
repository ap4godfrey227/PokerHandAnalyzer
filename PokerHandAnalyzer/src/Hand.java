
public class Hand extends MyArrayList{

	private static boolean sorted = false;
	
	private MyArrayList Hand = new MyArrayList();
	
	
	public static void sort(Hand hand) { //Recursive bubble sort to sort the cards by value
		if(sorted == true) {
			return;
		}
		sorted = true;
		for(int i = 0; i < 4; i++) {
			if (hand.getValue(hand, i) > hand.getValue(hand, i+1)) { // If the list is sorted, it won't be able to change sorted to false, which will stop the recursion
				String temp = hand.get(i);
				hand.setCard(hand, hand.get(i+1), i);
				hand.setCard(hand, temp, i+1);
				sorted = false; 
			}
		}
		sort(hand);
	}
	
	
	public int getValue(Hand hand, int index) { //returns the value a card has (ex. "j" returns "11")
		String card = hand.get(index);
		
		if(card.substring(0,1).equals("J") == true) { //Returns a numerical value for a jack
			return 11;
		}
		
		if(card.substring(0,1).equals("Q") == true) { //Returns a numerical value for a queen
			return 12;
		}
		
		if(card.substring(0,1).equals("K") == true) { //Returns a numerical value for a king
			return 13;
		}
		
		if(card.substring(0,1).equals("A") == true) { //Returns a numerical value for an ace
			return 14;
		}
		
		if(card.substring(0,2).equals("10") == true) {
			return 10;
		}
		
		else {
			return Integer.parseInt(card.substring(0,1));
		}
	}
	
	public String getSuit(Hand hand, int index) { // returns the suit of a specific card
		
		if (hand.get(index).length() == 3) { //Since a 10 would have a string 1 character longer than any other, we need to adjust the substring
			return hand.get(index).substring(2);
		}
		else {
			return hand.get(index).substring(1);
		}
	}	
	
	public void setCard(Hand hand, String card, int index) { // changes a specific cards suit and value
		hand.remove(index);
		hand.insert(index, card.toUpperCase());
	}
	
	public String getCard(Hand hand, int index) { // This method will allow us to return the face card name if it appears in a pair, 3 of a kind, etc instead of its numerical value
		String card = hand.get(index);
		
		if(card.substring(0,2).equals("10") == true) {
			return "10";
		}
		if(card.substring(0,2).equals("11") == true) { 
			return "J";
		}
		
		if(card.substring(0,2).equals("12") == true) { 
			return "Q";
		}
		
		if(card.substring(0,2).equals("13") == true) { 
			return "K";
		}
		
		if(card.substring(0,2).equals("14") == true) { 
			return "A";
		}
		else {
			return card.substring(0,1);
		}
	}
	
}
