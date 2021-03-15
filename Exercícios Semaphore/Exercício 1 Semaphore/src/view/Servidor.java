package view;

import java.util.concurrent.Semaphore;

import controller.Threads;

public class Servidor {

	public static void main(String[] args) {
		int permissao = 1, tipo;
		
		Semaphore semaforo = new Semaphore(permissao);
		for(int i = 1; i < 22; i++) {
			if(i%3==1) {
				tipo = 1;
			}else  
				if(i%3==2) {
					tipo = 2;
				}else {
					tipo = 3;
			}
			Threads servidor = new Threads (i, tipo, semaforo);
			servidor.start();
		}

	}

}
