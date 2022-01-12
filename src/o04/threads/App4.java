package o04.threads;

import o04.threads.runnable.MyRunnable;

public class App4 {

	public static void main(String[] args) {
		/*
		 * 
		 * Un thread est une unité d'exécution faisant partie d'un programme. Cette
		 * unité fonctionne de façon autonome et "parallèlement" à d'autres threads.
		 * 
		 * Si la machine n'a qu'un seul processeur (un seul coeur), le système alloue un
		 * temps de traitement pour chaque thread, et passe d'un thread à l'autre
		 * 
		 * thread 1 ... thread 2 .... thread 4 .... thread 1
		 * 
		 * Illusion de parallélisme. Sur une machine avec plusieurs coeurs, le système
		 * d'exploitation peut effectivement exécuter ces tâches en parallèles.
		 * 
		 * La JVM créé plusieurs threads pour ses propres besoins : le thread
		 * d'exécution du code java, mais aussi d'autres threads pour, par exemple,
		 * l'exécution du ramasse miettes (Garbage Collector)
		 * 
		 * Rappel : son rôle est de gérer la mémoire, de supprimer les objets non
		 * utilisés.
		 * 
		 * Pour créer nos propres Threads, on va avoir besoin de java.lang.Thread et de
		 * java.lang.Runnable
		 * 
		 */

		MyRunnable myRunnable1 = new MyRunnable("1");
		MyRunnable myRunnable2 = new MyRunnable("2");

		myRunnable1.run();
		myRunnable2.run();

		System.out.println("_______Utilisation de threads_______");

		Thread thread = new Thread(myRunnable1);
		Thread thread2 = new Thread(myRunnable2);
		thread.start();
		thread2.start();

		System.out.println("_______");

		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread 3 en cours");
			}

		});

		thread3.start();

		System.out.println("_______");

		Thread thread4 = new Thread(() -> {
			System.out.println("Thread 4 en cours");
		});
		thread4.start();

	}

}
