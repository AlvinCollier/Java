//Alvin Collier
//1.26.2018
//Card Object

package blackJack;

public class Card {

	//instance variables
		private String cardName;
		private String cardSuit;
		
		//default constructor
		public Card() {
			cardName = "King";
			cardSuit = "Ace";
		}
		
		//non-default
		public Card(String name, String suit) {
			cardName = name;
			cardSuit = suit;
		}
		
		public String getCardName() {
			return cardName;
		}
		
		public void setCardName(String name) {
			cardName = name;
		}
		
		public String getCardSuit() {
			return cardSuit;
		}
		
		public void setCardSuit(String suit) {
			cardSuit = suit;
		}
		
		
		
		public String toString() {
			return( cardName + " of " + cardSuit);
		}

	
}
