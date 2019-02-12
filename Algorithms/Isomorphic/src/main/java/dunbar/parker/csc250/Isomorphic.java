package dunbar.parker.csc250;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Isomorphic {
	public static Map<String, List<String>> exact = new HashMap<String, List<String>>();
	public static Map<String, List<String>> loose = new HashMap<String, List<String>>();
	public static List<List<String>> non = new ArrayList<List<String>>();

	public static void main(String[] args) throws IOException {
		String filePath = getValidFilePath();
		String[] strings = getStringsFromFile(filePath);
		for (int i = 0; i < strings.length; i++) {
			sortExact(strings[i]);
			sortLoose(strings[i]);
		}
		System.out.println("Exact Isomorphs");
		for (Map.Entry entry : exact.entrySet()) {
			if (exact.get(entry.getKey()).size() != 1) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			} else {
				non.add((List<String>) entry.getValue());
			}

		}

		System.out.println("Loose Isomorphs");
		for (Map.Entry entry : loose.entrySet()) {
			if (loose.get(entry.getKey()).size() != 1) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			else {
				if(!non.contains(entry.getValue())) {
					non.add((List<String>) entry.getValue());
				}
			}
		}
		
		System.out.println("Non Isomorphs");
		for(int i = 0; i < non.size(); i ++) {
			System.out.println(non.get(i));
		}
	}

	private static String getValidFilePath() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean notValid = true;
		String filePath = "";
		while (notValid) {
			// C:\Users\Parker Dunbar\Downloads\IsomorphInput1.txt
			System.out.println("Please enter a valid file path:");
			filePath = reader.readLine();
			File input = new File(filePath);
			if (input.exists() && !input.isDirectory()) {
				notValid = false;
			} else {
				System.out.println("Not a valid file path.");
			}
		}
		return filePath;
	}

	private static String[] getStringsFromFile(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String sepString = br.readLine();
		String unsepStrings = "";
		while (sepString != null) {
			unsepStrings += sepString;
			unsepStrings += "\n";
			sepString = br.readLine();
		}
		String[] stringArray = unsepStrings.split("\n");
		return stringArray;
	}

	private static void sortExact(String string) {
		String keys = "";
		List<String> empty = new ArrayList<>();
		char ph;
		int key = -1;
		Map<Character, Integer> checked = new HashMap<Character, Integer>();
		for (int i = 0; i < string.length(); i++) {
			ph = string.charAt(i);
			if (checked.containsKey(ph)) {
				key = checked.get(ph);
				keys += key;
			} else {
				key++;
				checked.put(ph, key);
				keys += key;
			}
			if (i != string.length() - 1) {
				keys += " ";
			}
		}

		if (exact.containsKey(keys)) {
			exact.get(keys).add(string);
		} else {
			exact.put(keys, empty);
			exact.get(keys).add(string);
		}
	}

	private static void sortLoose(String string) {
		List<String> empty = new ArrayList<>();
		List<Character> checked = new ArrayList<>();
		List<Integer> unsortedKeys = new ArrayList<>();
		char ph;
		int count;
		for (int i = 0; i < string.length(); i++) {
			count = 0;
			ph = string.charAt(i);
			if (!checked.contains(ph)) {
				checked.add(ph);
				for (int j = 0; j < string.length(); j++) {
					if (ph == string.charAt(j)) {
						count++;
					}
				}
			}
			unsortedKeys.add(count);
		}
		Collections.sort(unsortedKeys);
		String keys = "";
		for (int i = 0; i < unsortedKeys.size(); i++) {
			keys += unsortedKeys.get(i);
			if (i != unsortedKeys.size() - 1) {
				keys += " ";
			}
		}

		if (loose.containsKey(keys)) {
			loose.get(keys).add(string);
		} else {
			loose.put(keys, empty);
			loose.get(keys).add(string);
		}
	}
}
