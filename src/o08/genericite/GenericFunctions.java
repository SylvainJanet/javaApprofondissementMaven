package o08.genericite;

import java.util.List;

public class GenericFunctions {

	public static void displayList(List<?> liste) {
		if (liste.size() == 0) {
			System.out.println("liste vide");
		} else {
			for (Object element : liste) {
				System.out.println(element);
			}
		}
	}

	// créer une fonction qui met le contenu d'un tableau dans une liste
	// avant le type de retour, mettre entre crochet les paramètres de type
	public static <T> void fromArrayToList(T[] array, List<T> list) {
		for (T s : array) {
			list.add(s);
		}
	}

	public static <T> T getFirstElement(List<T> list) {
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

}
