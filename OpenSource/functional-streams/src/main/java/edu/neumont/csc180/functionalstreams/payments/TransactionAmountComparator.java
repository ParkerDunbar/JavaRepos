package edu.neumont.csc180.functionalstreams.payments;

import java.util.Comparator;

public class TransactionAmountComparator implements Comparator<Transaction>{

	@Override
	public int compare(Transaction o1, Transaction o2) {
		return Double.compare(o1.getAmount(), o2.getAmount());
	}
	
}
