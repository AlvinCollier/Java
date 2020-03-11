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

public class Encounter {

	private int encounterType;
	private Scanner input = new Scanner(System.in);
	private Player player;

	public Encounter(Random rand, Player player){
		this.player = player;
		encounterType = rand.nextInt(1);
		switch(encounterType) {

		case 0: Doors();
		break;

		}
	}

	public void Doors() {

		System.out.println("");
		System.out.println("Before you lies three doors...");
		System.out.println("");
		System.out.println("_______________________________________________");
		System.out.println("||----\\ /----||_||----\\ /----||_||----\\ /----||");
		System.out.println("||___________||_||___________||_||___________||");
		System.out.println("|| |       | ||_|| |       | ||_|| |       | ||");
		System.out.println("|| |  **   | ||_|| |  ***  | ||_|| |  ***  | ||");
		System.out.println("|| |   *   | ||_|| | *   * | ||_|| | *   * | ||");
		System.out.println("|| |   *   | ||_|| |     * | ||_|| |   **  | ||");
		System.out.println("|| |   *   | ||_|| |   **  | ||_|| | *   * | ||");
		System.out.println("|| | ***** | ||_|| | ***** | ||_|| |  ***  | ||");
		System.out.println("_______________________________________________");
		System.out.println("Press (1, 2 or 3) To Select a Door:");
		Random rand = new Random();
		int door1 = rand.nextInt(6);
		int door2 = rand.nextInt(6);
		int door3 = rand.nextInt(6);
		String response;
		response = input.nextLine();
		if(response.contains("1") || response.toLowerCase().contains("l")) {
			System.out.println("You open the first door to find...");
			doorOpeningEvent(door1);
		}
		else if(response.contains("2") || response.toLowerCase().contains("m")) {
			System.out.println("You open the second door to find...");
			doorOpeningEvent(door2);
		}
		else {
			System.out.println("You open the third door to find...");
			doorOpeningEvent(door3);
		}
	}

	public void doorOpeningEvent(int event) {
		switch(event) {
		case 0: System.out.println("A path leading to the next floor.");
		player.setCurrentFloor(player.getCurrentFloor()+1);
		Doors();
		break;

		case 1: System.out.println("You find a room with a treasure chest.");
		player.addTreasure(player.getCurrentFloor()*3);
		break;

		case 2: System.out.println("A trap");
		player.takeDamage(player.getCurrentFloor()*9);
		if(player.getCurrentHP() < 0)
		{
			System.out.println("You were killed by the trap..");
			player.setTreasure(player.getTreasure()/2);
			player.setCurrentFloor(0);
		}
		break;

		case 3: BattleScene battle = new BattleScene(player);
		battle.startBattle();
		break;

		case 4: System.out.println("A long dark hallway.");
		break;

		default: System.out.println("Something different.");
		break;
		}
	}

}
