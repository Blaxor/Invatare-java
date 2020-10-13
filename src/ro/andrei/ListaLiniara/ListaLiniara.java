package ro.andrei.ListaLiniara;

public class ListaLiniara<T> {

	private final int maxAmount;
	private int size = 0;
	private Node<T> head;

	/**
	 * Constructorul pentru clasa ListaLiniara<T> care are maximul de elemente =
	 * Integer.MAX_VALUE
	 * 
	 * @param value - primul element din lista
	 */
	public ListaLiniara(T value) {
		head = new Node<T>(value);
		maxAmount = Integer.MAX_VALUE;
		size++;
	}

	/**
	 * Constructorul pentru clasa ListaLiniara<T> care are maximul de elemente =
	 * maxAmount
	 * 
	 * @param value     - primul element din lista
	 * @param maxAmount - numarul maxim de elemente
	 */
	public ListaLiniara(T value, int maxAmount) {
		
		head = new Node<T>(value);
		this.maxAmount = maxAmount;
		size++;
		
	}

	/**
	 * Constructorul pentru clasa ListaLiniara<T> care are maximul de elemente =
	 * Integer.MAX_VALUE
	 */
	public ListaLiniara() {
		this.maxAmount = Integer.MAX_VALUE;

	}

	/**
	 * Constructorul pentru clasa ListaLiniara<T> care are maximul de elemente =
	 * maxAmount
	 * 
	 * @param maxAmount - numarul maxim de elemente
	 */
	public ListaLiniara(int maxAmount) {
		this.maxAmount = maxAmount;
	}



	/**
	 * Se adauga elementul in lista pe ultima pozitie
	 * 
	 * @param value - elementul care se adauga
	 */
	public void addNode(T value) {
		if (isFull()) {
			System.out.println("The value has not been added because is full");
			return;
		}
		if (head == null) { // daca head este null
			head = new Node<T>(value);// cream mai intai head ul
			size++;// incrementam dimensiunea listei
			return;
		}
		Node<T> node = head;
		while (node.getNext() != null) { // cat timp exista un urmator nod
			node = node.getNext();

		}
		node.setNext(new Node<T>(value));// // setam la ultimul nod valoarea
		size++;// incrementam dimensiunea listei
	}

	/**
	 * Se adauga elementul in lista pe pozitia i
	 * 
	 * @param i     - pozitia noului element
	 * @param value - elementul care se adauga
	 * 
	 */
	public void addNode(int i, T value) {
		if (isFull()) {
			System.out.println("Lista este la capacitate maxima : OVERFLOW");
			return;
		}
		if (i == 0) {
			head = new Node<T>(value, head);
			size++;
			return;
		}
		if (i == size) {
			addNode(value);
			return;
		} else if (i > size - 1) {
			System.out.println("Nu poti sa adaugi un element in aceasta pozitie");
			return;
		}
		Node<T> prev, next, now;
		prev = getNode(i - 1);
		next = getNode(i);
		now = new Node<T>(value, next);
		prev.setNext(now);
		size++;
	}

	/**
	 * Se sterge elementul
	 * 
	 * @param i - pozitia elementului care sa fie sters
	 */
	public void removeNode(int i) {
		if (i < 0) {
			System.out.println("Aceasta pozitie nu exista");
			return;
		}
		if (i == 0) {
			if (head == null) {
				System.out.println("Lista este vida : UNDERFLOW");
				return;
			}
			head = head.getNext();
			size--;
			return;
		}
		if (i + 1 > size) {
			System.out.println("Acest element nu exista in lista");
			return;
		}
		Node<T> prev, next;

		prev = getNode(i - 1);
		next = getNode(i + 1);
		prev.setNext(next);
		size--;
	}

	/**
	 * Se adausa lista cu elementi la final
	 * 
	 * @param value - lista cu elementi
	 */
	public void addNodes(T[] value) {
		if (size + value.length > maxAmount) {
			System.out.println("Lista este aproape la capacitate maxima : OVERFLOW");
			return;

		}
		for (int i = 0; i < value.length; i++) {
			addNode(value[i]);
		}
	}

	/**
	 * Ia elementul de la o anumita pozitie
	 * 
	 * @param i - pozitia elementului
	 * @return elementul gasit
	 */
	public Node<T> getNode(int i) {

		if (isEmpty()) {
			System.out.println("Lista este vida : UNDERFLOW");
			return null;
		}
		if (i + 1 > size) {
			System.out.println("Acest element nu exista in lista");
			return null;
		}
		int pos = 0;
		Node<T> now = head;
		while (pos < i) {
			pos++;
			now = now.getNext();
		}
		return now;

	}

	/**
	 * Se modifica elementul
	 * 
	 * @param i     - pozitia elementului care sa fie sters
	 * @param value - valoarea noua
	 */
	public void modifyNode(int i, T value) {
		if(i < 0) {
			System.out.println("Acest element nu exista in lista");
			return;
		}
		if(i==0) {
			head.setValue(value);
			return;
		}
		getNode(i).setValue(value);
	}

	/**
	 * Verifica daca lista este full
	 * 
	 * @return daca este lista full
	 */
	public boolean isFull() {
		return size == maxAmount;
	}

	/**
	 * Se verifica daca este lista goala
	 * 
	 * @return - este goala lista sau nu
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Verifica dimensiunea listei
	 * 
	 * @return - dimensiunea listei
	 */

	public int getSize() {
		return size;
	}

	/**
	 * 
	 * @return - cat de mare poate sa fie lista
	 */
	public int getMax() {
		return maxAmount;
	}
	@Override
	public String toString() {
		if (!isEmpty()) {
			Node<?> node = head;
			String str = "[ " + head.toString();
			while (node.getNext() != null) {

				node = node.getNext();
				str += " , " + node.toString();

			}

			return str + " ]";
		} else {
			return "[]";
		}
	}
}
