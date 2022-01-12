package o07.appli.frames;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GestionAdmin extends JDialog {

	private static final long serialVersionUID = 4079481141425869660L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	private JScrollPane panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAdmin frame = new GestionAdmin(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public GestionAdmin(Frame f) {
		super(f);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		panel = new JScrollPane();
		panel.setBounds(10, 43, 289, 207);
		contentPanel.add(panel);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setRowHeight(20);
		table.setRowMargin(0);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBounds(10, 11, 269, 185);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Id", "Description", "Price" }) {
			private static final long serialVersionUID = -1646094382640529576L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Long.class, String.class, Double.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		});
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setViewportView(table);

		textField = new JTextField();

		textField.setBounds(69, 12, 105, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setBounds(10, 14, 49, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Liste des produits");
		lblNewLabel_1.setBounds(184, 14, 115, 14);
		contentPanel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(309, 11, 115, 239);
		contentPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 50, 50));

		JButton btnNewButton_1 = new JButton("Ajouter");
		panel_1.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Modifier");
		panel_1.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Supprimer");
		panel_1.add(btnNewButton_2);

	}

}
