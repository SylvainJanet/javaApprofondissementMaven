package o05.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Personne;
import o05.jdbc.tools.DbConnection;

public class O3Read {

	public static void main(String[] args) {
		Connection cnx = null;
		try {
			cnx = DbConnection.getConnection();

			List<Personne> list = new ArrayList<Personne>();

			String sql = "SELECT * FROM personne"; // ne pas faire ce type de requête
			// si la table explose en taille, la requête va prendre énormément de temps
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

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
