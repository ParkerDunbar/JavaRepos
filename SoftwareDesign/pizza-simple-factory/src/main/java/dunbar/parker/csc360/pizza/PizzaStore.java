package dunbar.parker.csc360.pizza;

abstract public class PizzaStore {

	private PizzaFactory pizzaFactory;
	
	abstract PizzaFactory createFactory();
	
	public PizzaStore() {
		this.pizzaFactory = this.createFactory();
	}
	
	public Pizza makePizza(String type) {
		return pizzaFactory.createPizza(type);
	}
	
	public void bake(Pizza p) {
		System.out.println("Baking the pizza " + p);
	}
	
	public void box(Pizza p) {
		System.out.println("Boxing the pizza " + p);
	}
	
	public void cut(Pizza p) {
		System.out.println("Cutting the pizza " + p);
	}
}