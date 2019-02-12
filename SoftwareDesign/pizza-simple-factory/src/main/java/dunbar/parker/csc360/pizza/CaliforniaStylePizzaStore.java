package dunbar.parker.csc360.pizza;

public class CaliforniaStylePizzaStore extends PizzaStore {

	@Override
	PizzaFactory createFactory() {
		return new CaliforniaStylePizzaFactory();
	}


}
