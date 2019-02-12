package dunbar.parker.csc180.bingo;

import java.util.ArrayList;
import java.util.List;

public class BingoSimulator {
	
	public void run() {
		BingoCaller caller = new BingoCaller();
		List<BingoPlayer> players = new ArrayList<>();
		for(int i=0; i<30; i++) {
			BingoPlayer p = new BingoPlayer("Name", new BingoCard());
			players.add(p);
			p.setId(caller.subscribe(num -> p.onNewNumberAnnounced(num)));
			p.subscribe((id, name) -> caller.handleWinner(id, name));
			//caller.unsubscribe(p.getId);
		}
	}
}
