package ro.andrei.Arbore;

/**
 * 
 * @author Panduru Andrei
 *
 * @param <T> - orice tip de valoare care implementeaza Comparable
 */
public class Node<T extends Comparable<T>> {

	T value;// valoarea pe care o stocam
	Node<T> Parent;// parintele acestui nod
	Node<T> nS;// frunza stanga
	Node<T> nD;// frunza dreapta

	/**
	 * 
	 * @param Valoarea nodului
	 */
	public Node(T value) {
		this.value = value;

	}

	/**
	 * 
	 * @param value   valoarea nodului
	 * @param _parent nodul parinte
	 */
	public Node(T value, Node<T> _parent) {
		this.value = value;
		this.Parent = _parent;
	}

	@Override
	public String toString() {

		return value.toString() + "";
	}

}
