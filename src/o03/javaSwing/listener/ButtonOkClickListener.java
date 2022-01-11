package o03.javaSwing.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOkClickListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Le bouton a été pressé !");
		
	}

}
