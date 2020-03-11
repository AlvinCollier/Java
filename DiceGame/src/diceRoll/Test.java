//Alvin Collier
//1.24.2018
//Dice test class

package diceRoll;

import java.util.Scanner;

public class Test {

	public static void main(String[]args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Today we are playing a game with dice!");
		System.out.println("You and the computer will each roll some dice to see who gets the larger result!");
		System.out.println("---------------------------------------");
		System.out.println("First we will start with standard 6-sided dice, (d6)");
		
		//using default constructor
		Dice playerD6 = new Dice();
		Dice computerD6 = new Dice();
		
		playerD6.rollDice();
		computerD6.rollDice();
		
		System.out.println("You rolled a " + playerD6.getDiceRoll() + " out of " + playerD6.getDiceMax() + "!");
		System.out.println("The CPU rolled a " + computerD6.getDiceRoll() + " out of " + computerD6.getDiceMax() + "!");
		
		if(playerD6.getDiceRoll() == computerD6.getDiceRoll()) {
			System.out.println("Oh My! Oh My! Looks like a tie!");
		}
		else if(playerD6.getDiceRoll() > computerD6.getDiceRoll()){
			System.out.println("Humans have bested computers, the machines prepare for the next encounter!");
		}
		else {
			System.out.println("Ha! The computer has bested you in a game of chance, you must have no skill at dice!");
		}
		System.out.println("---------------------------------------");
		System.out.println("How about we get crazy, choose the number of sides for your dice.");
		int num = in.nextInt();
		in.close();
		//using crazy constructor
		Dice playerCustomD = new Dice(num);
		Dice computerCustomD = new Dice(num);
		
		playerCustomD.rollDice();
		computerCustomD.rollDice();
		
		System.out.println("You rolled a " + playerCustomD.getDiceRoll() + " out of " + playerCustomD.getDiceMax() + "!");
		System.out.println("The CPU rolled a " + computerCustomD.getDiceRoll() + " out of " + computerCustomD.getDiceMax() + "!");
		
		if(playerCustomD.getDiceRoll() == computerCustomD.getDiceRoll()) {
			System.out.println("Oh My! Oh My! Looks like a tie!");
		}
		else if(playerCustomD.getDiceRoll() > computerCustomD.getDiceRoll()){
			System.out.println("Humans have bested computers, the machines prepare for the next encounter!");
		}
		else {
			System.out.println("Ha! The computer has bested you in a game of chance, you must have no skill at dice!");
		}
		
		//testing toString
		System.out.println("---------------------------------------");
		System.out.println(playerD6);
		System.out.println(computerD6);
		System.out.println(playerCustomD);
		System.out.println(computerCustomD);
		
	}
	
}
