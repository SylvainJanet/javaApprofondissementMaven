package classes;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<CartLine> lines;

	public Cart() {
		this.lines = new ArrayList<CartLine>();
	}

	public Cart(List<CartLine> lines) {
		this.lines = lines;
	}

	public List<CartLine> getLines() {
		return lines;
	}

	public void setLines(List<CartLine> lines) {
		this.lines = lines;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Contenu du panier ___________________").append("\n");
		for (CartLine line : lines) {
			sb.append(line.toString()).append("\n");
		}
		sb.append("-- TOTAL PANIER --").append(getTotal());
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
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
		Cart other = (Cart) obj;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		return true;
	}

	public int count() {
		int res = 0;
		for (CartLine cl : lines) {
			res += cl.getQty();
		}
		return res;
	}

	public double getTotal() {
		double res = 0;
		for (CartLine cl : lines) {
			res += cl.getTotal();
		}
		return res;
	}

	public void addLine(CartLine line) {
		int index = lines.indexOf(line);
		// retourne le premier indice d'une ligne l
		// telle que l.equals(line)

		// comme on a redéfini la fonction equals
		// l.equals(line) est vrai si et seulement si
		// l.getProduct().equals(line.getProduct())
		if (index == -1) { // le produit n'est pas dans la liste
			lines.add(line);
		} else {
			lines.get(index).setQty(line.getQty() + lines.get(index).getQty());
		}

	}

	public void removeLine(CartLine line) {
		int index = lines.indexOf(line);
		if (index != -1) {
			int previousQty = lines.get(index).getQty();
			if (previousQty - line.getQty() > 0) {
				lines.get(index).setQty(previousQty - line.getQty());
			} else {
				lines.remove(index);
			}
		}
	}

}
