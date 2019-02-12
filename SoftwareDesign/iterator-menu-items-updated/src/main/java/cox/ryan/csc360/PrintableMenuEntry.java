package cox.ryan.csc360;

import java.util.Iterator;

abstract public class PrintableMenuEntry {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	abstract protected Iterator<PrintableMenuEntry> childIterator();

	public void print() {
		System.out.println(this.getName() + "\r\n--------------------------\r\n");
		
//		this.entries.sort((l,r) -> (l instanceof Item ? -1 : 1));
		Iterator<PrintableMenuEntry> entryIterator = childIterator();// this.entries.iterator();
		
		while(entryIterator.hasNext()) {
			entryIterator.next().print();
		}
	}
}
