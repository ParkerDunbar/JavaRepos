package algo.data.structures;

public class BinarySearchTree<T extends Comparable<? super T>> {
	int count = 0;
	BSTNode<T> root;
	
	public void add(T value) {
		if(root != null) {
			if(value.compareTo(root.value) == 0) {
				
			}
		}
		else {
			root = new BSTNode<T>(value);
		}
		
	}
	
	public boolean contains(T value) {
		if(root != null) {
			
		}
		return false;
	}
	
	public void remove(T value) {
		
	}
	
	public void clear() {
		
	}
	
	public int count() {
		return count;
	}
	
	public String inOrder() {
		return "";
	}
	
	public String preOrder() {
		return "";
	}
	
	public String postOrder() {
		return "";
	}
	
	public int height() {
		return 0;
	}
	
	public T[] toArray() {
		return null;
	}
	
}
