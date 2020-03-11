//Alvin Collier
//2.2.2018

package pokerGame;

import java.util.Arrays;

public class Poker {

	public static Deck deckOfCards;
	public static int numOfPlayers = 2;
	public static Player[] players = new Player[numOfPlayers];

	public static void main(String[] args) {

		loadDeck();
		//System.out.println(deckOfCards.toString());
		shuffleDeck();
		//System.out.println(deckOfCards.toString());
		for(int i = 0; i < players.length; i++) {
			if(i > 0) {
				players[i] = new Player(new Card[5],"CPU Player " + i);
			}
			else {
				players[i] = new Player(new Card[5],"Susan");
			}
		}
		System.out.println(Arrays.toString(players));
		giveUserCards();
		System.out.println(Arrays.toString(players));
		for(int i = 0; i < players.length; i++) {
			checkPairs3Kind4Kind(players[i]);
		}
		System.out.println(Arrays.toString(players));

		//display player scores
		for(int i = 0; i < players.length; i++) {
			System.out.println(players[i].getName());
			System.out.println(Arrays.toString(players[i].getPlayerHand()));
			System.out.println(players[i].getNumPairs() + " pairs,");			
			System.out.println(players[i].getNum3Kind() + " 3 of a kind,");
			System.out.println(players[i].getNum4Kind() + " 4 of a kind,");
			System.out.println( "Flush: " + players[i].isFlush());
			System.out.println(players[i].getHighCard() + " " + players[i].getHighCard2());
		}
		winConditions();
	}

	public static void loadDeck() {

		int numberOfCards = 52;
		Card[] cards = new Card[numberOfCards];
		String[] suit = {"Spades", "Hearts", "Clubs", "Diamonds"};
		String[] name = {"Ace", "Two", "Three", "Four", "Five",
				"Six", "Seven", "Eight", "Nine",
				"Ten", "Jack", "Queen", "King"};
		int[] value = {14,2,3,4,5,6,7,8,9,10,11,12,13};
		int cardIndex = 0
				;
		for(int i = 0; i < name.length; i++) {
			for(int i2 = 0; i2 < suit.length; i2++) {
				cards[cardIndex] = new Card(suit[i2], name[i], value[i]);
				cardIndex++;
			}
		}
		deckOfCards = new Deck(cards);

	}

	public static void shuffleDeck() {

		deckOfCards.shuffle();
	}

	public static void giveUserCards() {
		for(int i = 0; i < 5; i++) {
			for(int i2 = 0; i2 < players.length; i2++) {
				players[i2].setPlayerHand(deckOfCards.dealCard());
				players[i2].setCurrentIndex(players[i2].getCurrentIndex()+1);
			}
		}

	}

	public static void checkPairs3Kind4Kind(Player player1) {
		Card[] userCard = player1.getPlayerHand();

		//making a back up of the users hand so that we do not wreck all of his cards
		Card[] temp = new Card[userCard.length];
		for(int i = 0; i < userCard.length; i++) {
			String name = userCard[i].getName();
			int value = userCard[i].getValue();
			String suit = userCard[i].getSuit();
			temp[i] = new Card(suit, name, value);	
			//writing it in one line of code
			//temp[i] = new Card(userCard[i].getCardName(), userCard[i].getCardValue(),userCard[i].getCardSuit());); 
		}
		userCard = temp;

		int counter = 0;
		String star = "*";

		for(int index = 0; index < userCard.length - 1; index++) {
			for(int index2 = index+1; index2 < userCard.length; index2++) {
				String nameCard1 = userCard[index].getName();
				String nameCard2 = userCard[index2].getName();
				if(nameCard1.equals(nameCard2)) {
					if(player1.getHighCard() == null) {
						player1.setHighCard(nameCard1);
					}
					else if(player1.getHighCard2() == null) {
						player1.setHighCard2(nameCard1);
					}
					counter++;
					userCard[index2].setName(star);//change the card name forever
					star+="*";
				}
			}//end inner for loop
			if(counter == 1)//we know we found a pair
				player1.incrementPairs();
			else if(counter == 2)//we know we found 3 of a kind
				player1.increment3Kind();
			else if(counter == 3)//we know we found 3 of a kind
				player1.increment4Kind();

			counter= 0;
		}//end outer for loop
	}//end method

