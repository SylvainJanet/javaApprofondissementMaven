package o02.consoleImproved.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputTools {

	public static int readInt(Scanner sc, String label) {
		int res;
		System.out.println(label);
		while (true) {
			try {
				res = sc.nextInt();
				break;
			} catch (InputMismatchException ex) {
				System.out.println("Seul les caractères [0-9] sont acceptés");
				sc.next();
			}
		}
		return res;
	}

	public static int readBoundedInt(Scanner sc, String label, int min, int max) {
		boolean isCorrect = false;
		int res = 0;
		while (!isCorrect) {
			res = readInt(sc, label);
			if (min <= res && res <= max) {
				isCorrect = true;
			} else {
				System.out.println("Merci d'entrer un nombre entre " + min + " et " + max);
			}
		}
		return res;
	}
}
