package o03.javaSwing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import o03.javaSwing.composants.Composants;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -7852834356801270791L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Composants");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Composants frame = new Composants(MainWindow.this);
				frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gestion panier");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Quitter");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cliquez sur le bouton");
		lblNewLabel.setBounds(53, 82, 144, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Click me");

		// un écouteur d'évenement est associé à l'objet
		// ici, on a du créer nous même une classe pour définir le comportement de
		// l'écouteur.
		// btnNewButton.addActionListener(new ButtonOkClickListener());

		// on souhaite créer un objet dont la classe implémente une certaine interface
		// localement, c'est à dire avec un comportement qu'on n'utilisera nul part
		// ailleurs
		// dans le programme.

		// au lieu de créer une classe, on peut créer une classe anonyme :
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Le bouton a été pressé !");
				// JOptionPane.showMessageDialog(this, "Message"); // this fait référence à
				// l'objet qu'on est en train de créer, c'est à dire une instance
				// d'une classe anonyme qui implément ActionListener.
				// showMessageDialog attend un Composant -> Erreur
				JOptionPane.showMessageDialog(MainWindow.this, "Message");
				// le contenu du message peut contenir de code html
			}

		});
		// on créer un objet qui implémente une certaine interface : il faut
		// expliciter l'implémentation de toutes les méthodes de l'interface

		// une interface fonctionnelle est une interface qui ne contient qu'une seule
		// fonction
		// pour instancier un objet qui implémente une interface fonctionnelle, on peut
		// utiliser
		// des fonctions lambdas :

//		btnNewButton.addActionListener((ActionEvent e) -> {
//			System.out.println("Bouton pressé !");
//			JOptionPane.showMessageDialog(this,"Bouton pressé !");
//		});

		btnNewButton.setBounds(229, 78, 89, 23);
		contentPane.add(btnNewButton);
	}
}
