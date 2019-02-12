package dunbar.parker.csc360.factory;

public class HTMLH1Tag extends Component {

	@Override
	public String makeComponent(String content, double width, double height, double top, double left) {
		return "<H1></H1>";
	}

}
