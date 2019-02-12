package dunbar.parker.csc230.grammar;

import java.util.ArrayList;
import java.util.List;

public class Preposition extends Grammar {
	String string;
	
	public Preposition() {}
	
	public Preposition(String s) {
		this.string = s;
	}

	public List<String> prepostions = new ArrayList<String>() {{
	    add("with");
	}};
	
	public String getString() {
		return string;
	}
	
	@Override
	public String toString() {
		return "Preposition " + string;
	}
}
