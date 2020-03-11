package queues;

public class QueueApp {

	public static void main(String[] args) {
		
		Queue custQue = new Queue(5);
		
		custQue.insert(new Customer());

		System.out.println(custQue.toString());
	}

}
