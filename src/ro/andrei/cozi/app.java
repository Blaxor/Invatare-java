package ro.andrei.cozi;

import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Coada<String> coada = new Coada<String>();

		boolean stop = false;

		while (stop == false) {
			System.out.println("Te rog sa introduci una din urmatoarele comenzii:");
			System.out.println("0 - pentru a opri aplicatia");
			System.out.println("1 - pentru a adauga un element");
			System.out.println("2 - pentru a sterge un element");

			input = new Scanner(System.in);
			int comanda = input.nextInt();

			switch (comanda) {
			case 0:
				stop = true;
				input.close();
				break;

			case 1:
				System.out.println("Ce element vrei sa adaugi?");

				coada.queue(input.next());
				break;
			case 2:
				System.out.println("Al catelea element vrei sa il stergi?");

				coada.dequeue();
				break;
			}
			System.out.println();
			System.out.println("Coada ta este acum:");
			System.out.println(coada);
			System.out.println();
		}
	}

}
