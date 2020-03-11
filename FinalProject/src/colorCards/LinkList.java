package colorCards;

class Link{
	public Card card;
	public int id;
	public Link next;

	public Link(Card card, int id) {
		this.card = card;
		this.id = id;
	}
	
	public void displayLink() {
		System.out.println(id + ": " + card.toString());
	}
}

public class LinkList {

	private Link first;

	public LinkList() {
		first = null;
	}

	public Link getFirst() {
		return first;
	}

	public void insertFirst(Card card, int id) {
		Link newLink = new Link(card, id);
		newLink.next = first;
		first = newLink;
	}

	public Link find(int key) {
		Link current = first;
		while(current.id != key) {
			if(current.next == null) {
				return null;
			}
			else {
				current = current.next;
			}
		}
		return current;


	}
	
	public Link deleteFirst() {
		Link temp = first;
		if(first == null) {
			return null;
		}
		first = first.next;
		return temp;
	}
	
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while(current.id != key) {
			if(current.next == null) {
				return null;
			}
			else {
				previous = current;
				current = current.next;
			}
		}
		if(current == first) {
			first = first.next;
		}
		else {
			previous.next = current.next;
		}
		return current;
	}
	
	public void displayList() {
		System.out.println("Hand: " );
		int count = 0;
		Link current = first;
		while(current != null) {
			if(current.id == count) {
				current.displayLink();
				count++;
				current = first;
			}
			else {
				current = current.next;
			}
		}
		System.out.println("");
	}
	
	
}

