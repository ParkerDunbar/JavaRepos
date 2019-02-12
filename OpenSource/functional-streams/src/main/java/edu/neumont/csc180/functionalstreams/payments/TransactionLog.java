package edu.neumont.csc180.functionalstreams.payments;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class TransactionLog extends ArrayList<Transaction> {
	private static final long serialVersionUID = 1L;
	
//	private List<Consumer<Transaction>> subscribers = new ArrayList<>();
	
	public interface NotificationFunction extends Function<LocalDateTime, Function<String, Function<Double, Boolean>>> {
		
	}
	
	private List<NotificationFunction> subscribers = new ArrayList<>();
	
	public void subscribe(NotificationFunction subscriber) {
		this.subscribers.add(subscriber);
	}
	
	@Override
	public boolean add(Transaction t) {
		subscribers.stream().forEach(s -> s.apply(t.getTimestamp()).apply(t.getMerchant()).apply(t.getAmount()));
		return super.add(t);
	}

}
