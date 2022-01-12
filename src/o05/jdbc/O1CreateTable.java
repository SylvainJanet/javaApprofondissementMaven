package o05.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class O1CreateTable {

	/*
	 * 
	 * Une base de données relationnelle est une base de données (ensemble de tables) + des éventuelles
	 * relations entre les tables.
	 * relations :
	 * - one to one : Un objet de type A est associé à un et un seul objet de type B et inversement.
	 * Par exemple : une crâne est associé à un seul cerveau et inversement.
	 * - one to many / many to one : exemple : Une entreprise a plusieurs employés, mais un employé est
	 * associé à une entreprise
	 * - many to many : exemple : un panier est associé à plusieurs produits et un produit est associé à 
	 * plusieurs paniers
	 * 
	 * pour effectuer ses relations, mais aussi pour identifier chaque élément de manière unique, 
	 * on utilise un système de clé primaire (id) ou étrangère.
	 * 
	 * Pour communiquer avec la base de données, on utilise le SQL (structured query langage).
	 * Pourquoi structuré ? Toutes les lignes d'une table on forcément les même colonnes (potentiellement null)
	 * Par exemple, quand on fait du big data (analyse de données en très grande quantité), on peut utiliser des bases 
	 * non structurées et on a besoin d'utiliser d'autres langages pour communiquer
	 * 
	 * Il existe plusieurs SGBD (système de gestion de base de données) mySql, SqlServer, mariaDb, postgreSql,...
	 * On utilise PostGreSQL
	 * 
	 * JDBC : Java DataBase Connectivity est une API qui permet un accès aux bases de données, quel que soit le SGBD.
	 * 
	 * Ces classes sont regroupées dans le package java.sql et incluses dans le jdk.
	 * 
	 * Pour pouvoir utiliser JDBC, il faut un pilote qui est spécifique à la base données à laquelle
	 * on veut accéder.
	 */
	
	public static void main(String[]args) {
		try {
			Class.forName("org.postgresql.Driver"); // voir la documentation du driver spécifique pour avoir le 
			// nom de la classe à utiliser
			/*
			 * 
			 * Class.forName se charge d'aller chercher en mémoire une classe. Le DriverManager s'occupe
			 * automatiquement de charger le pilote et de créer une instance de cette classe.
			 * 
			 */
			
			// connection à la base de données
			String url = "jdbc:postgresql://localhost:5432/dbFormationJavaApp20220110";
			String user = "postgres";
			String pwd = "admin";
			Connection cnx = DriverManager.getConnection(url,user,pwd);
			
			String sql = "CREATE TABLE IF NOT EXISTS personne(" + 
							"id SERIAL PRIMARY KEY, " +  // SERIAL est un type ~AUTOINCREMENT
							"nom varchar(30) NOT NULL, " + 
							"prenom varchar(20) NOT NULL, " + 
							"age int CHECK (age > 0), " + 
							"CONSTRAINT unique_names UNIQUE (nom,prenom)" + 
						")";
			
			cnx.createStatement().execute(sql);
			
			cnx.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
