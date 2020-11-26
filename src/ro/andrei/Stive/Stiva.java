package ro.andrei.Stive;

public class Stiva<T> {
	private final int maxAmount;
	private int size;
	private Node<T> head;

	/**
	 * Constructor pentru lista de tip Stiva
	 * 
	 * @param head      - primul element din Stiva
	 * @param maxAmount - dimensiunea maxima a listei
	 * 
	 */
	public Stiva(T head, int maxAmount) {
		this.maxAmount = maxAmount;
		this.head = new Node<T>(head);
		size++;
	}

	/**
	 * Adauga in stiva la final
	 * 
	 * @param value - se adauga in stiva daca nu este plina
	 * @throws RuntimeException - daca stiva este plina
	 * 
	 */

	public void push(T value) throws RuntimeException {
		if (maxAmount < size) {
			throw new RuntimeException("Push : OVERFLOW");

		}
		Node<T> now = getNode();
		now.setNext(new Node<T>(value));
		size++;
	}

	/**
	 * Constructor pentru lista de tip Coada
	 * 
	 * @return - ultima valoarea
	 * 
	 */
	public T pop() {
		if (head == null) {
			throw new RuntimeException("pop : UNDERFLOW");
		}
		Node<T> prevlast = head;
		if(size == 1) {
			head = null;
			return head.getValue();
		}

		while (prevlast.getNext().getNext() != null) {
			prevlast = prevlast.getNext();
		}
		T value = prevlast.getValue();
		prevlast.setNext(null);
		size--;
		return value;
	}

	/**
	 * Constructor pentru lista de tip Coada
	 * 
	 * @return - ultimul nod
	 * 
	 */

	private Node<T> getNode() {
		Node<T> now = head;
		while (now.getNext() != null) {
			now = now.getNext();
		}
		return now;
	}

	@Override
	public String toString() {
		Node<T> now = head;
		if (now != null) {
		String str = "[ " + now;
		while (now.getNext() != null) {
			now = now.getNext();
			str += " , " + now.toString();
		}
		return str + "]";
	}
	return "[]";
	}
}
