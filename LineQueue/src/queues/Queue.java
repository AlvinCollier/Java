package queues;

import java.util.Arrays;

public class Queue {

	private int maxSize;
	private Customer[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int size) {
		
		maxSize = size;
		queArray = new Customer[maxSize];
		for(int i = 0; i < queArray.length; i++) {
			queArray[i] = new Customer();
		}
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(Customer j) {
		
		if(rear == maxSize -1) {
			rear = -1;
		}
		queArray[++rear] = j;
		nItems++;
	}
	
	public Customer remove() {
		
		Customer temp = queArray[front++];
		if(front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	//new method added for skipping a customer who may have walked off
	//without putting the customer at the back of the line.
	public void skip() {	
		if(nItems < 2) {
			return;
		}
		Customer temp = new Customer(queArray[front].getName(), queArray[front].getPartySize());
		queArray[front] = queArray[front+1];
		queArray[front+1] = temp;
	}
	
	public Customer peekFront() {
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

	public Customer[] getQueArray() {
		return queArray;
	}

	public void setQueArray(Customer[] queArray) {
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
