package dunbar.parker.csc252;

import java.util.ArrayList;
import java.util.List;

public class Node {
	String element;
	List<Node> connections = new ArrayList<Node>();
	
	Node(String element) {
		this.element = element;
	}
}
