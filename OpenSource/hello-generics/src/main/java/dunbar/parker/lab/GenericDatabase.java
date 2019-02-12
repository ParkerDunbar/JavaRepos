package dunbar.parker.lab;

public class GenericDatabase<T extends DatabaseStorable> {
	
	public int insert(T c) {
		String data = c.serialize();
		return 0;
	}
	
	public T lookup(int index) {
		return null;
	}
}
