package dunbar.parker.csc180.bingo;

import java.util.function.BiConsumer;

public class BingoPlayer {
	private String name;
	private BingoCard card;
	private int id;
	private BiConsumer<Integer, String> winNotifier;
	
	public BingoPlayer() {}
	
	public BingoPlayer(String name, BingoCard card) {
		this.setName(name);
		this.setCard(card);
	}
	
	public void subscribe(BiConsumer<Integer, String> sub) {
		winNotifier = sub;
	}
	
	public void onNewNumberAnnounced(Integer i) {
		System.out.println("new number " + i);
		//if(won) {
		if(winNotifier != null) {
			winNotifier.accept(this.getId(), this.getName());
		}
		//}
	}
	
	public void OnPublished(int value) {
		System.out.println("Player received " + value);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BingoCard getCard() {
		return card;
	}
	public void setCard(BingoCard card) {
		this.card = card;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
