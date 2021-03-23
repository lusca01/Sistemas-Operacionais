//Um banco deve controlar Saques e Depósitos.
//O sistema pode permitir um Saque e um Depósito
//Simultâneos, mas nunca 2 Saques ou 2 Depósitos Simultâneos.
//Para calcular a transação (Saque ou Depósito), o método deve
//receber o código da conta, o saldo da conta e o valor a ser transacionado.
//Deve-se montar um sistema que deve considerar que 20
//transações simultâneas serão enviadas ao sistema
//(aleatoriamente essas transações podem ser qualquer uma das
//opções) e tratar todas as transações, de acordo com as regras acima.
package view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import controller.Banco;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo1 = new Semaphore(1);
		Semaphore semaforo2 = new Semaphore (1);
		Random aleatorio = new Random();
		
		for(int idConta = 1; idConta < 21; idConta++) {
			int tipo = aleatorio.nextInt(100);
			int saldo = aleatorio.nextInt(2000);
			int valor = aleatorio.nextInt(2000);
			
			Banco b = new Banco(idConta, tipo, saldo, valor, semaforo1, semaforo2);
			b.start();
		}
	}

}
