package cox.ryan.csc360;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu implements PrintableMenuEntry {
	
	private String name;

	private List<PrintableMenuEntry> entries = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PrintableMenuEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<PrintableMenuEntry> entries) {
		this.entries = entries;
	}

	public void print() {
		System.out.println(this.getName() + "\r\n--------------------------\r\n");
		
		this.entries.sort((l,r) -> (l instanceof Item ? -1 : 1));
		Iterator<PrintableMenuEntry> entryIterator = this.entries.iterator();
		
		while(entryIterator.hasNext()) {
			entryIterator.next().print();
		}
	}
}
