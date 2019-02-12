package edu.neumont.csc180.functionalstreams.payments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TransactionFactory {
	
	private static List<String> merchants = Arrays.asList(
		"Wal-mart",
		"Target",
		"Nordstrom",
		"Amazon",
		"E-Bay",
		"Harmons",
		"Neumont Gear Store",
		"Rocky Mountain Power",
		"Qwestar Gas",
		"Comcast",
		"Wendys",
		"Chick-fil-a"
	);
	
	private static Random generator = new Random();

	public static List<Transaction> generateRandomTransactions(int count) {
		List<Transaction> transactions = new ArrayList<>();
		for(int i=0;i<count;i++) {
			transactions.add(generateRandomTransaction());
		}
		return transactions;
	}
	
	public static Transaction generateRandomTransaction() {
		
		double amount = generator.nextDouble() * generator.nextInt(100) + 100;
		String merchant = merchants.get(generator.nextInt(merchants.size()));
		String cardNumber = "4";
		for(int i=0;i<15;i++) {
			cardNumber += generator.nextInt(10);
		}
		return new Transaction(merchant, amount, new PaymentCard(cardNumber));
	}
}
