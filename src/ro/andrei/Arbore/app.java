package ro.andrei.Arbore;

public class app {
	public static void main(String[] args) {
		Arbore<Integer> arbore = new Arbore<Integer>();
		int[] a = { 5, 1, 2, 3, 7, 9, 10, 4, 6, 8 };
		for (int i = 0; i < a.length; i++)
			arbore.insert(a[i]);

		System.out.println("In Ordine: ");
		arbore.afisareInOrdine(arbore.root);
		System.out.println();
		System.out.println("In pre ordine: ");

		arbore.afisareInPreOrdine(arbore.root);
		System.out.println();
		System.out.println("In post ordine: ");
		arbore.afisareInPostOrdine(arbore.root);
	}

}
