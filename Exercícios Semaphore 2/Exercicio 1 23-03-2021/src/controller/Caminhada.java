//4 pessoas caminham, cada uma em um 
//corredor diferente. Os 4 corredores terminam 
//em uma única porta. Apenas 1 pessoa pode 
//cruzar a porta, por vez. Considere que cada 
//corredor tem 200m. e cada pessoa anda de 4 a 
//6 m/s. Cada pessoa leva de 1 a 2 segundos 
//para abrir e cruzar a porta. Faça uma 
//aplicação em java que simule essa situação.
package controller;

import java.util.concurrent.Semaphore;

public class Caminhada extends Thread {
	private int idPessoa;
	private Semaphore semaforo;
	
	
	public Caminhada(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		corredor();
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}

	private void corredor() {
		int distPercorrida = 0;
		int deslocamento;
		int tempo = 1000;
		while (distPercorrida < 200) {
			deslocamento = (int)((Math.random()*2.1)+4);
			distPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(distPercorrida >= 200) {
				System.out.println("A pessoa " +idPessoa+" já andou 200m.");
			}else {
				System.out.println("A pessoa " +idPessoa+" já andou " + distPercorrida+"m.");
			}
		}
	}

	private void porta() {
		int time =  (int)((Math.random()*1001)+1000);
		System.out.println("A pessoa " + idPessoa + " está passando pela porta.");
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A pessoa " + idPessoa + " passou pela porta.");
	}
}
