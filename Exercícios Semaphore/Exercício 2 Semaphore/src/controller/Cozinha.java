package controller;

import java.util.concurrent.Semaphore;

public class Cozinha extends Thread {
	private int tipo;
	private int idPrato;
	private Semaphore semaforo;
	
	
	public Cozinha(int tipo, int idPrato, Semaphore semaforo) {
		this.tipo = tipo;
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		Cozimento();
//		----Início Sessão Crítica----
		try {
			semaforo.acquire();
			Entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
	}

	private void Cozimento() {
		if(tipo==1) {
//		0,5 a 0,8 segundos para ficar prontos.
			int tempoTotal = (int)((Math.random() * 301)+ 500);
			double y = 0.0;
			int sla = 0;
			int tempo = 100;
			System.out.println("#"+idPrato+" Sopa de Cebola iniciou seu cozimento.");
			while (sla < tempoTotal) {
				y = (100*sla)/tempoTotal;
				sla += tempo; 
				System.out.println("#"+idPrato+" Sopa de Cebola "+y+"% para ficar pronta.");
				try {
					sleep(sla);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("#"+idPrato+" Sopa de Cebola está pronta!");
		}else {
//			0,6 a 1,2 segundos para ficar prontos.
			int tempoTotal2 = (int)((Math.random() * 601)+ 600);
			double x = 0.0;
			int sla2 = 0;
			int tempo2 = 100;
			System.out.println("#"+idPrato+" Lasanha a Bolonhesa iniciou seu cozimento.");
			while (sla2 < tempoTotal2) {
				x = (100*sla2)/tempoTotal2 ;
				sla2 += tempo2; 
				System.out.println("#"+idPrato+" Lasanha a Bolonhesa "+x+"% para ficar pronta.");
				try {
					sleep(sla2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("#"+idPrato+" Lasanha a Bolonhesa está pronta!");
		}
		
	}
	
	private void Entrega() {
		if(tipo == 1) {
			System.out.println("#"+idPrato+" Sopa de Cebola Entregue.");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("#"+idPrato+" Lasanha a Bolonhesa Entregue.");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
