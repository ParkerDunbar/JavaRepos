package dunbar.parker.csc180.httpconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
	int con = 0;
	ArrayList<String> Everything = new ArrayList<String>();
	ArrayList<String> visitedSites = new ArrayList<String>();
	static String URL;

	public void URLtoString(String rawurl) throws IOException {
		boolean visited = false;
		for (int i = 0; i < visitedSites.size(); i++) {
			if (visitedSites.get(i).trim().equals(rawurl.trim())) {
				visited = true;
			}
		}
		if (!visited) {
			URL url = new URL(rawurl);
			String line = "";
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			try (InputStream in = con.getInputStream()) {
				try (BufferedReader inReader = new BufferedReader(new InputStreamReader(in))) {
					while (inReader.ready()) {
						line += inReader.readLine();
					}
					ArrayList<String> words = parseStringURL(line);
					ArrayList<String> links = new ArrayList<String>();
					boolean endOfLinks = false;
					for (int i = 0; i < words.size(); i++) {
						while (!endOfLinks) {
							if (words.get(i) == "EndOfLinks") {
								endOfLinks = true;
								words.remove(i);
							} else {
								links.add(words.remove(i));
							}
						}
					}
					while (words.contains("")) {
						for (int i = words.size() - 1; i >= 0; i--) {
							if (words.get(i).equals("") || Pattern.matches("&[a-z]+;", words.get(i))) {
								words.remove(i);
							}
						}
					}
					for (int i = links.size() - 1; i >= 0; i--) {
						if (Pattern.matches(".*\\.css(?:\\?.*)?", links.get(i))
								|| Pattern.matches(".*\\.png.*", links.get(i))
								|| Pattern.matches(".*\\.rss.*", links.get(i))
								|| Pattern.matches(".*\\.ico.*", links.get(i))
								|| Pattern.matches("tel:.*", links.get(i)) || Pattern.matches("mailto:.*", links.get(i))
								|| Pattern.matches("#.*", links.get(i)) || Pattern.matches("", links.get(i))
								|| Pattern.matches("\\/\\/((?:[a-z|A-Z|0-9]+\\.)*\\.[a-z|A-Z|0-9]+\\.[a-z|A-Z]+\\/?).*",
										links.get(i))
								|| Pattern.matches("android-app:.*", links.get(i))
								|| Pattern.matches("ios-app:.*", links.get(i))
								|| Pattern.matches(".*\\.php.*", links.get(i))
								|| Pattern.matches(".*javascript:void(0)", links.get(i))
								|| Pattern.matches(".*neumont(?:(?:university)|U).*", links.get(i))){
							links.remove(i);
						}
					}
					Everything.add(rawurl);
					Everything.addAll(words);
					visitedSites.add(rawurl);
					for (int i = 0; i < Everything.size(); i++) {
						System.out.println(Everything.get(i));
					}
					String hold = URL + ".*";
					if (Pattern.matches(hold, rawurl)) {
						nextHop(links, rawurl);
					}
				}
			}
		}
	}

	private ArrayList<String> parseStringURL(String stringURL) {
		stringURL = stringURL.replace("\n", "").replace("\r", "").trim();

		ArrayList<String> TheGoods = new ArrayList<String>();
		String hrefRegex = "href=\"(.*?)\"";
		String altRegex = "alt=\"(.*?)\"";
		String bodyTagRegex = "<body[=| -;|\\?-~|]*>([ -;|\\?-~]*)<.*>";
		String bodyOfATagRegex = "<(?:p|(?:span)|(?:div)|(?:li)|(?:label)|(?:option)|a|(?:td)|(?:th)|(?:font)|(?:title)|b|i|u)[=| -;|\\?-~|]*>([ -;|\\?-~]*)<\\/(?:|p|(?:span)|(?:div)|(?:li)|(?:label)|(?:option)|a|(?:td)|(?:th)|(?:font)|(?:title)|b|i|u)>";

		Pattern phr = Pattern.compile(hrefRegex);
		Pattern par = Pattern.compile(altRegex);
		Pattern pbtr = Pattern.compile(bodyTagRegex);
		Pattern pboatr = Pattern.compile(bodyOfATagRegex);

		Matcher mhr = phr.matcher(stringURL);
		Matcher mar = par.matcher(stringURL);
		Matcher mboatr = pboatr.matcher(stringURL);
		Matcher mbtr = pbtr.matcher(stringURL);

		while (mhr.find()) {
			String splitContents = mhr.group(1);
			TheGoods.add(splitContents);
		}
		TheGoods.add("EndOfLinks");
		while (mbtr.find()) {
			String[] splitContents = mbtr.group(1).trim().split(" ");
			for (int i = 0; i < splitContents.length; i++) {
				TheGoods.add(splitContents[i]);
			}
		}

		while (mar.find()) {
			String[] splitContents = mar.group(1).trim().split(" ");
			for (int i = 0; i < splitContents.length; i++) {
				TheGoods.add(splitContents[i]);
			}
		}

		while (mboatr.find()) {
			String[] splitContents = mboatr.group(1).trim().split(" ");
			for (int i = 0; i < splitContents.length; i++) {
				TheGoods.add(splitContents[i]);
			}
		}

		return TheGoods;
	}

	private void nextHop(ArrayList<String> links, String URL) throws IOException {
		String Hold = "";
		String rawRegex = "[a-z|A-Z|\\/|:]+\\/((?:[a-z|A-Z|0-9]+\\.)*[a-z|A-Z|0-9]+\\.[a-z|A-Z]+\\/?)(?<!\\.html|html|htm|ht|h).*";
		Pattern p = Pattern.compile(rawRegex);
		Matcher m = p.matcher(URL);
		String baseURL = "";

		if (m.find()) {
			baseURL = m.group(1);
			if (!baseURL.endsWith("/")) {
				baseURL += "/";
			}
		}
		boolean visited = false;
		for (int j = 0; j < visitedSites.size(); j++) {
			for (int k = 0; k < links.size(); k++) {
				if (visitedSites.get(j).trim().equals(links.get(k).trim())) {
					visited = true;
				}
			}
		}
		if (!visited) {
			if (links.size() != 0) {
				for (int i = 0; i < links.size(); i++) {
					if (!links.get(i).equals("/")) {
						while (links.get(i).toCharArray()[0] == '/' || links.get(i).toCharArray()[0] == '.') {
							char[] hey = links.get(i).toCharArray();
							for (int j = 0; j < (hey.length - 1); j++) {
								hey[j] = hey[j + 1];
							}
							hey[hey.length - 1] = ' ';
							String toString = "";
							for (int j = 0; j < hey.length; j++) {
								toString += hey[j];
							}
							links.set(i, toString.trim());
						}
					}
					if (!Pattern.matches(rawRegex, links.get(i))) {
						Hold = ("https://" + baseURL + links.get(i));
					} else {
						Hold = links.get(i);
					}
					String hold = URL + ".*";
					if(Pattern.matches(hold, URL)) {
						URLtoString(Hold);
					}
					
				}
			}
		}
	}

	private void localParse() {
	}

	private void serailizedURLindex(String[] tages) {

	}
}