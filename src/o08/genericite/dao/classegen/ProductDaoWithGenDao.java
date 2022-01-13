package o08.genericite.dao.classegen;

import classes.Product;
import o08.genericite.dao.interfacegen.IProductDaoIGen;

public class ProductDaoWithGenDao extends GenericDao<Product> implements IProductDaoIGen {

	@Override
	public Product onSale(long id, double reductionPercentage) {
		// TODO Auto-generated method stub
		return null;
	}

}
