package o05.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import o05.jdbc.tools.DbConnection;
import o05.jdbc.tools.DisplayTools;

public class O4Update {

	public static void main(String[] args) {
		try (Connection cnx = DbConnection.getConnection()) {

			DisplayTools.printPersonne(cnx);

			PreparedStatement ps = cnx.prepareStatement("UPDATE personne SET nom=?, prenom=?, age=? WHERE id=?");

			ps.setString(1, "Nom édité");
			ps.setString(2, "Prénom édité");
			ps.setInt(3, 42);
			ps.setLong(4, 4);

			int nbrLignesModifiees = ps.executeUpdate(); // execute update retourne le nombre de lignes modifiées par
			// la requête

			System.out.println("____ " + nbrLignesModifiees + " valeur modifiée ____");

			DisplayTools.printPersonne(cnx);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
