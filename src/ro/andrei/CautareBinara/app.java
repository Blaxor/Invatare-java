package ro.andrei.CautareBinara;

import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		OperatiiBinare ib = new OperatiiBinare();

		System.out.print(
				"Un arbore binar trebuie sa aiba minim 3 elemente 1 nod si 2 frunze .\n Te rog sa imi spui 3 elemente in ordine crescatoare!\n");
		Scanner scan = new Scanner(System.in);
		int[] lista = new int[3];
		for (int i = 0; i < 3; i++) {
			lista[i] = scan.nextInt();
		}

		boolean stop = false;
		while (!stop) {
			System.out.println("Lista ta este : " + getList(lista));
			System.out.println(
					"Te rog sa alegi din urmatoarele comenzii:\n 0 - Pentru a inchide aplicatia\n 1 - Pentru a adauga un element in lista \n 2 - Pentru a sterge un element din lista");
			switch (scan.nextInt()) {
			case 0:
				System.out.println("Aplicatia se inchide!");
				stop = true;
				break;
			case 1:
				System.out.println("Ce numar doresti sa adaugi in lista?");
				lista = ib.addNumber(lista, scan.nextInt());
				break;
			case 2:
				System.out.println("Ce numar doresti sa stergi in lista?");
				lista = ib.removeNumber(lista, scan.nextInt());
				break;

			}

		}

		scan.close();
	}

	private static String getList(int[] lista) {
		String a = "[";
		a += lista[0];
		for (int i = 1; i < lista.length; i++) {
			a += ", " + lista[i];
		}
		a += " ]";
		return a;
	}
}
