//Alvin Collier
//4.26.2018
//final project
//colorCards

package colorCards;

import java.util.Scanner;

//public class ColorCards {
/*
	public static void main(String[] args) {

		System.out.println("Would you like to play a game of Color Cards?");
		Scanner sc = new Scanner(System.in);
		String response = sc.nextLine();
		if(response.toLowerCase().contains("y")) {
			PlayGame gameInstance = new PlayGame();
		}
		sc.close();

	}

}
*/
public class ColorCards implements Game{

	Scanner sc = new Scanner(System.in);
	Player player;
	Player computer;
	Deck deck;
	Queue drawQue;
	int turn;
	int currentid;
	
	public String getName() {

		return ("Color Cards");
	}

	public void putDeckIntoQue() {

		for(int i = 0; i < deck.getCard().length; i++) {
			//System.out.println(deck.getCardAtIndex(i));
			drawQue.insert(deck.getCardAtIndex(i));

		}

	}

	public void drawCards(Player current) {
		turn++;
		if(turn == 1) {
			for(int i = 0; i < 5; i++) {
				player.drawCard(drawQue.remove(), currentid);
				computer.drawCard(drawQue.remove(), currentid);
				currentid++;
			}
			System.out.print(player.getName() + "'s ");
			//computer.getHand().displayList();
		}
		else {
			current.drawCard(drawQue.remove(), currentid);
		}
	}

	public void turn() {
		int response = -1;
		Card playerCard;
		Card computerCard;
		player.getHand().displayList();
		while(response < 0 || response > 4) {
			System.out.println("Choose a card to play: (0-4)");
			response = sc.nextInt();
		}
		currentid = response;
		player.hand.find(currentid);
		System.out.print(player.getName() + " played ");
		player.hand.find(currentid).displayLink();
		playerCard = player.hand.delete(currentid).card;
		drawCards(player);
		
		currentid = computer.chooseCard();
		computer.hand.find(currentid);
		System.out.print(computer.getName() + " played ");
		computer.hand.find(currentid).displayLink();
		computerCard = computer.hand.delete(currentid).card;
		drawCards(computer);
		
		resolveTurn(playerCard, computerCard);
		if(player.getScore() > 5 || computer.getScore() > 5) {
			turn();
		}
		else if(player.getScore() > computer.getScore()){

		}
		else {
			
		}
		
		return;

	}
	
	public void resolveTurn(Card playerCard, Card computerCard) {
		
		int playerPower = 0;
		int computerPower = 0;
		
		if(playerCard.getColor() == "Red") {
			if(computerCard.getColor() == "Green") {
				System.out.println(player.getName() + "'s Red Card is super effecive!");
				playerPower = playerCard.getNumber()*2;
			}
			else if(computerCard.getColor() == "Blue") {
				System.out.println(computer.getName() + "'s Blue Card is super effecive!");
				computerPower = computerCard.getNumber()*2;
			}
		}
		else if(playerCard.getColor() == "Green") {
			if(computerCard.getColor() == "Yellow") {
				System.out.println(player.getName() + "'s Green Card is super effecive!");
				playerPower = playerCard.getNumber()*2;
			}
			else if(computerCard.getColor() == "Red") {
				System.out.println(computer.getName() + "'s Red Card is super effecive!");
				computerPower = computerCard.getNumber()*2;
			}
		}
		else if(playerCard.getColor() == "Yellow") {
			if(computerCard.getColor() == "Blue") {
				System.out.println(player.getName() + "'s Yellow Card is super effecive!");
				playerPower = playerCard.getNumber()*2;
			}
			else if(computerCard.getColor() == "Green") {
				System.out.println(computer.getName() + "'s Green Card is super effecive!");
				computerPower = computerCard.getNumber()*2;
			}
		}
		else{
			if(computerCard.getColor() == "Red") {
				System.out.println(player.getName() + "'s Blue Card is super effecive!");
				playerPower = playerCard.getNumber()*2;
			}
			else if(computerCard.getColor() == "Yellow") {
				System.out.println(computer.getName() + "'s Yellow Card is super effecive!");
				computerPower = computerCard.getNumber()*2;
			}
		}
		
		if(playerPower == 0) {
			playerPower = playerCard.getNumber();
		}
		
		if(computerPower == 0) {
			computerPower = computerCard.getNumber();
		}
		
		if(playerPower == computerPower) {
			System.out.println("This turn ended with a tie.");
		}
		else if(playerPower > computerPower) {
			System.out.println(player.getName() + " wins this round with a " + playerPower);
			player.increaseScore();
		}
		else {
			System.out.println(computer.getName() + " wins this round a " + computerPower);
			computer.increaseScore();
		}
		
		System.out.println("Current Score: " + player.getScore() + " to " + computer.getScore());
		
	}

	public boolean playGame(Player player){
		System.out.println("What is your name?");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		this.player = new Player(name);
		computer = new Player("Computer");
		deck = new Deck();
		drawQue = new Queue(52);
		turn = 0;
		currentid = 0;
		putDeckIntoQue();
		drawCards(player);
		while(player.getScore() < 10 || computer.getScore() < 10)
		{
			turn();
		}
		//sc.close();
		return true;
	}



}
