package curtis.max.csc360;

public class HTMLTextField extends HTMLComponent {

	public HTMLTextField(String contex, double top, double left, double width, double height) {
		super(contex, top, left, width, height);
	}

	@Override
	public String generateCode() {
		return "<TextBox style=\"width:" + this.getWidth()
				+ "px;height:"+this.getHeight()+"px; margin-top:"+this.getTop()+"px; margin-left:"+this.getLeft()+"px\">"+this.getContex()+"</TextBox>";
	}

}