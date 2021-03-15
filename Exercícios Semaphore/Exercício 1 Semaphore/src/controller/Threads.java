package controller;

import java.util.concurrent.Semaphore;

public class Threads extends Thread {
	private int idThread, tipo;
	private Semaphore semaforo;
	
	public Threads(int idThread, int tipo, Semaphore semaforo) {
		this.idThread = idThread;
		this.tipo = tipo;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		Calculos();
//		----Início Sessão Crítica----
		try {
			semaforo.acquire();
			Transação();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			Finalizada();
		}
//		-----Fim Sessão Crítica------
	}

//	TIPO 1 cálculos 0,2 a 1,0 seg | transação 1seg;
//	TIPO 2 cálculos 0,5 a 1,5 seg | transação 1,5seg;
// 	TIPO 3 cálculos 1 a 2 seg 	  | transação 1,5seg;
	private void Calculos() {
		switch (tipo) {
		case 1:
			int time1 =(int) ((Math.random() *800) + 200); 
			System.out.println("#"+idThread+" Está calculando..."+time1/1000+"s.");
			try {
				sleep(time1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			int time2 = (int)((Math.random()* 1001) +500); 
			System.out.println("#"+idThread+" Está calculando..."+time2/1000+"s.");
			try {
				sleep(time2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			break;
		case 3:
			int time3 = (int)((Math.random()*1001)+ 1000);
			System.out.println("#"+idThread+" Está calculando..."+time3/1000+"s.");
			try {
				sleep(time3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}
//	TIPO 1 cálculos 0,2 a 1,0 seg | transação 1seg;
//	TIPO 2 cálculos 0,5 a 1,5 seg | transação 1,5seg;
// 	TIPO 3 cálculos 1 a 2 seg 	  | transação 1,5seg;	
	private void Transação() {
		switch (tipo) {
		case 1:
			int time1 = 1000;
			System.out.println("#"+idThread+" Está fazendo transação..."+time1/1000+"s.");
			try {
				sleep(time1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			double time2 = 1500;
			System.out.println("#"+idThread+" Está fazendo transação..."+time2/1000+"s.");
			try {
				sleep((long) time2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			double time3 = 1500;
			System.out.println("#"+idThread+" Está fazendo transação..."+time3/1000+"s.");
			try {
				sleep((long) time3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
	
	private void Finalizada() {
		System.out.println("#"+idThread+" Terminou a transação...");
	}
}
