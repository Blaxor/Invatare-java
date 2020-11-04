package ro.andrei.CautareBinara;

public class CautareBinara {
	/**
	 * 
	 */
	public static int cautareBinara(int[] lista, int numar, int left, int right) throws Exception {



		if (numar == lista[right]) {

			return right;
		}
		if (numar == lista[left]) {

			return left;
		}

		int mijloc = (left + right) / 2;
		try {
			if (lista[mijloc] > numar) {
				return cautareBinara(lista, numar, left, mijloc);
			} else if (lista[mijloc] < numar) {

				return cautareBinara(lista, numar, mijloc, right);
			} else {

				return mijloc;
			}
		} catch (StackOverflowError e) {
			throw new Exception("Number not found: " + mijloc);

		}

	}


}