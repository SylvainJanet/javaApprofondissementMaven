package o03.javaSwing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstWindow extends JFrame {

	private static final long serialVersionUID = -3555632684934130789L;

	/*
	 * 
	 * Swing c'est une API, une bibliothèque incluse dans Java qui permet de créer
	 * des interfaces graphiques.
	 * 
	 * Dans un premier temps, Java proposait l'API AWT, inclus dans le package
	 * java.awt.
	 * 
	 * Awt utilisait beaucoup de fonctions du système d'exploitation pour générer
	 * l'affichage -> problème : affichage potentiellement différent en fonction de
	 * l'OS, ça concernait beaucoup la taille et le positionnement des différents
	 * éléments.
	 * 
	 * Swing a été conçu pour palier à ce problème en étant écrite entièrement en
	 * Java et en utilisant au minimum les fonctions système. Quelques fenêtres et
	 * boîtes de dialogues qui sont en relation avec l'OS
	 * 
	 * Tous les éléments de Swing font partie d'un package : javax.swing Certains
	 * éléments de AWT sont encore utilisés. Néanmoins, ne pas faire de mélange
	 * 
	 * La classe de base d'une application est la classe JFrame. (en réalité il y a
	 * aussi JWindow et JApplet pour des webapp)
	 * 
	 */

	public FirstWindow() {
		super("Titre de la fenêtre");

		// par défaut, visible est à false et rien ne sera affiché
		setVisible(true);

		setSize(800, 600);

		// concept : conteneur

		/*
		 *
		 * Un conteneur est un objet qui permet de regrouper différents composants
		 * graphiques. Le plus simple : JPanel Il en existe : - un qui permet de
		 * rajouter des barres de défilement - un qui permet d'utiliser un système
		 * d'onglets - un qui permet de regrouper 2 composant en laissant la possibilité
		 * à l'utilisateur de modifier leur taille.
		 * 
		 * Un conteneur est lui même un composant graphique : par conséquent, un
		 * conteneur peut lui même contenir d'autres conteneurs.
		 * 
		 */

		JPanel panel = new JPanel();

		// concept : composant
		// composants : différents éléments graphiques qui composent notre application
		// par exemple :
		// JLabel : un label du texte
		// JButton : un bouton

		JLabel lblAppuyezSurLe = new JLabel("Appuyez sur le bouton");
		lblAppuyezSurLe.setBounds(36, 27, 552, 123);

		JButton button = new JButton();
		button.setBounds(321, 194, 306, 123);
		button.setText("Appuyez sur ce bouton");
		panel.setLayout(null);

		panel.add(lblAppuyezSurLe);
		panel.add(button);

		setContentPane(panel);
	}

	public static void main(String[] args) {
		FirstWindow.setDefaultLookAndFeelDecorated(true);
		FirstWindow firstWindow = new FirstWindow();
	}
}
