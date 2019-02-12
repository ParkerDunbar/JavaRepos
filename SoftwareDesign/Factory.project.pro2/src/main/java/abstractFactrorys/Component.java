package abstractFactrorys;

public abstract class Component {

	private String contex;
	private double top;
	private double left;
	private double width;
	private double height;

	abstract public String generateCode();

	public String getContex() {
		return contex;
	}

	public void setContex(String contex) {
		this.contex = contex;
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

}
