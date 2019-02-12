package dunbar.parker.csc360.pizza;

public class NYStylePizzaStore extends PizzaStore {

	@Override
	PizzaFactory createFactory() {
		return new NYStylePizzaFactory();
	}


}
