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

public class Enemy {

	private String name;
	private int lv;
	private int atk;
	private int df;
	private int hp;
	private Random rand;
	
	public Enemy() {
		
		rand = new Random();
		
		lv = 1;
		atk = 1;
		df = 0;
		hp = 3;
		
		
		switch(rand.nextInt(10)) {
		
		case 0: name = "Kobold";
		break;
		
		case 1: name = "Glorba";
		break;
		
		case 2: name = "Slimric";
		break;
		
		case 3: name = "Zombie"; df++;
		break;
		
		case 4: name = "Giant Spider";
		break;
		
		case 5: name = "Razor Fin";
		break;
		
		case 6: name = "Goblin";
		break;
		
		case 7: name = "Orc"; atk++;
		break;
		
		case 8: name = "Golem"; df++; atk++; hp++;
		break;
		
		case 9: name = "Ghost";
		break;
		}
		
	}
	
public Enemy(Player player) {
		
		rand = new Random();
		
		lv = player.getCurrentFloor() + rand.nextInt(3);
		if(lv > 3) {
			lv = lv - rand.nextInt(2);
		}
		atk = lv;
		df = lv/3;
		hp = lv*3;
		
		
		switch(rand.nextInt(10)) {
		
		case 0: name = "Kobold";
		break;
		
		case 1: name = "Glorba";
		break;
		
		case 2: name = "Slimric";
		break;
		
		case 3: name = "Zombie"; df++;
		break;
		
		case 4: name = "Giant Spider";
		break;
		
		case 5: name = "Razor Fin";
		break;
		
		case 6: name = "Goblin";
		break;
		
		case 7: name = "Orc"; atk++;
		break;
		
		case 8: name = "Golem"; df++; atk++; hp++;
		break;
		
		case 9: name = "Ghost";
		break;
		}
		
	}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getLv() {
	return lv;
}

public void setLv(int lv) {
	this.lv = lv;
}

public int getAtk() {
	return atk;
}

public void setAtk(int atk) {
	this.atk = atk;
}

public int getDf() {
	return df;
}

public void setDf(int df) {
	this.df = df;
}

public int getHp() {
	return hp;
}

public void setHp(int hp) {
	this.hp = hp;
}

public int dealDMG() {
	return(atk + rand.nextInt(3));
}

public void takeDMG(int damage) {
	hp -= damage;
}

@Override
public String toString() {
	return name + " Lv:" + lv + " HP:" + hp + " Atk:" + atk + " Df:" + df;
}

}
