package o10.reflexion;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Personne;
import classes.Product;
import o01.console.tools.InitialData;
import o08.genericite.GenericFunctions;

public class App10 {

	public static void main(String[] args) {
		/*
		 * 
		 * La réflexion est un concept POO qui permet d'obtenir des informations
		 * structurelles sur un type de données Par exemple, connaître les attributs
		 * d'une classe.
		 * 
		 * Ces informations sont stockées dans un objet de type Class. Ce type "Class"
		 * est générique, il fonctionne pour n'importe quelle type d'objet. Il utilise
		 * le package java.lang. ...
		 * 
		 */

		System.out.println("__________ getDeclaredFields __________");
		Class<Product> metadata = Product.class;
		Product product = new Product(1, "Ma description", 50);

		Field[] fields = metadata.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
			try {
				field.setAccessible(true);
				// par défaut lorsqu'on récupère les champs d'une classe, un flag accessible est
				// mis
				// à false, et il a le sens suivant :
				// field Accessible : false : les champs privés ne seront pas accessibles, les
				// champs
				// public seront accessibles, les champs protected ne seront accessibles que
				// depuis
				// les classes qui héritent de la classe en question : les vérifications
				// d'accessibilité
				// vont se faire
				// field Accessible : true : aucune vérification d'accessibilité ne se fera
				System.out.println(field.get(product));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		System.out.println("__________ createInstance __________");

		try {
			Product p = metadata.newInstance();
			System.out.println(p);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println("__________ getSimpleName __________");

		System.out.println("simple name " + metadata.getSimpleName());
		System.out.println("name " + metadata.getName());

		System.out.println("__________ CsvToolsGen.toCsv __________");
		
		List<Product> productList = InitialData.productList;
		try {
			CsvToolsGen.toCsv("productGen.csv", productList, ";", Product.class);
		} catch (IOException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		List<Personne> personneList = new ArrayList<Personne>(
				Arrays.asList(new Personne(1, "Janet", "Sylvain", 30), new Personne(2, "Truc", "Bidule", 20)));
		try {
			CsvToolsGen.toCsv("personneGen.csv", personneList, ";", Personne.class);
		} catch (IllegalArgumentException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("__________ CsvToolsGen.fromCsv __________");
		
		try {
			List<Product> productList2 = CsvToolsGen.fromCsv("productGen2.csv", ";", Product.class);
			GenericFunctions.displayList(productList2);
		} catch (InstantiationException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}

		try {
			List<Personne> personneList2 = CsvToolsGen.fromCsv("personneGen2.csv", ";", Personne.class);
			GenericFunctions.displayList(personneList2);
		} catch (InstantiationException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}

	}

}
