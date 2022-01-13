package o06.productDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import classes.Product;
import o05.jdbc.tools.DbConnection;

public class App6 {

	public static void main(String[] args) {
		/*
		 * 
		 * Un DAO (data access object) est un objet qui est responsable de l'accès à une
		 * base de données. C'est lui qui va être responsable d'aller ouvrir la
		 * connexion, créer les requêtes, les envoyer, gérer les ResultSet si il y en
		 * a... Il permet de faire le pont entre notre application et la base de données
		 * 
		 */

		/*
		 * 
		 * Objectif : implémenter toutes les méthodes de ProductDao
		 * 
		 */

		try (Connection cnx = DbConnection.getConnection()) {
			System.out.println("TEST DE PRODUCT DAO");
			System.out.println("______________________________");
			ProductDao dao = new ProductDao();
			System.out.println("______________________findAll_______________________");

			List<Product> lp = dao.findAll(cnx);
			for (Product p : lp) {
				System.out.println(p.toString());
			}

			System.out.println("____________________findAll(0,2)____________________");

			lp = dao.findAll(0, 2, cnx);
			for (Product p : lp) {
				System.out.println(p.toString());
			}

			System.out.println("_______________findByDescription(e)_________________");

			lp = dao.findByDescription("e", cnx);
			for (Product p : lp) {
				System.out.println(p.toString());
			}

			System.out.println("_______________insert(6,Fraise,5)___________________");

			Product fraise = dao.insert(new Product(6, "Fraise", 5), cnx);
			lp = dao.findAll(cnx);
			for (Product p : lp) {
				System.out.println(p.toString());
			}

			System.out.println("______________update(Fraise price 6)________________");

			System.out.println(fraise);
			System.out.println("id de fraise " + fraise.getId());
			fraise.setPrice(6);
			int nb = dao.update(fraise, cnx);
			System.out.println("nb lignes modifiées : " + nb);
			lp = dao.findAll(cnx);
			for (Product p : lp) {
				System.out.println(p.toString());
			}

			System.out.println("__________________delete(Fraise)____________________");

			dao.delete(fraise.getId(), cnx);
			lp = dao.findAll(cnx);
			for (Product p : lp) {
				System.out.println(p.toString());
			}

			System.out.println("______________________count_________________________");

			System.out.println("Nombre d'éléments : " + dao.count(cnx));

			System.out.println("___________________findById(1)______________________");

			Product q = dao.findById(1, cnx);
			System.out.println(q);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

	}

}
