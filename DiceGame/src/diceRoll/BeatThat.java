//Alvin Collier
//2.9.2018
//Beat that

package diceRoll;

import java.util.Scanner;

public class BeatThat {

	static Dice[] diceUsed;
	static Player[] player;

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many players are thier going to be for this game?");
		int numPlayers = keyboard.nextInt();
		keyboard.nextLine();

		player = new Player[numPlayers];

		System.out.println("How many dice are thier going to be for this game?");
		int numDice = keyboard.nextInt();
		keyboard.nextLine();

		diceUsed = new Dice[numDice];
		for(int i =0; i < diceUsed.length; i++) {
			diceUsed[i] = new Dice();
		}

		for(int i = 0; i < player.length; i++) {
			System.out.println("What is player " + (i+1) + "'s name?");
			String name = keyboard.nextLine();
			player[i] = new Player(name);
		}

		//Starting round for each player
		for(int i = 0; i < player.length; i++) {

			for(int j = 0; j < diceUsed.length; j++) {
				int[] valueRolled =  new int[diceUsed.length];
				diceUsed[j].rollDice();
				//was used for debugging purposes
				//System.out.println(diceUsed[j].getDiceRoll());
				valueRolled[j] = diceUsed[j].getDiceRoll();
			}

			int max = 0;
			int maxIndex = -1;
			int count = 0;
			int score = 0;
			for(int j = 0; j < diceUsed.length; j++) {
				for(int k = 0; k < diceUsed.length; k++) {
					if(diceUsed[k].getDiceRoll() > max) {
						max = diceUsed[k].getDiceRoll();
						maxIndex = k;
					}
				}
				diceUsed[maxIndex].setDiceRoll(0);
				count++;
				score += (int) (max*Math.pow(10, (diceUsed.length - count)));
				max = 0;
			}
			player[i].setPlayerScore(score);
			System.out.println(player[i].getPlayerName() + " " + player[i].getPlayerScore());
		}
		
		//compare players score
		String winningPlayer = "";
		int highestScore =0;
		for(int i = 0; i < player.length; i++) {

			if(player[i].getPlayerScore() > highestScore) {
				highestScore = player[i].getPlayerScore();
				winningPlayer = player[i].getPlayerName();
			}

		}

		System.out.println(winningPlayer + " has won the game!!!");
		keyboard.close();
	}
	


}
