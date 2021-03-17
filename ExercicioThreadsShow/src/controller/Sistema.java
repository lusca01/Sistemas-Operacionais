package controller;

import java.util.concurrent.Semaphore;

public class Sistema extends Thread {
	private int pessoa, ingressos;
	static int ingressosGeral = 100;
	private Semaphore semaforo;
	
	public Sistema(int pessoa, int ingressos, Semaphore semaforo) {
		this.pessoa = pessoa;
		this.ingressos = ingressos;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		login();
	}

	private void login() {
		System.out.println("Pessoa "+ pessoa+" está tentando efetuar o login");
		int time =(int)((Math.random()*1951)+50);
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(time < 1000) {
			compra();
		}else {
			System.out.println("Timeout de login! (pessoa "+pessoa+")");
		}
	}

	private void compra() {
		System.out.println("Pessoa " +pessoa+" está no processo de compra");
		int time =(int)((Math.random()*2001)+1000);
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(time < 2500) {
//			<--Início da sessão crítica-->
			try {
				semaforo.acquire();
				validacao();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaforo.release();
//			<--Fim da sessão crítica-->
			}
		}else {
			System.out.println("Timeout de compra! (pessoa "+pessoa+")");
		}
	}

	private void validacao() {
		if (ingressosGeral > 0 && ingressos <= ingressosGeral) {
			ingressosGeral =  ingressosGeral - ingressos;
			System.out.println("Pessoa "+pessoa+ " comprou "+ingressos+" ingressos com sucesso!  | Ingressos restantes:" +ingressosGeral);
		}else {
			System.out.println("Ingressos insuficiente para compra. (Pessoa: "+pessoa+" ingressos:"+ingressos+")" +ingressosGeral);
		}		
	}	
}
