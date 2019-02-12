package dunbar.parker.csc360.factory;

public class HTMLButton extends Component {

	@Override
	public String makeComponent(String content, double width, double height, double top, double left) {
		return "<button></button>";
	}

}
