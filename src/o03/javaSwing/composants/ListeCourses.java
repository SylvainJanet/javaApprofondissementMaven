package o03.javaSwing.composants;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import classes.Cart;
import classes.CartLine;
import classes.Product;
import o01.console.tools.InitialData;

public class ListeCourses extends JFrame {

	private static final long serialVersionUID = -8432415818559382674L;
	private JPanel contentPane;
	private List<Product> products;
	private Cart cart = new Cart();
	private JLabel lblNewLabel;
	private JList<Product> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ListeCourses frame = new ListeCourses();
				frame.setVisible(true);
			}
		});
	}

	private void refreshCartCount() {
		String text = null;
		int count = cart.count();
		if (count == 0) {
			text = "Votre panier est vide";
		} else {
			text = "Votre panier contient ";
			text += count;
			text += count == 1 ? " produit" : " produits";
		}
		lblNewLabel.setText(text);
	}

	private void addProduct() {
		if (list.getSelectedIndex() != -1) {
			String qtyStr = JOptionPane.showInputDialog(this, "Combien voulez vous ajouter ?",
					"Nombre de produit à ajouter");
			try {
				int qty = Integer.parseInt(qtyStr);
				Product pToAdd = list.getSelectedValue();
				cart.addLine(new CartLine(pToAdd, qty));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void removeProduct() {
		if (list.getSelectedIndex() != -1) {
			Product pToRemove = list.getSelectedValue();
			if (cart.getLines().contains(new CartLine(pToRemove, 1))) {
				String qtyStr = JOptionPane.showInputDialog(this, "Combien voulez vous retirer ?",
						"Nombre de produit à retirer");
				try {
					int qty = Integer.parseInt(qtyStr);
					cart.removeLine(new CartLine(pToRemove, qty));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Le produit n'est pas dans la liste !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	/**
	 * Create the frame.
	 */
	public ListeCourses() {
		products = InitialData.productList;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(228, 11, 196, 239);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 50, 50));

		JButton btnNewButton_1 = new JButton("Ajouter au panier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct();
				refreshCartCount();
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Retirer du panier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProduct();
				refreshCartCount();
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Afficher le panier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cart.count() == 0) {
					JOptionPane.showMessageDialog(ListeCourses.this, "Votre panier est vide !");
				} else {
					// JOptionPane.showMessageDialog(ListeCourse.this,
					// myCart.toString().replace("\t", " "));
					StringBuilder sb = new StringBuilder();
					sb.append("<html>");
					sb.append("<table><tr><th>Contenu du panier</th><th></th><th></th></tr>");
					sb.append("<tr><td>" + "Description" + "</td><td>" + "Quantité" + "</td><td>" + "Prix"
							+ "</td></tr>");
					for (CartLine l : cart.getLines()) {
						sb.append("<tr><td>" + l.getProduct().getDescription() + "</td><td>" + l.getQty() + "</td><td>"
								+ l.getTotal() + "</td></tr>");
					}
					sb.append("</table>");
					sb.append("<p> -- TOTAL PANIER -- ");
					sb.append(cart.getTotal());
					sb.append("</p>");
					sb.append("</html>");
					JOptionPane.showMessageDialog(ListeCourses.this, sb.toString());
				}
			}
		});
		panel.add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 196, 164);
		contentPane.add(panel_1);

		list = new JList<Product>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setListData(products.toArray(new Product[products.size()]));
		panel_1.add(list);

		lblNewLabel = new JLabel("Votre panier est vide");
		lblNewLabel.setBounds(10, 217, 196, 14);
		contentPane.add(lblNewLabel);
	}

}
