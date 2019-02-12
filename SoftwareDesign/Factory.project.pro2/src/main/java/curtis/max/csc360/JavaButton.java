package curtis.max.csc360;

public class JavaButton extends JavaComponent {

	public JavaButton(String contex, double top, double left, double width, double height) {
		super(contex, top, left, width, height);
	}

	@Override
	public String generateCode() {
		return "<Button layoutX=\"" + this.getLeft() + "\" layoutY=\"" + this.getTop()
				+ "\" mnemonicParsing=\"false\" prefHeight=\"" + this.getHeight() + "\" prefWidth=\"" + this.getWidth()
				+ "\" text=\"" + this.getContex() + "\" />";
	}
}
