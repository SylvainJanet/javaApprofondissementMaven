package o04.threads.runnable;

public class MyRunnable implements Runnable {

	// il s'agit d'une interface fonctionnelle
	// interface fonctionnelle : interface qui ne contient uniquement une signature
	// de méthode

	// cette interface nous permet de définir le traitement exécuté dans un thread

	private String param;

	public MyRunnable(String param) {
		this.param = param;
	}

	private void afficher(int i) {
		System.out.println(param + " - " +i);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			afficher(i);
			if (i == 10) {
				try {
					System.out.println("PAUSE");
					Thread.sleep(1000); // le thread qui exécute cette ligne de code
					// se met en pause pendant 1000 millisecondes (1 s)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
