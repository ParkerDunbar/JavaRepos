package dunbar.parker.csc230.grammar;

import java.util.ArrayList;
import java.util.List;

public class Noun extends Grammar {
	String string;
	
	public Noun() {}
	
	public Noun(String s) {
		this.string = s;
	}

	public List<String> nouns = new ArrayList<String>() {{
	    add("dog");
	    add("cat");
	    add("fish");
	}};
	
	public String getString() {
		return string;
	}
	
	@Override
	public String toString() {
		return "Noun " + string;
	}
}
