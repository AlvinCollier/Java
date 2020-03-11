//Alvin Collier
//4.26.2018
//final project
//colorCards

package colorCards;

public class Player{

	String name;
	LinkList hand;
	int score;
	
	public Player() {
		name = "Player";
		hand = new LinkList();
		score = 0;
	}
	
	public Player(String name) {
		this.name = name;
		hand = new LinkList();
		score = 0;
	}
	
	public void drawCard(Card card, int id) {
		hand.insertFirst(card, id);
	}
	
	public int chooseCard() {
		int cardnum = 0;
		int cardIndex = -1;
		for(int i = 0; i < 5; i++) {
			if(cardnum < hand.find(i).card.getNumber()) {
				cardnum = hand.find(i).card.getNumber();
				cardIndex = i;
			}
		}
		return cardIndex;
	}
	
	public void increaseScore() {
		score++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkList getHand() {
		return hand;
	}

	public void setHand(LinkList hand) {
		this.hand = hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
