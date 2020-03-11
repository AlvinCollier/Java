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

public class Hallway {

	private int distance;
	private int[] directions;
	
	public Hallway(Random rand){
		distance = rand.nextInt(2);
		distance++;
		directions = new int[3];
		for(int i = 0; i < distance; i++) {
			directions[i] = rand.nextInt(3);
		}
	}
	
	public int getDistance() {
		return distance;
	}
	
	public int getDirectionsAtDistance(int distance) {
		return directions[distance];
	}
	
}
