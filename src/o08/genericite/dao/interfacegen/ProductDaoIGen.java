package o08.genericite.dao.interfacegen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import classes.Product;

public class ProductDaoIGen implements IProductDaoIGen {

	@Override
	public List<Product> findAll(Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll(int page, int maxByPage, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByDescription(String search, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(long id, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product insert(Product p, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Product p, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product onSale(long id, double reductionPercentage) {
		// TODO Auto-generated method stub
		return null;
	}

}
