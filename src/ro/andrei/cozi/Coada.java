package ro.andrei.cozi;



public class Coada<T> {

	private int maxAmount;// Numarul maxim de elemente din lista
	private int size;// Numarul de elemente din lista
	private Node<T> head = null;// primul element din lista

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
		if (isFull())// daca lista este plina
			throw new RuntimeException("OverFlow");
		if (head == null) {// daca elementul este vid
			head = new Node<T>(t);// creeam un nou element cu valoarea t
			size++;// incrementam lista odata
			return;
		}
		Node<T> now = head;// variabila temporara
		while (now.getNext() != null) {// cat timp umraturl lui now nu este null
			now = now.getNext();// now este urmatorul
		}
		now.setNext(new Node<T>(t));// urmatorul la ultimul nod o sa fie un nou nod de valoarea t
		size++;// incrementam lista
	}

	/**
	 * Scoaterea primului termen din coada.
	 * 
	 * @return - primul termen din coada
	 * 
	 */
	public T dequeue() {
		if (isEmpty())// daca lista este goala
			throw new RuntimeException("Stergere nereusita: UNDERFLOW");

		T ceva = head.getValue();// variabila temporara cu valoarea primului element
		head = head.getNext();// primul element o sa fie urmatorul dupa acesta
		size--;// reducem cu 1 dimensiunea
		return ceva;// scoate valoarea din primul element
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
