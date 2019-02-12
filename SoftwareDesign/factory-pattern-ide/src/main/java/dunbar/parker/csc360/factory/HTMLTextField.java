package dunbar.parker.csc360.factory;

public class HTMLTextField extends Component {

	@Override
	public String makeComponent(String content, double width, double height, double top, double left) {
		return "<TextField></TextField>";
	}

}
