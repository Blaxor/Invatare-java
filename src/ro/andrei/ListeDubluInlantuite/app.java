package ro.andrei.ListeDubluInlantuite;

public class app {

	public static void main(String[] args) {
		ListaDubluInlantuita<String> LDI = new ListaDubluInlantuita<String>("primul", "ultimul");
		System.out.println(LDI + "     " + LDI.size);
		LDI.addNode("ULTIMUL1", 1);
		LDI.addNode("ULTIMUL2", 1);
		System.out.println(LDI + "     " + LDI.size);
	}

}
