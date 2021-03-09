//3) Fazer uma aplicação de uma corrida de sapos, com 5
//Threads, cada Thread controlando 1 sapo. V


//Deve haver um tamanho máximo para cada pulo do sapo (em metros) e a
//distância máxima para que os sapos percorram. V

//A cada salto, um sapo pode dar uma salto de 0 até o tamanho máximo do
//salto (valor aleatório).

//Após dar um salto, a Thread, para cada
//sapo, deve mostrar no console, qual foi o tamanho do salto e
//quanto o sapo percorreu. 

//Assim que o sapo percorrer a
//distância máxima, a Thread deve apresentar que o sapo
//chegou e qual sua colocação.
package controller;

public class Threads extends Thread {
	private int sapo1, sapo2, sapo3, sapo4, sapo5, x, temp;
	private int dist1 = 0, dist2 = 0, dist3 = 0, dist4 = 0, dist5 = 0;
	private int chegada=1;

	public Threads(int sapo1, int sapo2, int sapo3, int sapo4, int sapo5, int x, int dist1, int dist2, int dist3, int dist4, int dist5, int temp, int chegada) {
		this.sapo1 = sapo1;
		this.sapo2 = sapo2;
		this.sapo3 = sapo3;
		this.sapo4 = sapo4;
		this.sapo5 = sapo5;
		this.dist1 = dist1;
		this.dist2 = dist2;
		this.dist3 = dist3;
		this.dist4 = dist4;
		this.dist5 = dist5;
		this.x = x;
		this.temp = temp;
		this.chegada = chegada;
	}
	
	@Override
	public void run() {
		corrida();
	}

	private void corrida() {
		try {
			sleep(1000 * temp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (x) {
		case 1:
			if(dist1 == -5) {
				interrupt();
			}else
				if(dist1 >= 30) {
					System.out.println("O sapo 1 chegou em "+ chegada + "º lugar.");
					interrupt();			
				}else
					if(dist1 <= 30) {
						System.out.println("O salto do sapo 1 foi " + sapo1 + "m. A distância percorrida pelo sapo 1 até agora é "+dist1);	
					}
			break;
		case 2:
			if(dist2 == -5) {
				interrupt();
			}else
				if(dist2 >= 30) {
					System.out.println("O sapo 2 chegou em "+ chegada + "º lugar.");
					interrupt();			
				}else
					if(dist2 <= 30) {
						System.out.println("O salto do sapo 2 foi " + sapo2 + "m. A distância percorrida pelo sapo 2 até agora é "+dist2);	
					}
			break;
		case 3:
			if(dist3 == -5) {
				interrupt();
			}else
				if(dist3 >= 30) {
					System.out.println("O sapo 3 chegou em "+ chegada + "º lugar.");
					interrupt();			
				}else
					if(dist3 <= 30) {
						System.out.println("O salto do sapo 3 foi " + sapo3 + "m. A distância percorrida pelo sapo 3 até agora é "+dist3);	
					}
			break;
		case 4:
			if(dist4 == -5) {
				interrupt();
			}else
				if(dist4 >= 30) {
					System.out.println("O sapo 4 chegou em "+ chegada + "º lugar.");
					interrupt();			
				}else
					if(dist4 <= 30) {
						System.out.println("O salto do sapo 4 foi " + sapo4 + "m. A distância percorrida pelo sapo 4 até agora é "+dist4);	
					}
			break;
		case 5:
			if(dist5 == -5) {
				interrupt();
			}else
				if(dist5 >= 30) {
					System.out.println("O sapo 5 chegou em "+ chegada + "º lugar.");
					interrupt();			
				}else
					if(dist5 <= 30) {
						System.out.println("O salto do sapo 5 foi " + sapo5 + "m. A distância percorrida pelo sapo 5 até agora é "+dist5);	
					}
			break;
		}	
	}
}
