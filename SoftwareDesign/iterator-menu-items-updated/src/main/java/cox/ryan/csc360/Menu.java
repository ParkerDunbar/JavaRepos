package cox.ryan.csc360;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends PrintableMenuEntry {
	
	private List<PrintableMenuEntry> entries = new ArrayList<>();

	public List<PrintableMenuEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<PrintableMenuEntry> entries) {
		this.entries = entries;
	}

	@Override
	protected Iterator<PrintableMenuEntry> childIterator() {
		return entries.iterator();
	}
}
