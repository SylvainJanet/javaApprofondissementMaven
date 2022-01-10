package o01.console.tools;

import java.util.ArrayList;
import java.util.List;

import classes.Product;

public class InitialData {

//	public static List<Product> productList = new ArrayList<Product>(Arrays.asList(
//			new Product(1,"Ordinateur",500), 
//			new Product(2,"Clavier", 50),
//			new Product(3,"Souris",20)));

	// méthode équivalente
	public static List<Product> productList;

	/*
	 * Un bloc static peut être utilisé pour initialiser une classe. Ce code est
	 * executé une seule fois : la première fois que la classe est chargée en
	 * mémoire.
	 * 
	 * Utile surtout si l'initialisation d'une variable statique nécessite plus
	 * d'une ligne de code
	 * et donc impossible de faire :
	 * public static MonType maVar = { plusieurs lignes de code }
	 */
	static {
		productList = new ArrayList<Product>();
		productList.add(new Product(1,"Ordinateur",500));
		productList.add(new Product(2,"Clavier", 50));
		productList.add(new Product(3,"Souris",20));
	}

}
