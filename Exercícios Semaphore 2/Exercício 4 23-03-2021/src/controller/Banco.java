//Um banco deve controlar Saques e Dep�sitos.
//O sistema pode permitir um Saque e um Dep�sito
//Simult�neos, mas nunca 2 Saques ou 2 Dep�sitos Simult�neos.
//Para calcular a transa��o (Saque ou Dep�sito), o m�todo deve
//receber o c�digo da conta, o saldo da conta e o valor a ser transacionado.
//Deve-se montar um sistema que deve considerar que 20
//transa��es simult�neas ser�o enviadas ao sistema
//(aleatoriamente essas transa��es podem ser qualquer uma das
//op��es) e tratar todas as transa��es, de acordo com as regras acima.
package controller;

import java.util.concurrent.Semaphore;

public class Banco extends Thread {
	private int idConta, tipo, saldo, valor;
	private Semaphore semaforo1, semaforo2;

	public Banco (int idConta, int tipo, int saldo, int valor, Semaphore semaforo1, Semaphore semaforo2) {
		this.idConta = idConta;
		this.tipo = tipo;
		this.saldo = saldo;
		this.valor = valor;
		this.semaforo1 = semaforo1;
		this.semaforo2 = semaforo2;
	}
	
	@Override
	public void run() {
		if (tipo%2 == 0) {
			try {
				semaforo1.acquire();
				saques();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo1.release();
			}
		}else {
			try {
				semaforo2.acquire();
				depositos();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo2.release();
			}
		}
	}

	private void saques() {
			System.out.println("#"+idConta+" Est� efetuando o saque... Seu saldo atual � => " + saldo);
			saldo = saldo - valor;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#"+idConta+" J� efetuou o saque. Seu saldo atual agora � => " + saldo);
	}

	private void depositos() {
			System.out.println("#"+idConta+" Est� efetuando o dep�sito... Seu saldo atual � => " + saldo);
			saldo = saldo + valor;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#"+idConta+" J� efetuou o dep�sito. Seu saldo atual agora � => " + saldo);
	}	
}
