package o05.jdbc.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
//		String url = "jdbc:postgresql://localhost:5432/dbFormationJavaApp20220110";
//		String user = "postgres";
//		String pwd = "admin";
//		Connection cnx = DriverManager.getConnection(url, user, pwd);
//		return cnx;
		/*
		 * Soucis de sécurité : on a écrit le mot de passe dans le code Java Mais il est
		 * possible que quelqu'un de mal intentionné décompile le code java et récupère
		 * les valeurs.
		 * 
		 * On va préférer utiliser un fichier dbconfig.properties qui contiendra les
		 * informations.
		 * 
		 * On a notre code, on le compile en JAR, ou en WAR (ou autre) qu'on distribue à
		 * tous nos clients on leur donne un fichier dbconfig avec des informations de
		 * connexion propre à chaque client et du côté du SGBD, chaque client a ses
		 * identifiants et on restreint leur accès à la base de données
		 * 
		 */
		Class.forName("org.postgresql.Driver");

		Properties props = new Properties();
		props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconfig.properties"));

		String url = props.getProperty("url");
		String user = props.getProperty("user");
		String pwd = props.getProperty("pwd");

		Connection cnx = DriverManager.getConnection(url, user, pwd);

		return cnx;
	}
}
