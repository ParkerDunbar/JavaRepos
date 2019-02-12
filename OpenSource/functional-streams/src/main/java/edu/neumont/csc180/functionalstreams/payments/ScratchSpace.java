package edu.neumont.csc180.functionalstreams.payments;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScratchSpace {

	public static void main(String[] args) throws FileNotFoundException {
		List<Transaction> transactions = TransactionFactory.generateRandomTransactions(100);
		
		TransactionLog log = new TransactionLog();
		
		log.subscribe(l -> m -> a -> {
			System.out.println("Timestamp: " + l);
			System.out.println("Merchant: " + m);
			System.out.println("Amount: " + a);
			return true;
		});
		
		transactions.stream().forEach(t -> log.add(t));
		
		
		Double maybeAverage = transactions.stream().mapToDouble(t -> t.getAmount()).average().orElse(0);
		
		try(PrintWriter out = new PrintWriter(new FileOutputStream("my.csv"))) {
			out.println(transactions.stream()
					.filter(t -> t.getMerchant().length() > 4)
					.filter(t -> t.getAmount() > transactions.stream()
							.mapToDouble(t1 -> t1.getAmount()).average().orElse(0))
					);
		}
		
//		List<PaymentCard> cards = transactions.stream()
//				.filter(t -> t.getAmount() > 150 && t.getMerchant().equals("Wendys"))
//				.map(t -> t.getCard())
//				.collect(Collectors.toList());
//		
//		cards.stream().forEach(c -> System.out.println(c));

//		for (Transaction t : transactions) {
//			System.out.println(t);
//		}
	}
}

// transactions.sort(new Comparator<Transaction>() {
// @Override
// public int compare(Transaction o1, Transaction o2) {
// return Double.compare(o1.getAmount(), o2.getAmount());
// }
// });

// Ascending by Price
//transactions = transactions.stream()
//.sorted((o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount()))
//.collect(Collectors.toList());

// Descending by Price
// transactions = transactions.stream()
// .sorted((o1, o2) -> Double.compare(o2.getAmount(), o1.getAmount()))
// .collect(Collectors.toList());

// Ascending by Name
// transactions = transactions.stream().sorted((o1, o2) ->
// o1.getMerchant().compareTo(o2.getMerchant()))
// .collect(Collectors.toList());

//List<PaymentCard> cards = transactions.stream()
//.map(t -> t.getCard())
//.collect(Collectors.toList());
