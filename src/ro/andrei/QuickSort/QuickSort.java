package ro.andrei.QuickSort;

public class QuickSort {

	public void sort(int[] lista, int leftest, int rightest) {
		if (leftest < rightest) {
			int b = partition(lista, leftest, rightest);// primim locatia pivotului

			sort(lista, leftest, b - 1);// repetam procesul pentru elementele din partea stanga a pivotului
			sort(lista, b + 1, rightest);// repetam procesul pentru elementele din partea dreapta a pivotului
		}
	}

	private int partition(int[] lista, int leftest, int rightest) {
		
		int left = leftest;// primul element
		int right = rightest;// ultimul element

		int pivot = lista[left];// pivot

		while (left < right) {// cat timp primul index este mic ca ultimul index
			while (lista[left] <= pivot && left < right) {// cat timp primul element este mai mic sau egal cu pivot si
															// primul index este mic ca ultimul index
				left += 1;// ne mutam cu 1 spre dreapta
			}
			while (lista[right] > pivot) {// cat timp ultimul element este mai mare ca pivot
				right -= 1;// ne mutam cu 1 spre stanga
			}
			if (left < right)// daca primul element este mai mic ca ultimul element
				swap(lista, left, right);// le inversam
		}
		lista[leftest] = lista[right];// inlocuim primul element ( pivot) cu elementul din dreapta
		lista[right] = pivot;// inlocuim elementul din dreapta cu pivot
		return right;// return locatia pivotului

	}

	private void swap(int[] lista, int A, int B) {

		int temp = lista[A];
		lista[A] = lista[B];
		lista[B] = temp;

	}


}

