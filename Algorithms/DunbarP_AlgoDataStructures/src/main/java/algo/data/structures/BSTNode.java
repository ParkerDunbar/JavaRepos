package algo.data.structures;

public class BSTNode<T extends Comparable<? super T>>{
	T value;
	BSTNode<T> left;
	BSTNode<T> right;
	
	BSTNode(T value) {
		this.value = value;
	}

}
