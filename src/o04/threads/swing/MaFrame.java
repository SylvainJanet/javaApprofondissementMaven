package o04.threads.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * 
		 * Toutes les opérations swing sont faites sur un thread
		 * qui s'appelle l'EDT (event dispatching thread).
		 * Si un traitement dans notre programme prend du temps,
		 * tout l'interface serait bloquée.
		 * 
		 * La solution pour éviter ça est d'effectuer les opérations
		 * sur un autre thread, pour que l'interface reste active.
		 * EventQueue.invokeLater permet de mettre un certains traitement
		 * en fin de liste de tous les traitements à effectuer sur l'EDT
		 * 
		 * En Swing, si vous voulez faire des threads, utilisez l'EDT 
		 * et ne manipulez pas votre application depuis un autre thread,
		 * sinon il y a des risques de problèmes. Utilisez EventQueue.invokeLater(...)
		 * 
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaFrame frame = new MaFrame();
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
	public MaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
