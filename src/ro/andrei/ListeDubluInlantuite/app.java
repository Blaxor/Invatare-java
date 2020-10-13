package ro.andrei.ListeDubluInlantuite;

public class app {

	public static void main(String[] args) {
		ListaDubluInlantuita<String> LDI = new ListaDubluInlantuita<String>("primul", "ultimul");
		System.out.println(LDI + "     " + LDI.size);
		LDI.addNode("ULTIMUL1", LDI.size);
		LDI.addNode("ULTIMUL2", LDI.size);
		LDI.addNode("ULTIMUL3", LDI.size);
		LDI.addNode("ULTIMUL4", LDI.size);
		LDI.addNode("ULTIMUL5", LDI.size);
		System.out.println(LDI + "     " + LDI.size);
	}

}
