package curtis.max.csc360;

public class HTMLButton extends HTMLComponent {

	public HTMLButton(String contex, double top, double left, double width, double height) {
		super(contex, top, left, width, height);
	}

	@Override
	public String generateCode() {
		return "<button style=\"width:" + this.getWidth()
				+ "px;height:"+this.getHeight()+"px; margin-top:"+this.getTop()+"px; margin-left:"+this.getLeft()+"px\">"+this.getContex()+"</button>";
	}

}
