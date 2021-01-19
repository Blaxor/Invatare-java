package ro.andrei.Arbore;

/**
 * 
 * @author Panduru Andrei
 *
 * @param <T> - orice tip de valoare care implementeaza Comparable
 */
public class Arbore<T extends Comparable<T>> {

	Node<T> root;
	Node<T> nodeNow;

	/**
	 * 
	 * Inseram o valoare de tip T in arbore
	 * 
	 * @param value - valoarea pe care vrem sa o stocam in arbore
	 * 
	 */

	public void insert(T value) {
		if (root == null) { // daca nu avem root atunci o sa inseram valoarea in root
			root = new Node<T>(value);
			nodeNow = root;
			return;
		}
		if (nodeNow == null) {
			nodeNow = root;
		}
		
		if (value.compareTo(nodeNow.value) <= 0) { // daca valoarea este mai mic sau egal cu valoarea pe care o stocam
													// in nodeNow introducem in frunza stanga
			if (nodeNow.nS != null) {// daca frunza stanga exista deja incercam in urmatoarea
				nodeNow = nodeNow.nS;
				insert(value);
			} else {// altfel daca frunza stanga nu exista , introducem valoarea in frunza stanga
				nodeNow.nS = new Node<T>(value,nodeNow);
				nodeNow = null;
				return;
			}
		} else {// altfel daca valoarea este mai mare incercam sa introducem in frunza dreapta
			if (nodeNow.nD != null) {// daca frunza dreapta exista deja incercam in urmatoarea
				nodeNow = nodeNow.nD;
				insert(value);
			} else {// altfel daca frunza dreapta nu exista, introducem valoarea in frunza dreapta
				nodeNow.nD = new Node<T>(value, nodeNow);
				nodeNow = null;
				return;
			}
		}

	}

	private Node<T> searchDel = null;
	
	/**
	 * 
	 * Stergem o valoare de tip T din arbore
	 * 
	 * @param value - valoarea pe care vrem sa o stergem
	 * 
	 */

	public void delete(T value) {
		searchDel(root, value);// cautam elementul
		if (searchDel == null) {// daca searchDel este null atunci nu a fost gasit
			return;
		}
		delete(searchDel, value);// si daca nu este null atunci a fost gasit si se sterge

	}


	/**
	 * 
	 * Cautam o valoare si o sa fie stocata in variabila searchDel
	 * 
	 * @param value - valoarea pe care vrem sa o gasim
	 * @param node  - nodul in care cautam
	 * 
	 */
	private void searchDel(Node<T> node, T value) {

		if (node.value.compareTo(value) == 0) { // comparam valoarea nodului cu valoarea si daca sunt egale atunci o sa
												// se salvele nodul in searchDel si oprim recursivitatea
			searchDel = node;
			return;
		}
		if (node.nS != null) {// daca frunza stanga nu este null
			searchDel(node.nS, value); // recusivitate pe frunza stanga

		}
		if (node.nD != null) {// daca frunza dreapta nu este null
			searchDel(node.nD, value); // recusivitate pe frunza dreapta

		}
	}

	/**
	 * Stergem valoarea si reconstruim frunzele nodului cu valoarea stearsa
	 * 
	 * @param node  nodul pe care vrem sa il stergem
	 * @param value valoaprea pe care vrem sa o stergem
	 */
	private void delete(Node<T> node, T value) {


		
		if (node.Parent != null) {// daca noul parinte nu este null
			if (node.Parent.nD == node) {// atunci o sa verificam daca frunza dreapta a nodului parinte este node
				node.Parent.nD = null; // daca este atunci stegem legatura paritelui cu acest nod
			} else {// altfel
				node.Parent.nS = null; // stergem legatura paritelui cu frunza stanga
				}

			}
			if (node.value != value)// cat timp valoarea nodului nu este egala cu valoarea T, o sa inseram inapoi in
									// arbore valoarea
				insert(node.value);
			if (node == root) {// daca nodul pe care il vrem sters este radacita , atunci stergem radacina
				root = null;
			}
			// folosim pentru fiecare frunza recusivitatea pentru a reconstrui toate
			// nodurile ne sterse
			if (node.nS != null) {
				delete(node.nS, value);

			}
			if (node.nD != null) {
				delete(node.nD, value);

			}

		}





		/**
		 * Afisam in oridine crescatoare recursiv ,
		 * 
		 * @param node - inceputul arborelui
		 */
		public void afisareInOrdine(Node<T> node) {
		
			if (node == null) {// daca este null atunci inseamna ca nu mai avem vrun pas urmator
			return;
		}
		afisareInOrdine(node.nS);// intram prin recursivitate in nodul stang

		System.out.print(node.toString() + " , ");// printam valoarea nodului
		
		afisareInOrdine(node.nD);// intram prin recursivitate in nodul drept

	}

	/**
	 * Afisam in preoridine recursiv ,
	 * 
	 * @param node - inceputul arborelui
	 */
	public void afisareInPreOrdine(Node<T> node) {
		if (node == null) {// daca este null atunci inseamna ca nu mai avem vrun pas urmator
			return;
		}
		System.out.print(node.toString() + " , ");// printam valoarea nodului
		afisareInPreOrdine(node.nS);// intram prin recursivitate in nodul stang
		afisareInPreOrdine(node.nD);// intram prin recursivitate in nodul drept
	}

	/**
	 * Afisam in post oridine recursiv ,
	 * 
	 * @param node - inceputul arborelui
	 */
	public void afisareInPostOrdine(Node<T> node) {
		if (node == null) {// daca este null atunci inseamna ca nu mai avem vrun pas urmator
			return;
		}



		afisareInPostOrdine(node.nS);// intram prin recursivitate in nodul stang
		afisareInPostOrdine(node.nD);// intram prin recursivitate in nodul drept
		System.out.print(node.toString() + " , ");// printam valoarea nodului


	}




}
