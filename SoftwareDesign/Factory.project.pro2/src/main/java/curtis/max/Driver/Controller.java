package curtis.max.Driver;

import abstractFactrorys.Component;
import abstractFactrorys.ComponentFactory;

public abstract class Controller {

	private static ComponentFactory componentFactory;

	abstract ComponentFactory createFacroty();

	public Controller() {
		componentFactory = this.createFacroty();
	}

	public static Component makeComponent(String type, String contex, double top, double left, double width,
			double height) {
		return componentFactory.creatComponet(type, contex, top, left, width, height);
	}

	public static void printComponent(Component c) {
		System.out.println(c.generateCode());
	}

}
