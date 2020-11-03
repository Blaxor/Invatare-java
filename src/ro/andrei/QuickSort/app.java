package ro.andrei.QuickSort;

import java.util.Scanner;



public class app {
	public static void main(String[] args) {

		QuickSort qs = new QuickSort();
		int numarElemente = 0;
		System.out.println("Cate elemente vrei in lista?");
		Scanner scan = new Scanner(System.in);

		numarElemente = scan.nextInt();

		int[] lista = new int[numarElemente];
		for (int i = 0; i < numarElemente; i++) {

			System.out.println("Care este al %element% element?".replaceAll("%element%", i + ""));
			lista[i] = scan.nextInt();

		}
		scan.close();
		System.out.print("\nAsa arata lista introdusa de tine: ");
		for (int i = 0; i < numarElemente; i++) {
			System.out.print(lista[i] + " ");
		}
		System.out.print("\nAsa arata lista sortata : ");

		qs.sort(lista, 0, numarElemente - 1);

		for (int i = 0; i < numarElemente; i++) {
			System.out.print(lista[i] + " ");
		}
	}
}
