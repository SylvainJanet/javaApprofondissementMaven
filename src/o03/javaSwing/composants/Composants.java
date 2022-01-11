package o03.javaSwing.composants;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import classes.Product;
import o01.console.tools.InitialData;

public class Composants extends JDialog {

	private static final long serialVersionUID = -494501816599469089L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Composants frame = new Composants(null);
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
	public Composants(JFrame parent) {
		super(parent);
		// dans le constructeur de JDialog, on peut spécifier un composant parent
		// auquel l'utilisateur n'aura pas accès lorsque le JDialog sera instancié
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // la JDialog est fermée
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		// par défaut le JDialog n'est pas modal : la rendre modale
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(130, 11, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setBounds(106, 14, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("=");
		lblNewLabel_1.setBounds(226, 14, 46, 14);
		contentPane.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setBounds(246, 11, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Compute");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String champs1 = textField.getText();
				String champs2 = textField_1.getText();

				try {
					int nbr1 = Integer.parseInt(champs1);
					int nbr2 = Integer.parseInt(champs2);

					int result = nbr1 + nbr2;

					textField_2.setText(String.valueOf(result));

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(Composants.this, "Merci d'entrer des nombres", "Erreur !",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(335, 10, 89, 23);
		contentPane.add(btnNewButton);

		JCheckBox chckbxNewCheckBox = new JCheckBox("décoché");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isSelected = chckbxNewCheckBox.isSelected();
				chckbxNewCheckBox.setText(isSelected ? "coché" : "décoché");
			}
		});
		chckbxNewCheckBox.setBounds(10, 57, 97, 23);
		contentPane.add(chckbxNewCheckBox);

		JList<Product> list = new JList<Product>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				Product p = list.getSelectedValue();

				String description = p.getDescription();

				// mettre la description dans le label
				lblNewLabel_2.setText(description);

			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(28, 97, 286, 66);
		List<Product> prodList = InitialData.productList;
		Product[] prodTab = new Product[prodList.size()];
		for (int i = 0; i < prodTab.length; i++) {
			prodTab[i] = prodList.get(i);
		}
		list.setListData(prodTab);
		contentPane.add(list);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(106, 196, 121, 14);
		contentPane.add(lblNewLabel_2);
	}
}
