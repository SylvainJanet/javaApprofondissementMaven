package classes;

public class CartLine {

	private Product product;
	private int qty;

	public CartLine(Product product, int qty) {
		this.product = product;
		this.qty = qty;
	}

	public CartLine() {
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(product.getDescription()).append("\t").append(qty).append("\t").append(product.getPrice()).append("\t")
				.append(getTotal());
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		CartLine other = (CartLine) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	public double getTotal() {
		return getProduct().getPrice() * getQty();
	}

}
