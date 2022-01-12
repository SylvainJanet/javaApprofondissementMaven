package o07.appli.frames;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditProduct extends JDialog {

	private static final long serialVersionUID = 348206367244803081L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProduct frame = new EditProduct(null);
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
	public EditProduct(Dialog d) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(35, 69, 70, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(35, 134, 46, 14);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(137, 66, 189, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(137, 131, 189, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(335, 227, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setBounds(237, 227, 89, 23);
		getContentPane().add(btnNewButton_1);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}
}
