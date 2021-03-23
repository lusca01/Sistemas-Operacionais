//Um banco deve controlar Saques e Depósitos.
//O sistema pode permitir um Saque e um Depósito
//Simultâneos, mas nunca 2 Saques ou 2 Depósitos Simultâneos.
//Para calcular a transação (Saque ou Depósito), o método deve
//receber o código da conta, o saldo da conta e o valor a ser transacionado.
//Deve-se montar um sistema que deve considerar que 20
//transações simultâneas serão enviadas ao sistema
//(aleatoriamente essas transações podem ser qualquer uma das
//opções) e tratar todas as transações, de acordo com as regras acima.
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
			System.out.println("#"+idConta+" Está efetuando o saque... Seu saldo atual é => " + saldo);
			saldo = saldo - valor;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#"+idConta+" Já efetuou o saque. Seu saldo atual agora é => " + saldo);
	}

	private void depositos() {
			System.out.println("#"+idConta+" Está efetuando o depósito... Seu saldo atual é => " + saldo);
			saldo = saldo + valor;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#"+idConta+" Já efetuou o depósito. Seu saldo atual agora é => " + saldo);
	}	
}
