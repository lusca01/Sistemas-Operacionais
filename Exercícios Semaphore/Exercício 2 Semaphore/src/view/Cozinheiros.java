package view;

import java.util.concurrent.Semaphore;

import controller.Cozinha;

public class Cozinheiros {

	public static void main(String[] args) {
		int permissao = 1, tipo;
		
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int i = 1; i < 6; i++) {
			if(i%2==1) {
				tipo = 1;
			}else {
				tipo = 2;
			}
			Cozinha cozinha = new Cozinha(tipo, i, semaforo);
			cozinha.start();
		}

	}

}
