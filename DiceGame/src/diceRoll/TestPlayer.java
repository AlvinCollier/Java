package diceRoll;

public class TestPlayer {

	public static void main(String[] args) {
		
		Player player1 = new Player();
		int[] rolls = {1,2,3,4,5};
		Player player2 = new Player("New Player", 0, rolls);
		System.out.println(player1);
		System.out.println(player2);
		player1.setPlayerName("First Player");
		player1.setPlayerScore(10);
		player1.setPlayerRoll(rolls);
		System.out.println(player1.getPlayerName());
		System.out.println(player1.getPlayerScore());
		System.out.println(player1.getPlayerRoll());
		System.out.println(player1.getPlayerName() + " has " + player1.hasValue(1) + " ones!");
		//let's bring it all together now! :)
		Dice di = new Dice();
		for(int i = 0; i < rolls.length; i++) {
			rolls[i] = di.rollDice();
		}
		player2.setPlayerRoll(rolls);
		System.out.println(player1.getPlayerName() + " has " + player1.hasValue(6) + " sixes!" + player1.getPlayerRoll());
		System.out.println(player2.getPlayerName() + " has " + player2.hasValue(6) + " sixes!" + player2.getPlayerRoll());
	}

}
