package curtis.max.csc360;

import abstractFactrorys.Component;

public abstract class HTMLComponent extends Component {

	public HTMLComponent(String contex, double top, double left, double width, double height) {
		this.setContex(contex);
		this.setHeight(height);
		this.setLeft(left);
		this.setTop(top);
		this.setWidth(width);
	}


}
