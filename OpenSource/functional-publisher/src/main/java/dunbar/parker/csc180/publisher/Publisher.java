package dunbar.parker.csc180.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Publisher {

	private Random generator = new Random();
	
	private List<Consumer<Integer>> subscribers = new ArrayList<>();
	
	public void subscribe(Consumer<Integer> subscriber) {
		this.subscribers.add(subscriber);
	}
	
	public void run() throws InterruptedException {
		while(true) {
			int random = (generator.nextInt(101));
			for(Consumer<Integer> s : this.subscribers) {
				s.accept(random);
			}
			Thread.sleep(2000);
		}
	}
}
