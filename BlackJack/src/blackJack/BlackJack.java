//Alvin Collier
//1.19.2018
//BlackJack Game
//used algorithm for checking pairs, triples and all that good stuff.

package blackJack;

import java.util.Random;

public class BlackJack {

	public static Card[] deck = new Card[52];


	//using old arrays to define object array variables.
	public static String[] cardName = {"Ace", "Ace", "Ace", "Ace", "Two", "Two", "Two", "Two",
			"Three", "Three", "Three", "Three", "Four","Four", "Four", "Four",
			"Five", "Five", "Five", "Five", "Six", "Six", "Six", "Six",
			"Seven", "Seven", "Seven", "Seven", "Eight", "Eight", "Eight", "Eight",
			"Nine", "Nine", "Nine", "Nine", "Ten", "Ten", "Ten", "Ten", 
			"Jack", "Jack", "Jack", "Jack", "Queen", "Queen","Queen","Queen",
			"King", "King", "King", "King"};

	public static String[] cardSuit = new String[52];

	public static void main (String[] args) {

		/* set up for future use in scoring a game.
		int[] cardValue =  {1,1,1,1, 2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,
				10,10,10,10,10,10,10,10};
		 */

		int i = 0;

		for(i = 0; i < cardName.length; i++) {
			switch(i%4) {
			case 0: cardSuit[i] = "Spades";
			break;
			case 1: cardSuit[i] = "Hearts";
			break;
			case 2: cardSuit[i] = "Clubs";
			break;
			case 3: cardSuit[i] = "Diamonds";
			break;
			}
			deck[i]= new Card(cardName[i], cardSuit[i]);
		}
		/*used for testing
		for(i = 0; i < cardName.length; i++) {
			System.out.println(cardName[i] + " of " + cardSuit[i]);
		}
		 */

		//shuffle the cards with a method
		shuffle(deck);
		for(i = 0; i < cardName.length; i++) {
			System.out.println(deck[i].getCardName() + " of " + deck[i].getCardSuit());
		}
		System.out.println("--------------------------------");

		//deal initial cards to user, then reduce array
		//instead of actually creating a new array, I use a variable to keep track of
		//the card that is on top of the deck, this prevents me from creating new arrays.

		int nextCard = 0;
		int handSize = 5;

		Card userHand[] = new Card[handSize];
		Card cpuHand[] = new Card[handSize];

		//deal 5 cards to user, and print them.
		//we deal every other card to the computer.
		for(i = 0; i < handSize; i++) {
			userHand[i] = deck[nextCard];
			nextCard++;
			cpuHand[i] = deck[nextCard];
			nextCard++;
		}

		System.out.print("Player Cards: ");
		for(i = 0; i < handSize; i++) {
			System.out.print(userHand[i] + ", ");
		}
		System.out.println(" ");
		System.out.print("CPU Cards: ");
		for(i = 0; i < handSize; i++) {
			System.out.print(cpuHand[i] + ", ");
		}
		System.out.println(" ");
		System.out.println("We have " + (deck.length - nextCard) + " cards remaining in the deck");

		System.out.println("--------------------------------");

		//algorithm we discussed in class
		/*
		 * make a back up of the userHand – copy the array to a new array of the same length
			make a count = 0
			FOR index from 0 to userHand.length -1
			FOR secondIndex from 1 to userHand.length
			IF userHand cardName at index == userHand cardName at secondIndex
			count++
			change userHand cardName at secondIndex to “*” concatenated with count
			IF ( count == 1)
			user has a pair so print this out
			ELSE IF ( count == 2)
			user has 3 of a kind so print this out
			ELSE IF ( count == 3)
			user has 4 of a kind so print this out
		---> My plan is to make a check hand function that will return an int
			with the necessary information to print!
		---> To make extra credit we can do a separate count for pairs, trips and fours.
		 */

		int[] userScore = checkHand(userHand);
		//System.out.println(userScore) ;
		switch(userScore[0]) {
		case 0: System.out.println("User does not have any pairs.") ;
		break; 
		case 1: System.out.println("User has a pair!") ;
		break;
		case 2: System.out.println("User has two pairs!");
		break;
		}
		switch(userScore[1]) {
		case 1: System.out.println("User has Three of a Kind!!") ;
		break;
		}
		switch(userScore[2]) {
		case 1: System.out.println("User has FOUR OF A KIND!!!") ;
		break;
		}
		
		int[] cpuScore = checkHand(cpuHand);
		switch(cpuScore[0]) {
		case 0: System.out.println("CPU does not have any pairs.") ;
		break; 
		case 1: System.out.println("CPU has a pair!") ;
		break;
		case 2: System.out.println("CPU has two pairs!");
		break;
		}
		switch(cpuScore[1]) {
		case 1: System.out.println("CPU has Three of a Kind!!") ;
		break;
		}
		switch(cpuScore[2]) {
		case 1: System.out.println("CPU has FOUR OF A KIND!!!") ;
		break;
		}

	}//end main

	public static void shuffle(Card deck[]) {
		Random rand = new Random();
		for(int i = 0; i < cardName.length; i++) {
			int indexToSwap = rand.nextInt(52);
			Card cardToSwap = deck[indexToSwap];
			deck[indexToSwap] = deck[i];
			deck[i] = cardToSwap;	
		}
		return;
	}//end shuffle

	public static int[] checkHand(Card hand[]) {
		int[] count = {0,0,0};
		int pairCount = 0; int tripCount = 0; int quadCount = 0;
		Card[] checkHand = new Card[hand.length];
		checkHand = hand;

		for(int i = 0; i < hand.length-1; i++) {
			for(int i2 = 1; i2 < hand.length; i2 ++) {
				//System.out.println(i + " " + i2);
				if(hand[i].getCardName() == checkHand[i2].getCardName() && i != i2) {
					pairCount++;
					hand[i].setCardName("*" + count);
					for(int i3 = 2; i3 < hand.length; i3++) {
						if(hand[i2].getCardName() == checkHand[i3].getCardName() && i2 != i3) {
							tripCount++;
							pairCount--;
							hand[i2].setCardName("*" + count);
							for(int i4 = 3; i4 < hand.length; i4++) {
								if(hand[i3].getCardName() == checkHand[i4].getCardName() && i3 != i4) {
									quadCount++;
									tripCount--;
									hand[i3].setCardName("*" + count);
								}

							}
						}
					}
				}
			}

		}
		count[0] = pairCount;
		count[1] = tripCount;
		count[2] = quadCount;
		/*for(int i = 0; i < count.length; i++) {
			System.out.println(count[i]) ;
		}*/
		return(count);
	}//end check hand

}//end class
