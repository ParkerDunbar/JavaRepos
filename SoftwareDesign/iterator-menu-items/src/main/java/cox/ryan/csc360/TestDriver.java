package cox.ryan.csc360;

import java.util.Iterator;

public class TestDriver {

	public static void main(String[] args) {
		Menu m = new Menu();
		
		Iterator<PrintableMenuEntry> iterator = m.getEntries().iterator();
		
		while(iterator.hasNext()) {
			iterator.next().print();
		}
	}

}
