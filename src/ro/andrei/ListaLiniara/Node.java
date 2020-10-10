package ro.andrei.ListaLiniara;

public class Node<T> {
	private final T value;
	private Node<T> next;


	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;

	}

	public Node(T value) {
		this.value = value;
		next = null;

	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {

		return value.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Node<?>) {
			Node<?> t = (Node<?>) obj;
			if (t.value == this.value) {
				return true;
			}
		}
		return false;
	}
	

}
