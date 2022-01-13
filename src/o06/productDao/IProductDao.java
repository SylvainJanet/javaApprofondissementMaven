package o06.productDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import classes.Product;

public interface IProductDao {

	List<Product> findAll(Connection cnx) throws SQLException;

	List<Product> findAll(int page, int maxByPage, Connection cnx) throws SQLException;

	List<Product> findByDescription(String search, Connection cnx) throws SQLException;

	Product findById(long id, Connection cnx) throws SQLException; // null si produit non existant

	Product insert(Product p, Connection cnx) throws SQLException; // renvoie le produit inséré

	int update(Product p, Connection cnx) throws SQLException;
	
	int delete(long id, Connection cnx) throws SQLException;
	
	long count(Connection cnx) throws SQLException; // récupérer le nombre total d'éléments

}
