package algo.data.structures;

public class DoubleNode<T> {
	T val;
	DoubleNode<T> next;
	DoubleNode<T> prev;
	
	DoubleNode(T val) {
		this.val = val;
	}
}