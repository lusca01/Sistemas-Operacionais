//Para tal, usar uma variável sentido,
//que será alterado pela Thread que
//controla cada carro com a
//movimentação do carro. Quando a
//Thread tiver a possibilidade de ser
//executada, ela deve imprimir em
//console o sentido que o carro está
//passando. Só pode passar um carro
//por vez no cruzamento.
package view;

import java.util.concurrent.Semaphore;

import controller.Semaforo;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idSentido = 1; idSentido < 5; idSentido++) {
			Semaforo s = new Semaforo(idSentido, semaforo);
			s.start();
		}
	}

}
