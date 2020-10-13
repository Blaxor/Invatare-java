package ro.andrei.CautareBinara;

public class CautareBinara {

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 4, 5, 10, 15, 20, 100, 250, 300, 599, 2000 };
		System.out.println(cautareBinara(a, 100, 0, a.length));

	}



	public static int[] insertieBinara(int[] lista, int numar) {

		int pos = 0;
		try {
			pos = cautareBinara(lista, numar, 0, lista.length);
		} catch (ArrayIndexOutOfBoundsException e) {

			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		int[] listaNoua = new int[lista.length + 1];
		int i = 0;
		while (i < lista.length) {

			if (i == pos) {

				listaNoua[i + 1] = numar;
				listaNoua[i] = lista[i];
				i++;

			} else if (i < pos) {

				listaNoua[i] = lista[i];
				i++;

			} else if (i > pos) {

				listaNoua[i + 1] = lista[i];
				i++;

			}

		}


		return listaNoua;

	}

	/*
	 * 4 [1,2,3,4,5,6,7,8,9] Return pozitia numarului cautat in lista;
	 */
	public static int cautareBinara(int[] lista, int numarCautat, int leftPos, int rightPos) {
		int mij = (rightPos - leftPos) / 2;


		if (lista[mij] < numarCautat) {

			return cautareBinara(lista, numarCautat, mij, rightPos);

		} else if (lista[mij] > numarCautat) {

			return cautareBinara(lista, numarCautat, leftPos, mij);

		} else {
			return lista[mij];
		}

	}
}
