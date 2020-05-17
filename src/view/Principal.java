package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredor;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);
		String[] nomes = new String[4];

		for (int i = 0; i < nomes.length; i++) {

			nomes[i] = JOptionPane.showInputDialog("Digito o nome da pessoa " + (i + 1));

		}

		for (int i = 0; i < nomes.length; i++) {
			ThreadCorredor tc = new ThreadCorredor(semaforo, nomes[i]);
			tc.start();
		}

	}
}