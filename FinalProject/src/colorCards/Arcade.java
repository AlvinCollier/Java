//Alvin Collier
//4.26.2018
//final project
//colorCards

package colorCards;

import java.util.Scanner;

public class Arcade {

	//make an array of Game objects - this will hold of the Games that we have 
	//created that have implemented the Game interface - remember that this is the
	//rule that we have implemented this interface - so that they have the player object and
	//score and the playGame method
	private static Game[] games = new Game[1];
	private static Player player = new Player();


	//the default contructor - initializing the array with some of my Games
	public Arcade() {
		System.out.println(games);
		games[0] = new ColorCards(); 
 
	}

	public static void main(String[] args) {
		Arcade arcade = new Arcade(); //calls the default constructor that initializes the games in the array
		//System.out.println("main"+games);
		//games[0].playGame(arcade.player);

		do {

			System.out.println("Pick a game number");

			//print out the names of the games so that the user can choose which game to play
			for(int i = 0; i < arcade.games.length; i++) {
				System.out.println("Game at num " + i + " is " + arcade.games[i].getName());
			}

			int userChoice = 0;
			Scanner input = new Scanner(System.in);
			//keep the user here until they choose a correct game number in the array
			do {
				System.out.println("please choose a game number choice between 0 and " + (games.length-1));
				userChoice = input.nextInt();	
			}while(userChoice < 0 || userChoice >= games.length);


			games[userChoice].playGame(arcade.player);
			//print out the users score
			System.out.println("your score is " + arcade.player.getScore());
		}while(true);

	}

}
