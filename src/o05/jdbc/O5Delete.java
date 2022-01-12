package o05.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import o05.jdbc.tools.DbConnection;
import o05.jdbc.tools.DisplayTools;

public class O5Delete {

	public static void main(String[] args) {
		try (Connection cnx = DbConnection.getConnection()) {

			DisplayTools.printPersonne(cnx);

			PreparedStatement ps = cnx.prepareStatement("DELETE FROM personne WHERE id=?");
			ps.setLong(1, 4);
			ps.executeUpdate();

			System.out.println("_____ valeur effacée ____");

			DisplayTools.printPersonne(cnx);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
