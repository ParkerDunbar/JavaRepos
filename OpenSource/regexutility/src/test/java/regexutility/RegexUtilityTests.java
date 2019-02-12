package regexutility;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.neumont.csc180.cox.regexutil.MyRegexUtility;
import edu.neumont.csc180.cox.regexutil.RegexUtility;

public class RegexUtilityTests {

	@Test
	public void testValidName() {
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidHumanName("Ricky Ricardo"));
	}
	
	@Test
	public void testValidEmail() {
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidEmailAddress("ParkerDunbar@Gmail.com"));
	}
	
	@Test
	public void testValidPhone() {
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidPhoneNumber("123-233-3344"));
	}
	
	@Test
	public void testValidSSN() {
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidSSN("443-12-3425"));
	}
	
	@Test
	public void testValidAddress() {
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidUSStreetAddress("5054 W Morning Lily Lane N 3432" + '\n' + "Test, UT 84081-4352"));
	}
	
	@Test
	public void testValidPassword() {
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.validatePasswordComplexity("Test12!", 1, 1, 1, 1, 1));
	}
	
	@Test
	public void testCountContains() {
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.countContains("Test", "zzzzzzzTestzzzzzzzTestzzzzzzzTestzzzzz") == 3);
	}
	
	@Test
	public void testGetHtmlTagContents() {
		RegexUtility r = new MyRegexUtility();
		String boldContents =
		r.getHTMLTagContents("<html>This is <a>text<b>My text</b>more</a>more text <b>1</b>!</html>", "b");
		assertTrue(boldContents.equals("My text"));
	}
	


}
