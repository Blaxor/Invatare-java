package ro.andrei.CautareBinara;

import java.util.ArrayList;

public class CautareBinara {

	public static void main(String[] args) {
		int[] a = { 5, 10, 25, 30, 55, 100, 150, 259, 269, 300 };
		ArrayList<Integer> lita = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			lita.add(a[i]);
		}
		int pos = cautareBinara(lita, 30, 0, a.length - 1);
		System.out.println(pos);

	}




	public static void inserareBinara(ArrayList<Integer> lista, int numar) {

		if (numar > lista.get(lista.size())) {
			lista.add(numar);
			return;
		} else if (numar < lista.get(0)) {
			lista.add(0, numar);
		}

	}
	
	/*
	 * 4 [1,2,3,5,6,7,8,9] Return pozitia numarului cautat in lista;
	 */
	public static int cautareBinara(ArrayList<Integer> lista, int numarCautat, int leftPos, int rightPos) {

		int mij = (rightPos - leftPos) / 2;

		if (lista.get(mij) > numarCautat) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = leftPos ; i < mij ; i++) {
				list.add(i);
			}
			return mij + cautareBinara(list, numarCautat, leftPos, mij);

		} else if (lista.get(mij) < numarCautat) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = mij; i < rightPos; i++) {
				list.add(lista.get(i));
			}
			return mij + cautareBinara(list, numarCautat, mij, rightPos);

		} else {
			return mij;
		}

	}
}
