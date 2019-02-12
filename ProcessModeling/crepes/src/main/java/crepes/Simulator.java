package crepes;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
	public static final int COUNT_CREPISTAS = 2;
	public static final int CREPES_PER_SHIFT = 100;
	
	public static void main(String[] args) {
		List<Crepista> crepistas = new ArrayList<>();
		for(int i=0; i<COUNT_CREPISTAS; i++) {
			crepistas.add(new Crepista());
		}
		
		for(Crepista c : crepistas) {
			c.start();
		}
	}

	
}
