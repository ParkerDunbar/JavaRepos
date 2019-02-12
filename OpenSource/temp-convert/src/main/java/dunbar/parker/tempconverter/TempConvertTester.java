package dunbar.parker.tempconverter;

public class TempConvertTester {

	public static void main(String[] args) {
		TempConvert t = new TempConvert();
		double result = t.ftoc(100);
		if(result != 0) {
			System.out.println("Expected 0; but got " + result); 
		}
		else {
			System.out.println("Passed");
		}

	}

}
