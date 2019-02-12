package dunbar.parker.csc230.grammar;

import java.util.ArrayList;
import java.util.List;

public class Verb extends Grammar {
	String string;
	
	public Verb() {}
	
	public Verb(String s) {
		this.string = s;
	}

	public List<String> verbs = new ArrayList<String>() {{
	    add("bites");
	    add("chases");
	}};
	
	public String getString() {
		return string;
	}
	
	@Override
	public String toString() {
		return "Verb " + string;
	}
}
