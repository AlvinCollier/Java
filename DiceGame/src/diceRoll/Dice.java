//Alvin Collier
//1.24.18
//Dice Object

package diceRoll;

import java.util.Random;

public class Dice {
	
	//instance variables
	private int maxRoll;
	private int result;
	
	//default constructor
	public Dice() {
		maxRoll = 6;
		result = 2;
	}
	
	//non-default
	public Dice(int sides) {
		maxRoll = sides;
		result = 3;
	}
	
	public int getDiceRoll() {
		return result;
	}
	
	public void setDiceRoll(int newResult) {
		result = newResult;
	}
	
	public int getDiceMax() {		
		return maxRoll;
	}
	
	public void setDiceMax(int newMax) {
		maxRoll = newMax;
	}
	
	public int rollDice() {
		Random rand = new Random();
		result = rand.nextInt(maxRoll) +1;
		return result;
	}
	
	public String toString() {
		return("Dice has " + maxRoll + " sides, and is currently on " + result);
	}

}
