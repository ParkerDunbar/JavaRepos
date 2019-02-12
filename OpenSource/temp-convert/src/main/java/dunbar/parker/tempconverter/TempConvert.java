package dunbar.parker.tempconverter;

public class TempConvert {

	public double ftoc(double f) {
		return (f - 32) * (5.0 / 9);
	}
	
	public double ctof(double c) {
		return c * (9.0 / 5) + 32;
	}
}
