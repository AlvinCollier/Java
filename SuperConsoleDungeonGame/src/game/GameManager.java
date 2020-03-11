/*	Alvin Collier
	2017 Dragoon Domain All rights reserved
	Super Extra Console Dungeon Game
	Explore a rich text environment, where you will explore a
	dungeon consisting of infinite level, each with multiple
	paths, which are basically random, and your only objective
	is to collect treasure.
 */

package game;

import java.util.Random;
import java.io.InputStream;
import java.util.Scanner;

public class GameManager {

	private boolean inTown;
	private Random rand = new Random();
	private Scanner input = new Scanner(System.in);
	private Player player;
	
	public GameManager(Player player) {
		this.player = player;
	}

	public void printStatus(Player player) {
		System.out.println(player.toString());
	}

	public void event(Player player) {

		if(player.getCurrentFloor() == 0) {
			Town();
		}
		else {
			Dungeon();
		}

	}

	public void Town() {
		System.out.println("");
		System.out.println("You are in a small village just near the entrance to the dungeon,");
		System.out.println("Amongst the hustle of townsfolk, attending to thier normal business");
		System.out.println("there is an Inn with a tavern, and a small shop.");
		System.out.println("");
		System.out.println("You may check out the Inn by typing 'Inn' or simply type 'ready' when");
		System.out.println("When you are ready to face the horrors of the Dungeon.");
		System.out.println("");
		inTown = true;
	}

	public void Dungeon() {
		inTown = false;
		Hallway hallway = new Hallway(rand);
		for(int i = 0; i < hallway.getDistance(); i++) {
			if(hallway.getDirectionsAtDistance(i) == 0) {
				System.out.println("There is a long dark hallway ahead of you.");
				System.out.println("You move forward, it is your only option");
				String response = input.nextLine();			
			}
			else if(hallway.getDirectionsAtDistance(i) == 1) {
				System.out.println("There is a fork in the path.");
				System.out.println("Do you go left or right?");
				String response = input.nextLine();				
			}
			else {
				System.out.println("The hallway splits into three directions.");
				System.out.println("Do you move forward, left or right?");
				String response = input.nextLine();		
			}
		}
		Encounter encounter = new Encounter(rand, player);
		
	}

	public void Action(String response, Player player) {

		if(inTown) {
			if(response.toLowerCase().contains("inn") || response.toLowerCase().contains("tavern")) {
				System.out.println("You walk into the inn, a few patrons are sitting around the bar and at the tables.");
				System.out.println("");
			}
			else if(response.toLowerCase().contains("shop") || response.toLowerCase().contains("store")) {
				System.out.println("There is a sign posted");
				System.out.println("'Opening Soon'");
				System.out.println("");
			}
			else if(response.toLowerCase().contains("ready") || response.toLowerCase().contains("dungeon")) {
				System.out.println("You make your way down a dark path that leads through a lightly wooded area,");
				System.out.println("until you reach the mouth of a cave with torches lit on either side.");
				System.out.println("A cold wind bellows from the cavern with a distant growl, as you enter the dungeon.");
				System.out.println("");
				player.setCurrentFloor(1);
			}
		}
	}
}
