package o01.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.Product;
import o01.console.tools.DisplayConsoleTools;
import o01.console.tools.InitialData;

public class App1 {

	// prendre java.util.List
	private static List<Product> productList;
	private static List<Product> cart;

	public static void main(String[] args) {
		/*
		 * Raccourci : ctrl + shift + O : rajoute les imports (a priori automatique sur
		 * Eclispe) ctrl + shift + f : mettre en forme le code ctrl + shift + / : mettre
		 * en commentaire / décommenter des lignes ctrl + espace : quick actions ctrl +
		 * alt + flèche du haut ou du bas : dupliquer une ligne
		 */
		Product p = new Product();
		// p.id = 0
		// p.description = null
		// p.price = 0
		p.setDescription("Mon produit");
		// utiliser le setter pour chaque propriété

		Product p2 = new Product(3L, "blabla", 3.5);

		// bonne pratique : faire des vérifications dans les setters, lancer des
		// exceptions
		// dans les cas problématique et les capturer avec un bloc try / catch lorsque
		// c'est
		// nécéssaire
		// à ne pas faire : méthode main(...) throws ....
		// l'objectif étant de ne pas arrêter le programme et de ne pas afficher des
		// exceptions à l'utilisateur mais de faire un traitement spécifique

		// dans ce projet là, pour éviter de perdre du temps, on ne fait de vérification
		// du prix
		productList = InitialData.productList;
		cart = new ArrayList<Product>();

		String choice = "";
		Scanner sc = new Scanner(System.in); // java.utils.Scanner
		do {
			DisplayConsoleTools.displayProducts(productList);
			DisplayConsoleTools.displayMenu(cart);
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				addToCart(sc);
				break;
			case "2":
				removeFromCart(sc);
				break;
			case "3":
				DisplayConsoleTools.displayCart(cart);
				break;
			case "4":
				System.out.println("Au revoir !");
				break;
			}

		} while (choice != "4");
		sc.close();

	}

	private static void removeFromCart(Scanner sc) {
		System.out.println("Quel produit voulez vous supprimer ?");
		int choice = sc.nextInt();
		// vérification à faire si l'utilisateur n'entre pas un entier -> exception
		// lancée par nextInt
		cart.remove(productList.get(choice - 1));
		// à faire : que se passe-t-il si l'élément n'est pas dans la liste de course ?

	}

	private static void addToCart(Scanner sc) {
//		String choiceStr = sc.nextLine();
//		int choiceInt = Integer.parseInt(choiceStr);
		System.out.println("Quel produit voulez vous ajouter ?");
		int choice = sc.nextInt();
		// à faire : le cas où nextInt renvoie une exception (pas un entier)
		cart.add(productList.get(choice - 1));
		// à faire : vérifier que "choice" correspond à un indice (> 0, <= taille de la
		// liste)

	}

}
