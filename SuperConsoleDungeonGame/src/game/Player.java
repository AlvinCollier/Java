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

public class Player {

	private String name;
	private int currentFloor; //0 for town
	private int highestFloor;
	private int treasure;
	private int level;
	private int currentExp;
	private int nextLvExp;
	private int attackPow;
	private int defense;
	private int currentHP = 10;
	private int maxHP = 10;
	private Random rand = new Random();
	
	public Player(String name) {
		this.name = name;
		currentFloor = 0;
		highestFloor = 0;
		treasure = 0;
		level = 1;
		currentExp = 0;
		nextLvExp = 10;
		attackPow = 1;
		defense = 0;
		currentHP =10;
		maxHP = 10;
	}

	public Player(String name, int currentFloor, int highestFloor, int treasure, int level, int currentExp,
			int nextLvExp, int attackPow, int defense) {

		this.name = name;
		this.currentFloor = currentFloor;
		this.highestFloor = highestFloor;
		this.treasure = treasure;
		this.level = level;
		this.currentExp = currentExp;
		this.nextLvExp = nextLvExp;
		this.attackPow = attackPow;
		this.defense = defense;
		this.maxHP = (level*3)+7;
		this.setCurrentHP(maxHP);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
		if(this.currentFloor > highestFloor) {
			highestFloor = currentFloor;
		}
	}

	public int getHighestFloor() {
		return highestFloor;
	}

	public void setHighestFloor(int highestFloor) {
		this.highestFloor = highestFloor;
	}

	public int getTreasure() {
		return treasure;
	}

	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCurrentExp() {
		return currentExp;
	}

	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}

	public int getNextLvExp() {
		return nextLvExp;
	}

	public void setNextLvExp(int nextLvExp) {
		this.nextLvExp = nextLvExp;
	}

	public int getAttackPow() {
		return attackPow;
	}

	public void setAttackPow(int attackPow) {
		this.attackPow = attackPow;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	
	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	@Override
	public String toString() {
		return name + " Lv:" + level + " HP:" + currentHP + "/" + maxHP +" Floor:" + currentFloor + "/" + highestFloor
				+ " Treasure:" + treasure +  " XP:" + currentExp + "/"
				+ nextLvExp + " Atk:" + attackPow + " Df:" + defense;
	}
	
	public void takeDamage(int damage) {
		System.out.println("You were hit for " + damage + " damage!");
		this.currentHP -= damage;
	}
	
	public void addTreasure(int amount) {
		System.out.println("You found " + amount + " treasure!");
		this.treasure += amount;
	}
	
	public void addExp(int amount) {
		this.currentExp += amount;
		if(currentExp >= nextLvExp) {
			levelUp();
		}
	}
	
	public void levelUp() {
		level++;
		attackPow = level;
		defense = level/3;
		maxHP = (level*3)+7;
		currentHP += 3;
		if(currentHP > maxHP) {
			currentHP = maxHP;
		}
		nextLvExp += (int)(Math.pow(nextLvExp, 1.25));
		System.out.print("Congratulations, you gained a level!!!");
		
	}
	
	public int attack() {
		int damage = attackPow + rand.nextInt(3);
		return(damage);
	}
	
}
