//Você foi contratado para automatizar um treino de Fórmula 1.
//As regras estabelecidas pela direção da provas são simples:
//“No máximo 5 carros das 7 escuderias (14 carros no total)
//presentes podem entrar na pista simultaneamente, mas apenas
//um carro de cada equipe. O segundo carro deve ficar à espera,
//caso um companheiro de equipe já esteja na pista. Cada piloto
//deve dar 3 voltas na pista. O tempo de cada volta deverá ser
//exibido e a volta mais rápida de cada piloto deve ser
//armazenada para, ao final, exibir o grid de largada, ordenado
//do menor tempo para o maior.”
package controller;

import java.util.concurrent.Semaphore;

public class Pista extends Thread {
	private int idEscuderia;
	private Semaphore semaforo;
	static int podio[] = new int [14], tempo[] = new int [14], pos=0;
	Semaphore semaforo1 = new Semaphore(1);
	Semaphore semaforo2 = new Semaphore(1);
	Semaphore semaforo3 = new Semaphore(1);
	Semaphore semaforo4 = new Semaphore(1);
	Semaphore semaforo5 = new Semaphore(1);
	Semaphore semaforo6 = new Semaphore(1);
	Semaphore semaforo7 = new Semaphore(1);
	
	public Pista (int idEscuderia, Semaphore semaforo) {
		this.idEscuderia = idEscuderia;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			switch (idEscuderia) {
			case 1:
				try {
					semaforo1.acquire();
					int esc1 [] = {11, 111};
					voltas(esc1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo1.release();
				}
				break;
			case 2:
				try {
					semaforo2.acquire();
					int esc2 [] = {22, 222};
					voltas(esc2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo2.release();
				}
				break;
			case 3:
				try {
					semaforo3.acquire();
					int esc3 [] = {33, 333};
					voltas(esc3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo3.release();
				}
				break;
			case 4:
				try {
					semaforo4.acquire();
					int esc4 [] = {44, 444};
					voltas(esc4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo4.release();
				}
				break;
			case 5:
				try {
					semaforo5.acquire();
					int esc5 [] = {55, 555};
					voltas(esc5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo5.release();
				}
				break;
			case 6:
				try {
					semaforo6.acquire();
					int esc6 [] = {66, 666};
					voltas(esc6);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo6.release();
				}
				break;
			case 7:
				try {
					semaforo7.acquire();
					int esc7 [] = {77, 777};
					voltas(esc7);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo7.release();
				}
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}	
	}
	
	private void voltas(int[] esc) {
		for(int i = 0; i < 2; i++) {
			System.out.println("O carro "+ esc[i] +" da escuderia " + idEscuderia + " entrou na pista.");
			int x = 0, z = 200;
			while ( x < 3) {
				int time = (int)((Math.random()* 61)+60);
				try {
					sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				x++;
				System.out.println("O carro "+ esc[i] +" da escuderia " + idEscuderia + " deu a " +x+ "ª volta em "+time+"ms.");
				if(time < z) {
					z = time;
				}
			}
			System.out.println("O carro "+ esc[i] +" da escuderia " + idEscuderia + " terminou o percurso.");		
			if (pos == 13) {
				podio[pos]= esc[i];	
				tempo[pos]= z;
				pos++;
				classificacao();
			}else {
				podio[pos]= esc[i];	
				tempo[pos]= z;
				pos++;
			}			
		}
	}

	private void classificacao() {
		for(int i = 0; i < 13; i++){
			for(int j = i+1; j < 14 ; j++){
				if(tempo[i] > tempo[j]){
					int aux = tempo[i];
					tempo[i] = tempo[j];
					tempo[j] = aux;
					int aux2 = podio[i];
					podio[i] = podio[j];
					podio[j]= aux2;
				}
			}
		}
		for (int i = 0; i < 14; i++) {
			System.out.println("O carro "+ podio[i]+" vai largar em " + (i+1) + "º lugar, tendo sua volta mais rápida em " + tempo[i]+"ms.");
		}
	}
}
