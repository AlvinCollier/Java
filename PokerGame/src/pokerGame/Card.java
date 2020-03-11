package pokerGame;

public class Card {

	private String suit;
	private String name;
	private int value;
	private String cardStatus = "not dealt";
	
	public Card() {
		
		this.suit = "Spades";
		this.name = "Ace";
		this.value = 1;
		
	}

	public Card(String suit, String name, int value) {
		
		this.suit = suit;
		this.name = name;
		this.value = value;

	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", name=" + name + ", value=" + value + ", cardStatus=" + cardStatus + "]";
	}
	
	
	
	
	
}
