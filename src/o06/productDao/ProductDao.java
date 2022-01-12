package o06.productDao;

import java.sql.Connection;
import java.util.List;

import classes.Product;

public class ProductDao implements IProductDao {

	@Override
	public List<Product> findAll(Connection cnx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll(int page, int maxByPage, Connection cnx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByDescription(String search, Connection cnx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(long id, Connection cnx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product insert(Product p, Connection cnx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Product p, Connection cnx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id, Connection cnx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(Connection cnx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
