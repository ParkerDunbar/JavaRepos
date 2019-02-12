package cox.ryan.csc360;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListIterator<T> implements MyIterator<T> {
	
	private List<T> list;
	
	private int index = 0;
	
	public MyArrayListIterator(List<T> list) {
		this.setList(list);
	}

	public boolean hasNext() {
		return index < list.size() - 1;
	}

	public T next() {
		return list.get(index++);
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	
}
