package o05.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import o05.jdbc.tools.DbConnection;

public class O2CreateRow {

	public static void main(String[] args) {
		Connection cnx = null;
		try {
			cnx = DbConnection.getConnection();
			cnx.setAutoCommit(false);
			/*
			 * 
			 * Le DriverManager assure la liaison avec le pilote, c'est lui qu'on peut
			 * utiliser pour obtenir une connexion.
			 * 
			 * On utilise cette connexion pour transmettre des instructions vers la base.
			 * Ces requêtes sont exécutées grâce à une interface Statement Pour les requêtes
			 * avec paramètres : PreparedStatement Pour utiliser des procédures stockées :
			 * CallableStatement
			 * 
			 * Les éventuels enregistrements sont accessibles avec un élement ResultSet
			 * 
			 * INSERT INTO personne (nom, prenom, age) VALUES ("Janet", "Sylvain", 30)
			 * 
			 */

//			String prenom = "Sylvain";
//			String nom = "Janet";
//			int age = 30;
//
//			String sql = "INSERT INTO personne (nom, prenom, age) VALUES ('" + nom + "', '" + prenom + "', " + age + " )";
			// cnx.createStatement().execute(sql);

			// attention aux injections SQL
			// si un utilisateur mal intentionné rentre les informations suivantes :
			// age = 45
			// nom = truc
			// prenom = bidule',20) DELETE FROM personne INSERT INTO personne (nom, prenom,
			// age) VALUES ('Philippe', 'X

			// mon objet String sql sera :
			// INSERT INTO personne (nom, prenom, age) VALUES ('truc', 'bidule',20)
			// DELETE FROM personne
			// INSERT INTO personne (nom, prenom, age) VALUES ('Philippe', 'X', 45 )

			String prenom = "Truc";
			String nom = "Bidule";
			int age = 30;
			// preparedStatement permet de rajouter des paramètres à une requête de manière
			// sécurisée
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO personne (nom, prenom, age) VALUES (?,?,?)");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);

			// deux méthodes utiles : executeQuery et executeUpdate
			// la première retourne des résultats et la seconde n'attends aucune valeur de
			// la DB
			ps.executeUpdate();

			// une transaction est un ensemble d'instructions SQL qui ne sont effectivements
			// appliquées à
			// la base de données uniquement si il n'y a aucune erreur.
			// virement bancaire : 2 étapes
			// 1) retirer le montant du compte débiteur
			// 2) ajouter le montant au compte bénéficiaire
			// si entre l'étape 1) et l'étape 2) il y a un problème
			// ou si il y a un soucis lors de l'étape 2)
			// si on utilise pas de transaction : seule l'étape 1) est faite : problème
			// en utilisant une transaction : en cas d'erreur, rien n'est fait
			// c'est lorsque toutes les instructions se sont produites sans erreurs que les
			// modifications
			// sont effectivement faites en base de données

			/*
			 * 
			 * Vocabulaire : transaction : OK commit : faire un commit sur une transaction
			 * signifie valider tous les changements dans la transaction rollback : faire un
			 * rollback sur la transaction signifie annuler tous les changements de la
			 * transaction
			 * 
			 */

			/*
			 * 
			 * Pour mettre en place des transactions, il faut tout d'abord paramétrer la
			 * connexion qui est par défaut en mode auto-commit. cnx.setAutoCommit(false);
			 * 
			 * on fait ensuite un commit / rollback au moment approprié
			 * 
			 */

			ps.setString(1, "Machin");
			ps.setString(2, "Chose");
			ps.setInt(3, 25);
			
			// ORM que vous allez voir : JPA dont une implémentation est Hibernate
			// JPA est l'interface, Hibernate est l'implémentation
			
			ps.executeUpdate();
			cnx.commit();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			try {
				cnx.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
