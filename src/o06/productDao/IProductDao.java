package o06.productDao;

import java.sql.Connection;
import java.util.List;

import classes.Product;

public interface IProductDao {

	List<Product> findAll(Connection cnx);

	List<Product> findAll(int page, int maxByPage, Connection cnx);

	List<Product> findByDescription(String search, Connection cnx);

	Product findById(long id, Connection cnx); // null si produit non existant

	Product insert(Product p, Connection cnx); // renvoie le produit inséré

	int update(Product p, Connection cnx);
	
	int delete(long id, Connection cnx);
	
	long count(Connection cnx); // récupérer le nombre total d'éléments

}
