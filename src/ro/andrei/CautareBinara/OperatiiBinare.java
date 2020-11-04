package ro.andrei.CautareBinara;

public class OperatiiBinare {

	// Adauga un numar in lista
	public int[] addNumber(int[] lista, int number) {

		try {
			// daca nu primim nici o exceptie inseamna ca numarul exista deja si ii dam
			// return
			CautareBinara.cautareBinara(lista, number, 0, lista.length - 1);
			return lista;
		} catch (Exception e) {
			// daca apare vreo exceptie inseamna ca numarul nu exista atunci :
			int loc = Integer.valueOf(e.getMessage().substring(18));// luam din exceptie locatia unde trebuie sa fie
																	// numarul -1
			System.out.print("Line 17" + loc);
			int[] temp = new int[lista.length + 1];// creeam o lista noua
			if (loc == 0) {// daca locatia este 0 adica prima in lista
				temp[0] = number;// setam numarul in locatie
				for (int i = 0; i < lista.length; i++) {// adaugam restul numerelor
					temp[i + 1] = lista[i];
				}
				return temp;// dam return la lista
			} else if (loc == lista.length - 2) {// daca locatia este ultima
				if (lista[loc + 1] < number) {
					for (int i = 0; i < lista.length; i++) {// adaugam numerele care erau deja
						temp[i] = lista[i];
					}
					temp[lista.length] = number;// adaugam numarul
					return temp;// dam retrun la lista
				} else {
					for (int i = 0; i < lista.length - 1; i++) {// adaugam numerele care erau deja
						temp[i] = lista[i];
					}
					temp[lista.length - 1] = number;
					temp[lista.length] = lista[lista.length - 1];
				}
			}

			for (int i = 0; i <= loc; i++) {// adaugam nuumerele pana la locatie si inclisiv
				temp[i] = lista[i];
			}
			temp[loc + 1] = number;// adaugam numarul dupa locatie
			for (int i = loc + 1; i < lista.length; i++) {// adaugam restul numerelor in lista
				temp[i + 1] = lista[i];
			}
			return temp;

		}

	}

	public int[] removeNumber(int[] lista, int number) {
		int[] temp = new int[lista.length - 1];// creeam lista
		try {
			// daca nu primim exceptie inseamna ca numarul exista deci putem sa il stergem
			int pos = CautareBinara.cautareBinara(lista, number, 0, lista.length - 1);// luam pozitia numarului
			System.out.println("Line 59 :" + pos + "\n Dimensiunea Listei:" + lista.length);
			if (pos == 0) {// daca pozitia este 0 , atunci este primul numar deci doar adaugam restul
							// numerelor
				for (int i = 1; i < lista.length - 1; i++) {
					temp[i - 1] = lista[i];
				}
				return temp;
			} else if (pos == lista.length - 2) {
					// daca pozitia este ultimul
					for (int i = 0; i < lista.length - 2; i++) {// adaugam numerele pana la ultimul
					temp[i] = lista[i];
				}


				temp[temp.length - 1] = lista[lista.length - 1];

			// temp[lista.length] = lista[lista.length -1];
				return temp;
			}
			for (int i = 0; i < pos; i++) {// adaugam numerele pana la pozitie
				temp[i] = lista[i];
			}
			for (int i = pos + 1; i < lista.length; i++) {// sarim cu 1 pozitia
				temp[i - 1] = lista[i];
			}
			return temp;
		} catch (Exception e) {
			// daca nu exista atunci inseamna ca nu avem ce numar sa scoatem
			return lista;
		}
		
	}





}
