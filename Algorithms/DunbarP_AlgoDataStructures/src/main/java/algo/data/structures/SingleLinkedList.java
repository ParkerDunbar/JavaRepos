package algo.data.structures;

public class SingleLinkedList<T> {
	int count = 0;
	SingleNode<T> head;

	public void add(T val) {
		if (head != null) {
			SingleNode<T> newNode = new SingleNode<T>(val);
			SingleNode<T> end = head;
			while (end.next != null) {
				end = end.next;
			}
			end.next = newNode;
		} else {
			head = new SingleNode<T>(val);
		}
		count++;
	}

	public void insert(T val, int index) {
		if (index >= 0 && index < count && head != null) {
			SingleNode<T> newNode = new SingleNode<T>(val);
			SingleNode<T> placeholder = head;
			SingleNode<T> prev = null;
			for (int i = 0; i < index; i++) {
				prev = placeholder;
				placeholder = placeholder.next;
			}
			if (index == 0) {
				newNode.next = head;
				head = newNode;
			} else {
				prev.next = newNode;
				newNode.next = placeholder;
			}
			count++;
		} else {
			throw new IndexOutOfBoundsException("Invalid Index: Out of bounds");
		}
	}


	public int count() {
		return count;
	}

	public T get(int index) {
		if(index >= 0 && index < count && head != null) {
			SingleNode<T> placeholder = head;
			for(int i = 0; i < index; i++ ) {
				placeholder = placeholder.next;
			}
			return placeholder.val;
		}
		else {
			throw new IndexOutOfBoundsException("Invalid Index: Out of bounds");
		}
	}

	public T remove() {
		T valRemoved = null;
		if (head != null) {
			valRemoved = head.val;
			head = head.next;
			count--;
		}
		return valRemoved;
	}

	public T removeAt(int index) {
		if (index >= 0 && index < count && head != null) {
			T valRemoved = null;
			SingleNode<T> prev = head;
			SingleNode<T> placeholder = head;
			for(int i = 0; i < index; i++ ) {
				prev = placeholder;
				placeholder = placeholder.next;
			}
			if(index == 0) {
				head = placeholder.next;
			}
			valRemoved = placeholder.val;
			prev.next = placeholder.next;
			count--;
			return valRemoved;
		} else {
			throw new IndexOutOfBoundsException("Invalid Index: Out of bounds");
		}
	}

	public T removeLast() {
		T valRemoved = null;
		if (head != null) {
			SingleNode<T> end = head;
			while (end.next != null) {
				end = end.next;
			}
			valRemoved = end.val;
			end = null;
			count--;
		}
		return valRemoved;
	}

	public void clear() {
		head = null;
		count = 0;
	}
	
	public int search(T val) {
		int index = 0;
		SingleNode<T> search = head;
		if(head != null) {
		while (search.next != null) {
			if(search.val == val) {
				return index;
			}
			search = search.next;
			index++;
		}
		if(search.val == val) {
			return index;
		}
		}
		return -1;
	}

	@Override
	public String toString() {
		String output = "";
		if(head != null) {
			SingleNode<T> current = head;
			for(int i = 0; i < count; i++) {
				output += current.val;
				if(i != count - 1) {
					output += ", ";
				}
				current = current.next;
			}
		}
		return output;
		
	}
}
