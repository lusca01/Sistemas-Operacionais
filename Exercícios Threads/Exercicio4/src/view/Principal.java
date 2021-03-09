//3) Fazer uma aplicação de uma corrida de sapos, com 5
//Threads, cada Thread controlando 1 sapo. Deve haver um
//tamanho máximo para cada pulo do sapo (em metros) e a
//distância máxima para que os sapos percorram. A cada salto,
//um sapo pode dar uma salto de 0 até o tamanho máximo do
//salto (valor aleatório). Após dar um salto, a Thread, para cada
//sapo, deve mostrar no console, qual foi o tamanho do salto e
//quanto o sapo percorreu. Assim que o sapo percorrer a
//distância máxima, a Thread deve apresentar que o sapo
//chegou e qual sua colocação.
package view;
import java.util.Random;

import controller.Threads;

public class Principal {

	public static void main(String[] args) {
		Random aleatorio = new Random();
		int chegada = 1;
		int sapo1 = 0, sapo2 = 0, sapo3 = 0, sapo4 = 0, sapo5 = 0;
		int dist1 = 0, dist2 = 0, dist3 = 0, dist4 = 0, dist5 = 0, i, temporizador = 0;
		
		do {
			
			for(i = 1 ; i < 6 ; i++) {
				Thread run = new Threads(sapo1, sapo2, sapo3, sapo4, sapo5, i, dist1, dist2, dist3, dist4, dist5, temporizador, chegada);
				run.start();
			}
			
			if(dist1 < 30 && dist1 >= 0) {
				sapo1 = aleatorio.nextInt(3);
				dist1 = dist1 + sapo1;					
			}else
				if (dist1 == -5) {
					dist1 = -5;
				}else 
					if(dist1 >= 30) {
						chegada = chegada +1;
						dist1 = -5;
					}
				
			if(dist2 < 30 && dist2 >= 0) {
				sapo2 = aleatorio.nextInt(3);
				dist2 = dist2 + sapo2;
			}else
				if (dist2 == -5) {
					dist2 = -5;
				}else 
					if(dist2 >= 30) {
						chegada = chegada +1;
						dist2 = -5;
					}
			
			if (dist3 < 30 && dist3 >= 0) {
				sapo3 = aleatorio.nextInt(3);
				dist3 = dist3 + sapo3;
			}else
				if(dist3 == -5){
					dist3 = -5;
				}else
					if(dist3 >=30){
						chegada = chegada +1;
						dist3 = -5;
					}
			
			if(dist4 < 30 && dist4 >= 0) {
				sapo4 = aleatorio.nextInt(3);
				dist4 = dist4 + sapo4;				
			}else
				if(dist4 == -5) {
					dist4 = -5;
				}else
					if(dist4 >= 30) {
						chegada = chegada +1;
						dist4 = -5;
					}

			if(dist5 < 30 && dist5 >= 0) {
				sapo5 = aleatorio.nextInt(3);
				dist5 = dist5 + sapo5;
			}else
				if(dist5 == -5) {
					dist5 = -5;
				}else
					if(dist5 >=30) {
						chegada = chegada +1;
						dist5 = -5;
					}
				
			temporizador = temporizador + 1;
		} while (chegada < 6);
	}

}
