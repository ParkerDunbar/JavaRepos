package curtis.max.csc360;

public class HTMLH1Tag extends HTMLComponent {

	public HTMLH1Tag(String contex, double top, double left, double width, double height) {
		super(contex, top, left, width, height);
	}

	@Override
	public String generateCode() {
		return "<H1 style=\"width:" + this.getWidth()
				+ "px;height:"+this.getHeight()+"px; margin-top:"+this.getTop()+"px; margin-left:"+this.getLeft()+"px\">"+this.getContex()+"</H1>";
	}

}