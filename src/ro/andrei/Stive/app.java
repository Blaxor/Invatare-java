package ro.andrei.Stive;

import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Te rog sa introduci cate elemente vrei sa aibe lista ta:");
		System.out.println("Daca introduci -1 inseamna nelimitate.");
		int elemente = input.nextInt();
		System.out.println("Te rog sa imi spui primul element din lista:");
		String element = input.next();
		Stiva<String> stiva = new Stiva<String>(element, elemente);

		boolean stop = false;

		while (stop == false) {
			System.out.println("Te rog sa introduci una din urmatoarele comenzii:");
			System.out.println("0 - pentru a opri aplicatia");
			System.out.println("1 - pentru a adauga un element");
			System.out.println("2 - pentru a sterge un element");
			System.out.println("3 - pentru a vedea ce element este accesabil.");

			input = new Scanner(System.in);
			int comanda = input.nextInt();

			switch (comanda) {
			case 0:
				stop = true;
				input.close();
				break;

			case 1:
				System.out.println("Ce element vrei sa adaugi?");

				stiva.push(input.next());
				break;
			case 2:
				System.out.println("Al catelea element vrei sa il stergi?");

				stiva.pop();
				break;

			case 3:
				System.out.println("Elementul accesabil este : " + stiva.pop());
				break;
			}
			System.out.println();
			System.out.println("Stiva ta este acum:");
			System.out.println(stiva);
			System.out.println();
		}

	}

}
