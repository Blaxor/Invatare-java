package ro.andrei.ListaLiniara;

import java.util.Scanner;

public class app {

	public static void main(String[] args) {



		Scanner input = new Scanner(System.in);
		System.out.println("Te rog sa introduci cate elemente vrei sa aibe lista ta:");
		System.out.println("Daca introduci -1 inseamna nelimitate.");
		int elemente = input.nextInt();
		ListaLiniara<String> lista = null;
		if (elemente > 0) {
			lista = new ListaLiniara<String>(elemente);
		} else if (elemente == 0) {
			System.out.println("Nu se poate creea o lista cu 0 elemente maxime");
			input.close();
			return;
		} else if (elemente < 0) {
			lista = new ListaLiniara<String>();
		}

		System.out.println("A fost creata o noua lista cu " + lista.getMax() + " elemente!");

		System.out.println("Te rog sa imi spui primul element din lista:");
		lista.addNode(input.next());
		boolean stop = false;

		while (stop == false) {
			System.out.println("Te rog sa introduci una din urmatoarele comenzii:");
			System.out.println("0 - pentru a opri aplicatia");
			System.out.println("1 - pentru a adauga un element");
			System.out.println("2 - pentru a sterge un element");
			System.out.println("3 - pentru a modifica un element");
			System.out.println("4 - pentru a adauga un element la o anumita pozitie");

			input = new Scanner(System.in);
			int comanda = input.nextInt();

			switch (comanda) {
			case 0:
				stop = true;
				input.close();
				break;

			case 1:
				System.out.println("Ce element vrei sa adaugi?");

				lista.addNode(input.next());

				break;
			case 2:
				System.out.println("Al catelea element vrei sa il stergi?");

				lista.removeNode(input.nextInt() - 1);
				break;
			case 3:
				System.out.println("Al catelea element vrei sa il modifici?");

				int index = input.nextInt();
				System.out.println("Si ce vrei sa fie in locul lui?");
				lista.modifyNode(index - 1, input.next());
				break;
			case 4:
				System.out.println("In a cata pozitie vrei sa adaugi elementul?");
				int i = input.nextInt();
				System.out.println("Ce element vrei sa adaugi?");
				lista.addNode(i - 1, input.next());
			}
			System.out.println();
			System.out.println("Lista ta este acum:");
			System.out.println(lista);
			System.out.println();

		}
	}
}
