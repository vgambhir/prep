package apple.twitter;

public class EmailSubsciber implements Subscriber{

	String name;
	
	@Override
	public void subscribe() {
		System.out.println("Received message");
		
	}

}
