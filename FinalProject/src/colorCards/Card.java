//Alvin Collier
//4.26.2018
//final project
//colorCards

package colorCards;

public class Card {

	int number;
	String color;
	
	public Card(int number, String color) {
		this.number = number;
		this.color = color;
		if(number > 10) {
			this.number = 10;
		}
		if(number == 14) {
			this.number = 11;
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Card [number=" + number + ", color=" + color + "]";
	}
	
	
	
}
