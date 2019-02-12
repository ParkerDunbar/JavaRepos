package crepes;

import java.time.LocalDateTime;

public class Crepista extends Thread {

	@Override
	public void run() {
		for(int i=0; i<Simulator.CREPES_PER_SHIFT; i++) {
			System.out.println("Crepista #" + this.getId() + " made a crepe at " + LocalDateTime.now());
		}
	}	
}
