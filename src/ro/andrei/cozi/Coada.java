package ro.andrei.cozi;

import ro.andrei.Stive.Node;

public class Coada<T> {

	private int maxAmount;
	private int size;
	private Node<T> head = null;

	/**
	 * Constructor pentru lista de tip Coada
	 * 
	 * @param maxAmount - numarul maxim de elemente
	 * 
	 */
	public Coada(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * Constructor pentru lista de tip Coada
	 */
	public Coada() {
		this.maxAmount = Integer.MAX_VALUE;
	}

	/**
	 * Adaugarea unui numar la coada, se adauga pe ultimul loc
	 * 
	 * @param t - elementul care sa fie adaugat
	 * 
	 */
	public void queue(T t) {
		if (isFull())
			throw new RuntimeException("OverFlow");
		if (head == null) {
			head = new Node<T>(t);
			size++;
			return;
		}
		Node<T> now = head;
		while(now.getNext() != null) {
			now = now.getNext();
		}
		now.setNext(new Node<T>(t));
		size++;
	}

	/**
	 * Scoaterea primului termen din coada.
	 * 
	 * @return - primul termen din coada
	 * 
	 */
	public T dequeue() {
		if (isEmpty())
			throw new RuntimeException("Stergere nereusita: UNDERFLOW");

		T ceva = head.getValue();
		head = head.getNext();
		size--;
		return ceva;
	}

	/**
	 * Este goala coada?
	 * 
	 * @return Daca este goala sau nu coada
	 * 
	 */

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Este plina coada?
	 * 
	 * @return Daca este plina sau nu coada
	 * 
	 */
	public boolean isFull() {
		return size == maxAmount;
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
