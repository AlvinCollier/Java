//Alvin Collier
//4.26.2018
//final project
//colorCards

package colorCards;

import java.util.Random;

public class Deck {

	int totalCards;
	Card card[];
	
	public Deck() {
		totalCards = 52;
		card = new Card[totalCards];
		for(int i = 0; i < card.length; i++) {
			int cardnum = (((i)/4)+2);
			String cardColor = "";
			switch(i%4){
			case 0: cardColor = "Red";
			break;
			case 1: cardColor = "Green";
			break;
			case 2: cardColor = "Yellow";
			break;
			case 3: cardColor = "Blue";
			}
			card[i] = new Card(cardnum, cardColor);
		}
		
		/*
		//for debugging
		for(int i = 0; i < card.length; i++) {
			System.out.println(i + " " + card[i].toString());
		}
		*/
		
		shuffle(card);
	}
	
	public void shuffle(Card[] deck) {
		
		Random rand = new Random();
		int randomCard;
		
		for(int i = 0; i < deck.length; i++) {
			Card temp = deck[i];
			randomCard = rand.nextInt(52);
			deck[i] = deck[randomCard];
			deck[randomCard] = temp;
		}
		
		/*
		//for debugging
		for(int i = 0; i < card.length; i++) {
			System.out.println(i + " " + card[i].toString());
		}
		*/
		
	}
	
	public Card getCardAtIndex(int i) {
		return card[i];
	}

	public int getTotalCards() {
		return totalCards;
	}

	public void setTotalCards(int totalCards) {
		this.totalCards = totalCards;
	}

	public Card[] getCard() {
		return card;
	}

	public void setCard(Card[] card) {
		this.card = card;
	}
	
	

}
