package edu.neumont.csc180.cox.regexutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegexUtility implements RegexUtility {

	public boolean isValidHumanName(String name) {
		String regex = "[A-Z][a-z]+( [A-Z]\\.?)? [A-Z][a-z]+";
		return Pattern.matches(regex, name);
	}

	public boolean isValidEmailAddress(String email) {
		String regex = ".+@.+\\.[A-Z|a-z]{3}";
		return Pattern.matches(regex, email);
	}

	public boolean isValidPhoneNumber(String phone) {
		String regex = "([0-9]?[0-9]-)?[0-9]{3}(-)?[0-9]{3}(-)?[0-9]{4}";
		return Pattern.matches(regex, phone);
	}

	public boolean isValidSSN(String ssn) {
		String regex = "[0-9]{3}-[0-9]{2}-[0-9]{4}";
		return Pattern.matches(regex, ssn);
	}

	public boolean isValidUSStreetAddress(String street) {
		String regex = "[0-9]{1,}(?: (?:N|S|E|W))? [a-zA-Z0-9]+(?: [a-zA-Z0-9]+)?(?: [a-zA-Z0-9]+)?( (?:N|S|E|W))?(?: [0-9]{1,})?\\n[a-zA-Z]{1,},(?: )?[A-Z]{2}(?:( )?\\n?)?[0-9]{5}(?:-[0-9]{4})?";
		return Pattern.matches(regex, street);
	}

	public boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower,
			int minNumeric, int minSymbols) {
		String upper = "[A-Z]";
		String lower = "[a-z]";
		String numeric = "[0-9]";
		String symbol = "[\\W]";
		int uppers = 0;
		int lowers = 0;
		int numerics = 0;
		int symbols = 0;
		
		char[] charred = password.toCharArray();
		for(int i = 0; i < charred.length; i++) {
			String character = "";
			character += charred[i];
			if(Pattern.matches(upper, character)){uppers++;}
			else if(Pattern.matches(lower, character)){lowers++;}
			else if(Pattern.matches(numeric, character)){numerics++;}
			else if(Pattern.matches(symbol, character)){symbols++;}
		}
		
		if(password.length() < minLength){
			return false;
		}
		else if(uppers<minUpper) {
			return false;
		}
		else if(lowers<minLower) {
			return false;
		}
		else if (numerics<minNumeric) {
			return false;
		}
		else if (symbols<minSymbols) {
			return false;
		}
		else {
			return true;
		}
	}

	public int countContains(String needle, String haystack) {
        int count = 0;
		String regex = needle;
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(haystack);
        while (matcher.find()) {
            count++;
        }
		return count;
	}

	public String getHTMLTagContents(String html, String tagName) {
		String rawRegex = "<" + tagName + ">(.*?)<\\/" + tagName + ">";
		Pattern p = Pattern.compile(rawRegex);
		Matcher m = p.matcher(html);
		
		if(m.find()) {
			return m.group(1);
		}
		return "Text not found";
	}

	public String[] getHTMLTagsContents(String html, String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getHTMLLinkURL(String html) {
		// TODO Auto-generated method stub
		return null;
	}

}
