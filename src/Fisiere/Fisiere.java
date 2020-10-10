package Fisiere;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fisiere {

	public static String[] readFile(String path, String delimiter) throws FileNotFoundException {


		Scanner scanner = new Scanner(new File(path));
		scanner.useDelimiter(delimiter);
		ArrayList<String> continut = new ArrayList<>();
		while (scanner.hasNext()) {
			continut.add(scanner.next());
		}
		scanner.close();
		return (String[]) continut.toArray();
	}
}
