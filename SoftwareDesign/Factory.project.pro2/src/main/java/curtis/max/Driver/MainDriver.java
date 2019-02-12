package curtis.max.Driver;

import abstractFactrorys.Component;
import curtis.max.csc360.HTMLComponentFactory;

public class MainDriver {

	public static void main(String[] args) {
		HTMLComponentFactory h = new HTMLComponentFactory();
		 Component t = h.creatComponet("Button", "hello", 0, 0, 0, 0);
		

//		Component temp = Controller.makeComponent();
		Controller.printComponent(t);
	}
}
