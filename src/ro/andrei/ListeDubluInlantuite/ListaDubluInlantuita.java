package ro.andrei.ListeDubluInlantuite;



public class ListaDubluInlantuita<T> {
	Node<T> primul;
	Node<T> ultimul;
	int size;

	public ListaDubluInlantuita(T primul, T ultimul) {
		this.primul = new Node<T>(primul, null, null);
		this.ultimul = new Node<T>(ultimul, this.primul, null);
		this.primul.setNext(this.ultimul);

		size += 1;
	}

	public void addNode(T value, int index) {
		if(index == size) {
			Node<T> n = new Node<T>(value, ultimul, null);
			ultimul.setNext(n);
			ultimul = n;
			size++;
			return;
		} else if (index == 0) {
			Node<T> n = new Node<T>(value, null, primul);
			primul.setPrev(n);
			primul = n;
			size++;
		}

	}

	public Node<T> getNode(int index) {

		if (index == 0) {
			return primul;
		} else if (index == size) {
			return ultimul;
		}
		Node<T> now = primul;
		if (index < size / 2) {
			now = primul;
			for (int i = 0; i <= index; i++) {
				now = now.getNext();
			}
		} else {
			now = ultimul;
			for (int i = 0; i <= size - index; i++) {
				now = now.getPrev();
			}
		}
		return now;

	}
	@Override
	public String toString() {
		Node<T> now = primul;
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