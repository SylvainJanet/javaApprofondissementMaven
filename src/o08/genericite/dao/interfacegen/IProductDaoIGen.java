package o08.genericite.dao.interfacegen;

import classes.Product;

public interface IProductDaoIGen extends IGenericDao<Product> {

	Product onSale(long id, double reductionPercentage);
}
