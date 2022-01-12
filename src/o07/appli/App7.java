package o07.appli;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.Product;

public class App7 extends JFrame {

	private static final long serialVersionUID = 2650007083401571064L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JList<Product> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App7 frame = new App7();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Gestion des produits");

		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Quitter");

		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(307, 11, 117, 217);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 50, 50));

		JButton btnNewButton = new JButton("Ajouter");

		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Retirer");

		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Afficher");

		panel.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("Search :");
		lblNewLabel.setBounds(10, 11, 50, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();

		textField.setBounds(70, 8, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Liste des produits");
		lblNewLabel_1.setBounds(180, 11, 117, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Votre panier est vide");
		lblNewLabel_2.setBounds(10, 214, 196, 14);
		contentPane.add(lblNewLabel_2);

		list = new JList<Product>();
		list.setBounds(20, 36, 247, 157);
		contentPane.add(list);
	}

}
