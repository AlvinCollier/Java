package pokerGame;

import java.util.Arrays;
import java.util.Random;

public class Deck {

	private Card[] cards;
	private int numberOfCards = 52;
	private int currentCardIndex = 0;
	
	public Deck() {

		this.cards = new Card[numberOfCards];
	}
	
	public Deck(Card[] cards) {
		
		this.cards = cards;

	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

	public int getCurrentCardIndex() {
		return currentCardIndex;
	}

	public void setCurrentCardIndex(int currentCardIndex) {
		this.currentCardIndex = currentCardIndex;
	}

	@Override
	public String toString() {
		return "Deck [cards=" + Arrays.toString(cards) + ", numberOfCards=" + numberOfCards + ", currentCardIndex="
				+ currentCardIndex + "]";
	}
	
	public void shuffle() {
		
		Card tempCard = new Card();
		for(int i = 0; i < numberOfCards; i++) {
			int rand = new Random().nextInt(numberOfCards);
			tempCard = cards[i];
			cards[i] = cards[rand];
			cards[rand] = tempCard;
		}
		return;
	}
	
	public void reloadDeck() {
		
		currentCardIndex = 0;
		shuffle();
	}
	
	public Card dealCard() {
		
		if(cards[currentCardIndex].getCardStatus() != "not dealt") {
			currentCardIndex++;
		}
		cards[currentCardIndex].setCardStatus("Dealt");
		return(cards[currentCardIndex]);
		
	}
}
