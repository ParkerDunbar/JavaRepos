package dunbar.parker.csc180.bingo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

public class BingoCaller {
	private Random generator = new Random();
	private boolean game = false;
	private Map<Integer, Consumer<Integer>> subscribers = new HashMap<Integer, Consumer<Integer>>();
	private int nextId = 1;
	
	
	public int subscribe(Consumer<Integer> sub) {
		subscribers.put(nextId, sub);
		return nextId++;
	}
	
	public void unsubscribe(int id) {
		subscribers.remove(id);
	}
	
	public void run() throws InterruptedException {
		BingoSimulator b = new BingoSimulator();
		b.run();
		while(!game) {
			int random = (generator.nextInt(99) + 1);
			for(Consumer<Integer> c : subscribers.values()) {
				c.accept(random);
				if(game) {
					break;
				}
			}
			System.out.println("Caller: " + random);
			Thread.sleep(4000);
		}
	}
	
	public void handleWinner(int id, String name) {
		System.out.println(id + name);
		game = true;
	}
}
