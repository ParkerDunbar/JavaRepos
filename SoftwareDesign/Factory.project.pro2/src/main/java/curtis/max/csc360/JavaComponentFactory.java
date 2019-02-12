package curtis.max.csc360;

import abstractFactrorys.Component;
import abstractFactrorys.ComponentFactory;

public class JavaComponentFactory extends ComponentFactory {

	@Override
	public Component creatComponet(String type, String contex, double top, double left, double width, double height) {
		if (type.equalsIgnoreCase("Button")) {
			return new JavaButton(contex, top, left, width, height);
		} else if (type.equalsIgnoreCase("Label")) {
			return new JavaLabel(contex, top, left, width, height);
		} else {
			throw new IllegalArgumentException(type + " is not a supported type");
		}
	}
}
