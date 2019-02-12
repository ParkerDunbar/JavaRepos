package dunbar.parker.csc250;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Knapsack {
	// C:\Users\Parker Dunbar\Downloads\knapsackTestFile1.txt
	static int maxWeight;
	static int numItems;

	static int[][] table;
	static String[] name;
	static int[] weight;
	static int[] value;

	public static void main(String[] args) throws IOException {
		String filePath = getValidFilePath();
		String[] strings = getStringsFromFile(filePath);

		maxWeight = Integer.parseInt(strings[0]);
		numItems = Integer.parseInt(strings[1]);

		name = new String[numItems];
		weight = new int[numItems];
		value = new int[numItems];

		for (int i = 2; i < strings.length; i++) {
			String[] elements = strings[i].split(",");
			name[i - 2] = elements[0];
			weight[i - 2] = Integer.parseInt(elements[1]);
			value[i - 2] = Integer.parseInt(elements[2]);
		}

		table = new int[numItems + 1][maxWeight + 1];

		for (int i = 1; i < numItems + 1; ++i) {
			Arrays.fill(table[i], -1);
		}
		for (int i = 0; i < numItems + 1; ++i) {
			table[i][0] = 0;
		}

		calc(numItems, maxWeight);
		
		//Items
		System.out.println("Items: ");
		int row = maxWeight;
		int totalWeight = 0;
		for (int i = numItems; i > 0; --i) {
			if (table[i][row] != table[i - 1][row]) {
				System.out.print(name[i - 1] + " ");
				totalWeight += weight[i - 1];
				row -= weight[i - 1];
			}
		}
		System.out.println();
		//Value
		System.out.println("Value: " + table[numItems][maxWeight]);
		//Weight
		System.out.println("Weight " + totalWeight);

		


	}

	private static int calc(int numItems, int maxWeight) {
		if (maxWeight < 0 || numItems < 0) {
			return -2;
		}

		if (table[numItems][maxWeight] != -1) {
			return table[numItems][maxWeight];
		}

		int arg1 = calc(numItems - 1, maxWeight);
		int arg2 = calc(numItems - 1, (maxWeight - weight[numItems - 1]));
		if (arg2 == -2) {
			arg2 = 0;
		} else {
			arg2 += value[numItems - 1];
		}
		table[numItems][maxWeight] = Math.max(arg1, arg2);
		return table[numItems][maxWeight];

	}

	private static String[] getStringsFromFile(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String sepString = br.readLine();
		String unsepStrings = "";
		while (sepString != null) {
			if (sepString.length() > 0 && !sepString.startsWith("//")) {
				unsepStrings += sepString;
			}
			sepString = br.readLine();
			if (sepString != null && sepString.length() > 0) {
				unsepStrings += "\n";
			}
		}
		String[] stringArray = unsepStrings.split("\n");
		return stringArray;
	}

	private static String getValidFilePath() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean notValid = true;
		String filePath = "";
		while (notValid) {
			// C:\Users\Parker Dunbar\Downloads\knapsackTestFile1.txt
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

}
