package dunbar.parker.csc360.pizza;

public class ChicagoStylePizzaStore extends PizzaStore {

	@Override
	PizzaFactory createFactory() {
		return new ChicagoStylePizzaFactory();
	}

}
