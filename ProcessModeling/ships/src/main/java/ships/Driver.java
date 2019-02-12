package ships;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	public static final int SHIP_INSTANCES = 1000;

	public static void main(String[] args) {
		List<Ship> ships = new ArrayList<>();
		for(int i=0; i<SHIP_INSTANCES; i++) {
			ships.add(new Ship());
		}
		
		for(Ship s : ships) {
			s.start();
		}
	}

}
