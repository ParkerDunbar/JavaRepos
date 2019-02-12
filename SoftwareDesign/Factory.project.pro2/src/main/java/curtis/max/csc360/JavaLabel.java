package curtis.max.csc360;


public class JavaLabel extends JavaComponent {
	
	public JavaLabel(String contex, double top, double left, double width, double height) {
		super(contex, top, left, width, height);
	}

	@Override
	public String generateCode() {
		return "<Label layoutX=\"" + this.getLeft() + "\" layoutY=\"" + this.getTop()
		+ "\" prefHeight=\"" + this.getHeight() + "\" prefWidth=\"" + this.getWidth()
		+ "\" text=\"" + this.getContex() + "\" />";
	}

}
