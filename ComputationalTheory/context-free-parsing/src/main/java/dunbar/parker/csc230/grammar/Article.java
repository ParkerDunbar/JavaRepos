package dunbar.parker.csc230.grammar;

import java.util.ArrayList;
import java.util.List;

public class Article extends Grammar {
	String string;
	
	public Article() {}
	
	public Article(String s) {
		this.string = s;
	}
	
	public List<String> articles = new ArrayList<String>() {{
	    add("a");
	    add("the");
	}};
	
	public String getString() {
		return string;
	}
	
	@Override
	public String toString() {
		return "Article " + string;
	}

}
