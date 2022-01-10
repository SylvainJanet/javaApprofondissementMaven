package classes;

//import classes.exceptions.PriceNegativeException;

public class Product {

	private long id;
	private String description;
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) { // throws PriceNegativeException {
//		if (price < 0) {
//			throw new PriceNegativeException("Le prix d'un produit doit être positif");
//			 checked exceptions : elle doit soit être capturée dans un try / catch
//			 soit être remontée pour que le traitement se fasse lors de l'appel de la
//			 fonction
//		}
		this.price = price;
	}

	public Product() {
	}

	public Product(long id, String description, double price) { // throws PriceNegativeException {
		this.id = id;
		this.description = description;
		this.setPrice(price);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
