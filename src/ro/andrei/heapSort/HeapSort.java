package ro.andrei.heapSort;

public class HeapSort {
	// parent : (n-1)/2
	// child left : 2n+1
	// child right : 2n+2

	public void sort(int[] lista) {
		int lengh = lista.length;// numarul de elemente in lista

		for (int i = lengh / 2 - 1; i >= 0; i--) {// il transformam in arbore binar

			sortDown(lista, lengh, i);
		}
		
		for (int i = lengh - 1; i >= 0; i--) {// luam de la ultimul element pana la primul

			swap(lista, 0, i);// inlocuim primul element cu ultimul

			sortDown(lista, i, 0);// sortam lista si il stergem pe ultimul element
		}
	}

	private void sortDown(int[] lista, int dimnesiuneHEAP, int item) {
		int largest = item;// nodul
		int copchilStanga = 2 * item + 1; // frunza din stanga
		int copchilDreapta = 2 * item + 2; // frunza din dreapta

		if (copchilStanga < dimnesiuneHEAP && lista[copchilStanga] > lista[largest]) {
			// daca indexul frunzei din stanga exista in lista si frunza din stanga este mai
			// mare de cat nod
			largest = copchilStanga;// inlocuim nodul cu frunza din stanga
		}

		if (copchilDreapta < dimnesiuneHEAP && lista[copchilDreapta] > lista[largest]) {
			// daca indexul frunzei din dreapta exista in lista si frunza din dreapta este
			// mai mare de cat nod
			// inlocuim nodul cu frunza din dreapta
			largest = copchilDreapta;
		}

		if (largest != item) {
			// daca nodul nu este nodul initiala
			swap(lista, largest, item); // inlocuim nodul initial cu nodul aflat de noi
			sortDown(lista, dimnesiuneHEAP, largest);// incercam iar sa vedem daca nodul aflat de noi are vreo frunza
														// care este mai mare de cat el
		}

	}

	private void swap(int[] lista, int indexA, int indexB) {
		int temp = lista[indexA];
		lista[indexA] = lista[indexB];
		lista[indexB] = temp;
	}

}

