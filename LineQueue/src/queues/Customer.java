package queues;

public class Customer {

	private String name;
	private int partySize;
	
	public Customer() {
		name = "Customer";
		partySize = 2;
	}
	
	public Customer(String name, int partySize) {
		this.name = name;
		this.partySize = partySize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPartySize() {
		return partySize;
	}

	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}

	@Override
	public String toString() {
		return  name + ", party of " + partySize;
	}
	
	
	
}
