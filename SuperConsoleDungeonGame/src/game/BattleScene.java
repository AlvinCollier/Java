/*	Alvin Collier
	2017 Dragoon Domain All rights reserved
	Super Extra Console Dungeon Game
	Explore a rich text environment, where you will explore a
	dungeon consisting of infinite level, each with multiple
	paths, which are basically random, and your only objective
	is to collect treasure.
 */

package game;

import java.io.InputStream;
import java.util.Scanner;

public class BattleScene {
	
	private Player player;
	private Enemy monster;
	private GameManager gameManager;
	Scanner input = new Scanner(System.in);
	private boolean defending;
	private boolean running;
	
	public BattleScene(Player player) {
		
		this.player = player;
		monster = new Enemy(player);
		gameManager = new GameManager(player);
	}
	
	public void startBattle() {
		
		System.out.println("You are attacked by a Lv: " + monster.getLv() + " " + monster.getName());
		do {
			System.out.println("|\\_______/|");
			System.out.println("|         |");
			System.out.println("| \\\\   // |");
			System.out.println("\\         /");
			System.out.println(" \\ vvvvv / ");
			System.out.println("  ^^^^^^^  ");
			defending = false;
			gameManager.printStatus(player);
			System.out.println(monster.toString());
			playerTurn();
			if(monster.getHp() > 0) {
				enemyTurn();
			}
		}while(monster.getHp() > 0 && player.getCurrentHP() > 0 && !running);
		endBattle();
	}
	
	public void playerTurn() {
		
		String response;
		System.out.println("What do you do?(a to attack, d to defend):");
		response = input.nextLine();
		if(response.toLowerCase().contains("d")) {
			defending = true;
			System.out.println("You brace yourself against attack!");
		}
		else if(response.toLowerCase().contains("a")) {
			int damage = player.attack();
			damage -= monster.getDf();
			monster.takeDMG(damage);
			System.out.println("You attack the " + monster.getName() + " for " + damage + " damage!" );
		}
		else if(response.toLowerCase().contains("r")) {
			running = true;
		}
	}
	
	public void enemyTurn() {
		
		System.out.println("The " + monster.getName() + " attacks you!");
		int damage;
		damage = monster.dealDMG();
		if(defending) {
			damage /= 2;
		}
		damage -= player.getDefense();
		if(damage > 0) {
			player.takeDamage(damage);
		}
		else {
			System.out.println("The attack was too weak to hurt you.");
		}
	}
	
	public void endBattle() {
		if(player.getCurrentHP() > 0) {
			if(running) {
				System.out.println("You run away, dropping some of your money");
				player.setTreasure(player.getTreasure()/3);
				player.setCurrentFloor(0);
			}
			else {
				System.out.println("You have defeated the " + monster.getName());
				player.addTreasure(monster.getLv()*5);
				player.addExp(monster.getLv()*4);
			}
		}
		else {
			System.out.println("You were slain by the " + monster.getName());
			System.out.println("You drop half your treasure and go back to town..");
			player.setTreasure(player.getTreasure()/2);
			player.setCurrentFloor(0);
			player.setCurrentHP(player.getMaxHP());
		}
	}
	
}
