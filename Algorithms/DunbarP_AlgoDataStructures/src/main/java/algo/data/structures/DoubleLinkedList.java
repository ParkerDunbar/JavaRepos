package algo.data.structures;

public class DoubleLinkedList<T> {
	int count = 0;
	DoubleNode<T> head;

	public void add(T val) {
		if (head != null) {
			DoubleNode<T> newNode = new DoubleNode<T>(val);
			DoubleNode<T> end = head;
			while (end.next != null) {
				end = end.next;
			}
			end.next = newNode;
			newNode.prev = end;
		} else {
			head = new DoubleNode<T>(val);
		}
		count++;
	}

	public void insert(T val, int index) {
		if (index >= 0 && index < count && head != null) {
			DoubleNode<T> newNode = new DoubleNode<T>(val);
			DoubleNode<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			if (index == 0) {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			} else {
				current.prev.next = newNode;
				newNode.prev = current.prev;
				newNode.next = current;
				current.prev = newNode;
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
		if (index >= 0 && index < count && head != null) {
			DoubleNode<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.val;
		} else {
			throw new IndexOutOfBoundsException("Invalid Index: Out of bounds");
		}
	}

	public T remove() {
		T valRemoved = null;
		if (head != null) {
			valRemoved = head.val;
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
			count--;
		}
		return valRemoved;
	}

	public T removeAt(int index) {
		if (index >= 0 && index < count && head != null) {
			T valRemoved = null;
			DoubleNode<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			if (index == 0) {
				valRemoved = head.val;
				head = current.next;
			}
			else {
				valRemoved = current.val;
				if(current.next == null) {
					current.prev.next = current.next;
					current = null;
				}
				else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
			}
			count--;
			return valRemoved;
		} else {
			throw new IndexOutOfBoundsException("Invalid Index: Out of bounds");
		}
	}

	public T removeLast() {
		T valRemoved = null;
		if (head != null) {
			DoubleNode<T> end = head;
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
		DoubleNode<T> search = head;
		if(head != null) {
		while (search.next != null) {
			if (search.val == val) {
				return index;
			}
			search = search.next;
			index++;
		}
		if (search.val == val) {
			return index;
		}
		}
		return -1;
	}

	@Override
	public String toString() {
		String output = "";
		if (head != null) {
			DoubleNode<T> current = head;
			for (int i = 0; i < count; i++) {
				output += current.val;
				if (i != count - 1) {
					output += ", ";
				}
				current = current.next;
			}
		}
		return output;
	}
}
