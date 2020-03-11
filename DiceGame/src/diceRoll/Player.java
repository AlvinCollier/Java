//Alvin Collier
//2.1.2018
//Player class for dice game

package diceRoll;

import java.util.Arrays;

public class Player {

	private String playerName;
	private int playerScore;
	private int[] playerRoll = new int[5];
	
	public Player() {
		this.playerName = "default player";
		this.playerScore = 0;
		for(int i = 0; i < playerRoll.length; i++) {
			this.playerRoll[i] = 1;
		}
	}
	
	public Player(String playerName) {
		this.playerName = playerName;
	}

	public Player(String playerName, int playerScore, int[] playerRoll) {
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.playerRoll = playerRoll;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public String getPlayerRoll() {
		return Arrays.toString(playerRoll);
	}

	public void setPlayerRoll(int[] playerRoll) {
		this.playerRoll = playerRoll.clone();
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", playerScore=" + playerScore + ", playerRoll="
				+ Arrays.toString(playerRoll) + "]";
	}
	
	public int hasValue(int num) {
		int count = 0;
		for(int i = 0; i < playerRoll.length; i++) {
			if(playerRoll[i] == num) {
				count++;
			}
		}
		return count;
	}
	
	
}//end player class
