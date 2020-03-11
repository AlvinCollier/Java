//Alvin Collier
//4.26.2018
//final project
//colorCards

package colorCards;

import java.util.Arrays;

public class Queue {

	private int maxSize;
	private Card[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int size) {
		
		maxSize = size;
		queArray = new Card[maxSize];
		for(int i = 0; i < queArray.length; i++) {
			queArray[i] = new Card(0 , null);
		}
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(Card j) {
		
		if(rear == maxSize -1) {
			rear = -1;
		}
		queArray[++rear] = j;
		nItems++;
	}
	
	public Card remove() {
		
		Card temp = queArray[front++];
		//System.out.println(temp.toString());
		if(front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public void skip() {	
		if(nItems < 2) {
			return;
		}
		Card temp = new Card(queArray[front].getNumber(), queArray[front].getColor());
		queArray[front] = queArray[front+1];
		queArray[front+1] = temp;
	}
	
	public Card peekFront() {
		return queArray[front];
	}
	
	public boolean isEmpty() {
		return(nItems==0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public int size() {
		return nItems;
	}
	

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public Card[] getQueArray() {
		return queArray;
	}

	public void setQueArray(Card[] queArray) {
		this.queArray = queArray;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public int getnItems() {
		return nItems;
	}

	public void setnItems(int nItems) {
		this.nItems = nItems;
	}

	@Override
	public String toString() {
		return "Queue [maxSize=" + maxSize + ", queArray=" + Arrays.toString(queArray) + ", front=" + front + ", rear="
				+ rear + ", nItems=" + nItems + "]";
	}
	
	
}
