package curtis.max.csc360;

import abstractFactrorys.Component;
import abstractFactrorys.ComponentFactory;

public class HTMLComponentFactory extends ComponentFactory {

	@Override
	public Component creatComponet(String type, String contex, double top, double left, double width, double height) {
		if (type.equalsIgnoreCase("Button")) {
			return new HTMLButton(contex, top, left, width, height);
		} else if (type.equalsIgnoreCase("Label")) {
			return new HTMLLabel(contex, top, left, width, height);
		} else if (type.equalsIgnoreCase("TextField")) {
			return new HTMLTextField(contex, top, left, width, height);
		} else if (type.equalsIgnoreCase("H1Tag")) {
			return new HTMLH1Tag(contex, top, left, width, height);
		} else {
			throw new IllegalArgumentException(type + " is not a supported type");
		}
	}
}
