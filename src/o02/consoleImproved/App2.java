package o02.consoleImproved;

import java.util.List;
import java.util.Scanner;

import classes.Cart;
import classes.CartLine;
import classes.Product;
import o01.console.tools.InitialData;
import o02.consoleImproved.tools.DisplayConsoleTools2;
import o02.consoleImproved.tools.InputTools;

public class App2 {

	private static List<Product> productList;
	private static Cart cart;

	public static void main(String[] args) {
		// Exercice : en utilisant le nouveau modèle objet, refaire
		// un menu de gestion de panier

		// cette fois, faire les vérifications d'input utilisateur
		// et utiliser ce modèle pour éviter les lignes doublons
		// et pouvoir afficher aisémment le montant total du panier

		// ex :
		// Panier_________
		// Ordinateur Qty : 3 Prix unitaire : 500 Prix total : 1500
		// Souris Qty : 2 Prix unitaire : 20 Prix total : 40
		// Prix total - 1540

//		CartLine cl1 = new CartLine();
//		CartLine cl2 = new CartLine();

		// cl1 == cl2 compare les adresses mémoire
		// cl1.equals(cl2); // utilise la méthode equals (par défaut compare les
		// adresses mémoire)

//		int var = 0;
//		String ternaire = var == 0 ? "Mon integer est égal à 0" : "Mon integer n'est pas égal à 0";
//		// raccourci pour :
////		if (var == 0) {
////			ternaire = "Mon integer est égal à 0";
////		} else {
////			ternaire = "Mon integer n'est pas égal à 0";
////		}
//		System.out.println(ternaire);

		productList = InitialData.productList;
		cart = new Cart();

		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {
			DisplayConsoleTools2.displayProducts(productList);
			DisplayConsoleTools2.displayMenu(cart);
			choice = InputTools.readBoundedInt(sc, "Votre choix ?", 1, 4);
			switch (choice) {
			case 1:
				addProduct(sc);
				break;
			case 2:
				removeProduct(sc);
				break;
			case 3:
				DisplayConsoleTools2.displayCart(cart);
				// exercice : redéfinir les méthodes toString de cart et cartLine
				// pour avoir un affichage plus beau
				break;
			case 4:
				System.out.println("Au revoir !");
				break;
			}
		} while (choice != 4);

//			Menu _________________________
//			1 - Ajouter au panier
//			2 - Supprimer le produit
//			3 - Afficher le panier (3 articles)
//			4 - Quitter

		sc.close();
	}

	private static void removeProduct(Scanner sc) {
		int codeProd = InputTools.readBoundedInt(sc, "Quel produit ?", 1, productList.size());
		// exercice : créer la méthode readPositiveInt
		// int qty = InputTools.readPositiveInt(sc, "Combien ?");
		int qty = InputTools.readInt(sc, "Combien ?");

		Product pToAdd = productList.get(codeProd - 1);

		cart.removeLine(new CartLine(pToAdd, qty));
	}

	private static void addProduct(Scanner sc) {
		int codeProd = InputTools.readBoundedInt(sc, "Quel produit ?", 1, productList.size());
		int qty = InputTools.readInt(sc, "Combien ?");

		Product pToAdd = productList.get(codeProd - 1);

		cart.addLine(new CartLine(pToAdd, qty));

	}

}
