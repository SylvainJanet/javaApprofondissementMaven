package o06.productDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Product;

public class ProductDao implements IProductDao {

	@Override
	public List<Product> findAll(Connection cnx) throws SQLException {
		List<Product> list = new ArrayList<Product>();

		Statement statement = cnx.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * from product");

		while (rs.next()) {
			Product pToAdd = new Product(rs.getLong("id"), rs.getString("description"), rs.getDouble("price"));
			list.add(pToAdd);
		}

		rs.close();

		return list;
	}

	@Override
	public List<Product> findAll(int page, int maxByPage, Connection cnx) throws SQLException {
		List<Product> list = new ArrayList<Product>();

		String sql = "SELECT * from product ORDER BY id OFFSET ? LIMIT ?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, page * maxByPage); // première page : page = 0
		ps.setInt(2, maxByPage);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Product pToAdd = new Product(rs.getLong("id"), rs.getString("description"), rs.getDouble("price"));
			list.add(pToAdd);
		}

		rs.close();

		return list;
	}

	@Override
	public List<Product> findByDescription(String search, Connection cnx) throws SQLException {
		List<Product> list = new ArrayList<Product>();

		PreparedStatement ps = cnx.prepareStatement("SELECT * from product WHERE description ILIKE ?");
		// ILIKE : compare en ignorant la casse : exclusif à postgres
		ps.setString(1, "%" + search + "%");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Product pToAdd = new Product(rs.getLong("id"), rs.getString("description"), rs.getDouble("price"));
			list.add(pToAdd);
		}

		rs.close();

		return list;
	}

	@Override
	public Product findById(long id, Connection cnx) throws SQLException {
		Product p = null;
		// renvoie null si aucun objet avec l'id spécifié existe dans la base

		PreparedStatement ps = cnx.prepareStatement("SELECT * from product WHERE id = ?");
		ps.setLong(1, id);
		// ILIKE : compare en ignorant la casse : exclusif à postgres

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			p = new Product(rs.getLong("id"), rs.getString("description"), rs.getDouble("price"));
		}

		rs.close();

		return p;
	}

	// insert(new Product(1,"blablabla",58)
	// le produit effectivement inséré en base de données aura un id généré pas la
	// base de données
	// (l'id est de type serial)
	// on veut que la fonction retourne le produit avec le bon id
	@Override
	public Product insert(Product p, Connection cnx) throws SQLException {
		PreparedStatement ps = cnx.prepareStatement("INSERT INTO product (description, price) VALUES (?,?)",
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, p.getDescription());
		ps.setDouble(2, p.getPrice());

		int nbrLignesModifiees = ps.executeUpdate();

		if (nbrLignesModifiees != 0) {
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					p.setId(generatedKeys.getLong(1));
				}
			}
		}

		return p;
	}

	@Override
	public int update(Product p, Connection cnx) throws SQLException {
		PreparedStatement ps = cnx.prepareStatement("UPDATE product SET description = ?, price = ? WHERE id = ?");

		ps.setString(1, p.getDescription());
		ps.setDouble(2, p.getPrice());
		ps.setLong(3, p.getId());

		int nbrLignesModifiees = ps.executeUpdate();

		return nbrLignesModifiees;
	}

	@Override
	public int delete(long id, Connection cnx) throws SQLException {
		PreparedStatement ps = cnx.prepareStatement("DELETE FROM product WHERE id = ?");

		ps.setLong(1, id);

		int nbrLignesSuprimees = ps.executeUpdate();

		return nbrLignesSuprimees;
	}

	@Override
	public long count(Connection cnx) throws SQLException {
		PreparedStatement ps = cnx.prepareStatement("SELECT COUNT(*) FROM product");

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getLong(1);
		}
		rs.close();
		return 0;
	}

}
