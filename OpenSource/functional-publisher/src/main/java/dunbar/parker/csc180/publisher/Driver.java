package dunbar.parker.csc180.publisher;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		Publisher publisher = new Publisher();
		List<Subscriber> subscribers = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			subscribers.add(new Subscriber(i + 1));
		}
		
		for(Subscriber s : subscribers) {
			publisher.subscribe(i -> s.OnPublished(i));
		}
		
		
		publisher.run();
		
	}

}
