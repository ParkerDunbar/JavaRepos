package dunbar.parker.tempconverter.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dunbar.parker.tempconverter.TempConvert;

public class FarenheitTests {

	@Test
	public void test32Farenheit() {
		TempConvert t = new TempConvert();
		assertEquals(0, t.ftoc(32), 0);
	}
	
	@Test
	public void testNeg40() {
		TempConvert t = new TempConvert();
		assertEquals(-40, t.ftoc(-40), 0);
	}

}