	public static void winConditions() {
		String winningPlayerName = "";
		int winningPlayerIndex = 0;
		Player winningPlayer = new Player();
		int compareValue = 0;
		String winningType = "";
		//boolean tie;
		for(int i =0; i <players.length; i++) {
			for(int i2 =0; i2 <players[i].playerHand.length; i2++) {
				if(players[i].getPlayerCard(i2).getValue() > compareValue) {
					compareValue = players[i].getPlayerCard(i2).getValue();
					if(players[i].getHighCard() == null) {
						players[i].setHighCard(players[i].getPlayerCard(i2).getName());
					}
					else if(players[i].getHighCard2() == null) {
						players[i].setHighCard2(players[i].getPlayerCard(i2).getName());
					}
					winningPlayerName = players[i].getName();
					winningPlayerIndex = i;
					winningPlayer.setName(winningPlayerName);
					winningType = "High Card";
				}
			}
		}
		compareValue = 0;
		
		for(int i =0; i <players.length-1; i++) {
			for(int i2 =i+1; i2 <players.length; i2++) {
				int comparePairs1 = players[i].getNumPairs();
				int comparePairs2 = players[i2].getNumPairs();
				if(comparePairs1 > comparePairs2) {
					if(comparePairs1 > compareValue) {
						winningPlayerName = players[i].getName();
						winningPlayerIndex = i;
						winningPlayer.setName(winningPlayerName);
						winningType = "a Pair of";
					}

				}
				else if (comparePairs2 > comparePairs1) {
					if(comparePairs2 > compareValue) {
						winningPlayerName = players[i2].getName();
						winningPlayerIndex = i2;
						winningPlayer.setName(winningPlayerName);
						winningType = "a Pair of";
					}
				}
				else {
					
				}
			}
		}
		compareValue = 0;
		
		for(int i =0; i <players.length-1; i++) {
			for(int i2 =i+1; i2 <players.length; i2++) {
				int compare3Kind1 = players[i].getNumPairs();
				int compare3Kind2 = players[i2].getNumPairs();
				if(compare3Kind1 > compare3Kind2) {
					if(compare3Kind1 > compareValue) {
						winningPlayerName = players[i].getName();
						winningPlayerIndex = i;
						winningPlayer.setName(winningPlayerName);
						winningType = "Three of";
					}

				}
				else if (compare3Kind2 > compare3Kind1) {
					if(compare3Kind2 > compareValue) {
						winningPlayerName = players[i2].getName();
						winningPlayerIndex = i2;
						winningPlayer.setName(winningPlayerName);
						winningType = "Three of";
					}
				}
				else {
					
				}
			}
		}
		compareValue = 0;

		for(int i =0; i <players.length-1; i++) {
			for(int i2 =i+1; i2 <players.length; i2++) {
				int compare4Kind1 = players[i].getNum4Kind();
				int compare4Kind2 = players[i2].getNum4Kind();
				if(compare4Kind1 > compare4Kind2) {
					winningPlayerName = players[i].getName();
					winningPlayerIndex =i;
					winningPlayer.setName(winningPlayerName);
					winningType = "Four of";
				}
				else if (compare4Kind2 > compare4Kind1) {
					winningPlayerName = players[i2].getName();
					winningPlayerIndex = i2;
					winningPlayer.setName(winningPlayerName);
					winningType = "Four of";
				}
				else {
					//check who has the highest card.
				}
			}
		}
		
		if(winningType == "High Card") {
			System.out.println(winningPlayerName + " is the winner, with a " + winningType + " " + players[winningPlayerIndex].highCard1);
		}
		else {
			System.out.println(winningPlayerName + " is the winner, with " + winningType + " " + players[winningPlayerIndex].highCard1 + "'s");
		}
		

	}
}
