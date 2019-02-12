package cox.ryan.csc360;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDriver {

	public static void main(String[] args) {
		Menu m = new Menu();
		
		m.setName("Breakfast");
		List<PrintableMenuEntry> test = new ArrayList<>(); 
		Item testItem = new Item();
		testItem.setName("Item");
		test.add(testItem);
		m.setEntries(test);
		
		Iterator<PrintableMenuEntry> iterator = m.getEntries().iterator();
		
		while(iterator.hasNext()) {
			iterator.next().print();
		}
	}

}
