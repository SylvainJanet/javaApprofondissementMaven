package o02.consoleImproved.tools;

import java.util.List;

import classes.Cart;
import classes.Product;

public class DisplayConsoleTools2 {

	public static void displayMenu(List<Product> cart) {
		displayMenu(cart.size());
	}

	public static void displayMenu(Cart cart) {
		displayMenu(cart.count());
	}

	public static void displayMenu(int cartLength) {
		// écrire : "sysou" puis faire ctrl + espace pour un raccourci
		System.out.println("Menu_____");
		System.out.println("1 - Ajouter au panier");
		System.out.println("2 - Supprimer un produit du panier");
		System.out.println("3 - Afficher le panier (" + cartLength + " articles)");
		System.out.println("4 - Quitter");
	}

	public static void displayCart(List<Product> cart) {
		if (cart.size() == 0) {
			System.out.println("Votre panier est vide !");
		} else {
			System.out.println("Panier : ");
			for (Product p : cart) {
				System.out.println(p);
			}
		}
	}

	public static void displayCart(Cart cart) {
		if (cart.count() == 0) {
			System.out.println("Votre panier est vide !");
		} else {
			System.out.println("Panier : ");
			System.out.println(cart);
		}
	}

	public static void displayProducts(List<Product> productList) {
		int i = 1;
		for (Product p : productList) {
			System.out.println(i + " - " + p.getDescription() + " : " + p.getPrice());
			i++;
		}

	}
}
