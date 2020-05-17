/* 4 pessoas caminham, cada uma em um corredor diferente. Os 4 corredores terminam em uma única porta.
 * Apenas 1 pessoa pode cruzar a porta por vez. Considere que cada corredor tem 200m e cada pessoa anda
 * de 4 a 6 m/s. Cada pessoa leva de 1 a 2 segundos para cruzar a porta. Faça uma aplicação em java que 
 * simule essa situação.
 */
package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {

	private Semaphore s;
	private String nome;

	public ThreadCorredor(Semaphore semaforo, String nome) {
		this.s = semaforo;
		this.nome = nome;
	}

	@Override
	public void run() {
		percorrer();
		try {
			s.acquire();
			passarPorta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			s.release();
		}

		super.run();
	}

	public void percorrer() {
		int velocidade = (int) ((Math.random() * 3) + 4);
		// int distancia = 200;
		int distanciaPercorrida = 0;

		System.out.println(this.nome + " anda " + velocidade + " metros por segundo");

		while (distanciaPercorrida <= 200) {

			//System.out.println(" falta " + (200 - distanciaPercorrida) + "m " + "para " + this.nome + " chegar a porta");

			distanciaPercorrida += velocidade;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(this.nome + " chegou no fim do corredor");
	}

	public void passarPorta() {
		int tempoAbrirPorta = (int) ((Math.random() * 2) + 1);

		System.err.println(this.nome + " demora " + tempoAbrirPorta + " segundos para abrir e passar pela porta.");

		try {
			Thread.sleep(tempoAbrirPorta * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.nome + " Passou pela porta!");

	}

}