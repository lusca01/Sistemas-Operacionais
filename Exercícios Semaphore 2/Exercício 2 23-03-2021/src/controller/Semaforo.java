package controller;

import java.util.concurrent.Semaphore;

public class Semaforo extends Thread{
	private int idSentido;
	private Semaphore semaforo;
	
	public Semaforo( int idSentido, Semaphore semaforo) {
		this.idSentido = idSentido;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}

	private void cruzamento() {
		switch (idSentido) {
		case 1:
			System.out.println("O carro que está vindo do sul está passando...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro que estava vindo do sul passou.");
			break;
		case 2:
			System.out.println("O carro que está vindo do norte está passando...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro que estava vindo do norte passou.");
			break;
		case 3:
			System.out.println("O carro que está vindo do leste está passando...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro que estava vindo do leste passou.");
			break;
		case 4:
			System.out.println("O carro que está vindo do oeste está passando...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro que estava vindo do oeste passou.");
			break;
		default:
			break;
		}
	}
}