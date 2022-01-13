package o08.genericite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App8 {

	public static void main(String[] args) {
		/*
		 * 
		 * En POO, la généricité c'est un concept qui permet de définir des algorithmes
		 * (des classes, des méthodes, des interfaces, ...) en prenant en paramètre un
		 * type d'objet.
		 * 
		 * En Java, il y a énormément de classes génériques déjà existantes, par exemple
		 * les collections.
		 * 
		 * List est une interface générique ArrayList est une classe générique qui
		 * implément List
		 * 
		 * Lors de l'instanciation, on spécifie le type paramétré
		 * 
		 */

		List<String> collection = new ArrayList<String>();

		// opérateur diamant :
		// lorsque le paramètre de la classe qui implémente l'interface est le même que
		// le
		// paramètre de l'interface, on a pas besoin de le spécifier 2 fois
		List<String> collection2 = new ArrayList<>();

		List<Integer> collection3 = new ArrayList<>(Arrays.asList(3, 5, 4));

		System.out.println("_____________ displayList _____________");

		GenericFunctions.displayList(collection);
		GenericFunctions.displayList(collection2);
		GenericFunctions.displayList(collection3);

		System.out.println("_____________ fromArrayToList _____________");
		String[] strArray = new String[] { "str", "str2" };
		Integer[] intArray = new Integer[] { 3, 4, 5, 6 };
		List<String> strList = new ArrayList<>();
		List<Integer> intList = new ArrayList<>();

		GenericFunctions.displayList(strList);
		GenericFunctions.displayList(intList);

		GenericFunctions.fromArrayToList(strArray, strList);
		GenericFunctions.fromArrayToList(intArray, intList);

		GenericFunctions.displayList(strList);
		GenericFunctions.displayList(intList);

		System.out.println("_____________ getFirstElement _____________");
		System.out.println(GenericFunctions.getFirstElement(strList));
		System.out.println(GenericFunctions.getFirstElement(intList));

		System.out.println("_____________ GenericClass _____________");
		GenericClass<String> strGenClass = new GenericClass<String>(new ArrayList<String>(), "ma chaine");
		GenericClass<Integer> intGenClass = new GenericClass<Integer>(new ArrayList<Integer>(), 5);

		System.out.println(strGenClass.getElement());
		System.out.println(intGenClass.getElement());
		GenericFunctions.displayList(strGenClass.getList());
		GenericFunctions.displayList(intGenClass.getList());

		// architecture type du dao en utilisant les génériques :
		// regarder d'abord dao.interfacegen
		// problème : on doit toujours implémenter des fonctions qui se ressemblent beaucoup
		// qui correspondent à l'implémentation de IGenericDao
		// puis dao.classegen

	}

}
