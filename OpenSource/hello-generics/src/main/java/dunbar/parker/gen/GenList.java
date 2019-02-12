package dunbar.parker.gen;

public class GenList<T> {
	private Object[] guts;
	
	private int nextIndex;
	
	public GenList() {
		guts = new Object[10];
		nextIndex = 0;
	}
	
	public void add(T i) {
		if(nextIndex >= guts.length) {
			upsize();
		}
		guts[nextIndex] = i;
		nextIndex++;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int i) {
		return (T) guts[i];
	}
	
	public void remove(int i) {
		for(int c = i; c < nextIndex - 1; c++) {
			guts[c] = guts[c + 1];
		}
		nextIndex--;
	}
	
	public void upsize() {
		Object[] newGuts = new Object[guts.length * 2];
		for(int i = 0; i < guts.length; i++) {
			newGuts[i] = guts[i];
		}
		guts = newGuts;
	}
}
