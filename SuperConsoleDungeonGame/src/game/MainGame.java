/*	Alvin Collier
	2017 Dragoon Domain All rights reserved
	Super Extra Console Dungeon Game
	Explore a rich text environment, where you will explore a
	dungeon consisting of infinite level, each with multiple
	paths, which are basically random, and your only objective
	is to collect treasure.
*/

package game;

import java.io.IOException;
import java.util.Scanner;

public class MainGame {

	public static void main(String[] args) throws IOException {
		
		
		Player player;
		System.out.println("Welcome adventurer!");
		System.out.println("What is your name hero?");
		Scanner input = new Scanner(System.in);
		String playerNameEntry = input.nextLine();
		String fileName = playerNameEntry + "SuperConsoleDungeonSave.txt";
		
		try {
			ReadFile file = new ReadFile(fileName);
			String[] aryLines = file.OpenFile();
			SearchPlayerData search = new SearchPlayerData();
			String[] playerData = search.findPlayerDataInSaveFile(aryLines, playerNameEntry);
			player = new Player(playerData[0], Integer.valueOf(playerData[1]), Integer.valueOf(playerData[2]), Integer.valueOf(playerData[3]), Integer.valueOf(playerData[4]), Integer.valueOf(playerData[5]),
					Integer.valueOf(playerData[6]), Integer.valueOf(playerData[7]), Integer.valueOf(playerData[8]));
		}
		catch (IOException e) {
			//System.out.println(e.getMessage());
			System.out.println("Save data was not found for " + playerNameEntry);
			System.out.println("Starting a new Game");
			WriteFile data = new WriteFile(fileName);
			data.writeToFile(playerNameEntry);
			player = new Player(playerNameEntry);
			
			System.out.println("Save File created for " + playerNameEntry);
		}
				
		GameManager gameManager = new GameManager(player);
		
		String response = "";
		//main game loop
		do{
		gameManager.printStatus(player);
		gameManager.event(player);
		response = input.nextLine();
		gameManager.Action(response, player);
		}while(response.toLowerCase() != "exit");
		
		input.close();
		
	}
	

}
