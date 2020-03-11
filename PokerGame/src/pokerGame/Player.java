package pokerGame;

import java.util.Arrays;

public class Player {

	Card[] playerHand;
	int currentIndex = 0;
	String name;
	int numPairs = 0;
	int num3Kind = 0;
	int num4Kind = 0;
	boolean flush = false;
	String highCard1;
	String highCard2;
	
	public Player(){
		
		playerHand = new Card[5];
		name = "Susan";		
	}

	public Player(Card[] playerHand, String name) {

		this.playerHand = playerHand;
		this.name = name;
	}

	public Card[] getPlayerHand() {
		return playerHand;
	}
	
	public Card getPlayerCard(int index) {
		return playerHand[index];
	}

	public void setPlayerHand(Card card) {
		this.playerHand[currentIndex] = card;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumPairs() {
		return numPairs;
	}

	public void setNumPairs(int numPairs) {
		this.numPairs = numPairs;
	}

	public int getNum3Kind() {
		return num3Kind;
	}

	public void setNum3Kind(int num3Kind) {
		this.num3Kind = num3Kind;
	}

	public int getNum4Kind() {
		return num4Kind;
	}

	public void setNum4Kind(int num4Kind) {
		this.num4Kind = num4Kind;
	}

	public boolean isFlush() {
		return flush;
	}

	public void setFlush(boolean flush) {
		this.flush = flush;
	}
	
	@Override
	public String toString() {
		return "Player [playerHand=" + Arrays.toString(playerHand) + ", currentIndex=" + currentIndex + ", name=" + name
				+ ", numPairs=" + numPairs + ", num3Kind=" + num3Kind + ", num4Kind=" + num4Kind + ", flush=" + flush
				+ "]";
	}

	public void incrementPairs() {
		numPairs++;
	}
	
	public void increment3Kind() {
		num3Kind++;
	}
	
	public void increment4Kind() {
		num4Kind++;
	}
	
	public void checkFlush() {
		if(playerHand[0].getSuit() == playerHand[1].getSuit() && playerHand[0].getSuit() == playerHand[2].getSuit() && playerHand[0].getSuit() == playerHand[3].getSuit()&& playerHand[0].getSuit() == playerHand[4].getSuit()) {
			setFlush(true);
		}
		else {
			setFlush(false);
		}
	}

	public String getHighCard() {
		return highCard1;
	}

	public void setHighCard(String highCard) {
		this.highCard1 = highCard;
	}

	public String getHighCard2() {
		return highCard2;
	}

	public void setHighCard2(String highCard) {
		this.highCard2 = highCard;
	}
	
	
	
}
