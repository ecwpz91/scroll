public class Node {
	private int value;
	private Node next;

	public Node() {
		value = 0;
		next = null;
	}

	public Node(int i) {
		value = i;
		next = null;
	}

	public void setNext(Node n) {
		next = n;
	}

	public Node getNext() {
		return next;
	}

	public void setValue(int i) {
		value = i;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return value + "";
	}
}
