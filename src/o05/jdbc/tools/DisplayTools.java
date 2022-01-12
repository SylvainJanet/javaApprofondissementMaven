package o05.jdbc.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Personne;

public class DisplayTools {

	public static void printPersonne(Connection cnx) throws SQLException {
		List<Personne> list = new ArrayList<Personne>();

		String sql = "SELECT * FROM personne";
		PreparedStatement ps = cnx.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Personne p = new Personne();

			long id = rs.getLong("id");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			int age = rs.getInt("age");

			p.setId(id);
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setAge(age);
			list.add(p);
		}

		for (Personne personne : list) {
			System.out.println(personne);
		}
	}
}
