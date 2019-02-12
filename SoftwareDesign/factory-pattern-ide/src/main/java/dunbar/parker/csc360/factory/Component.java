package dunbar.parker.csc360.factory;

abstract public class Component {

	private LanguageEnum lang;
	private String content;
	private double width;
	private double height;
	private double top;
	private double left;
	

	public LanguageEnum getLang() {
		return lang;
	}
	public void setLang(LanguageEnum l) {
		this.lang = l;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getTop() {
		return top;
	}
	public void setTop(double top) {
		this.top = top;
	}
	public double getLeft() {
		return left;
	}
	public void setLeft(double left) {
		this.left = left;
	}
	
	abstract public String makeComponent(String content, double width, double height, double top, double left);
	
}
