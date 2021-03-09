package controller;

public class Threads extends Thread {
	private int matriz [][];
	private int base;
	
	public Threads (int [][] matriz, int base) {
		this.matriz = matriz;
		this.base = base;
	}
	
	@Override
	public void run() {
		calculos();
	}

	private void calculos() {
		switch (base) {
		case 0:
			int soma = 0;
			for (int j = 0; j < 5; j++) {
				soma = soma + matriz [base][j];
			}
			System.out.println("TID #" + getId()+" " + soma);	
			break;
		case 1:
			int soma2 = 0;
			for (int j = 0; j < 5; j++) {
				soma2 = soma2 + matriz [base][j];
			}
			System.out.println("TID #" + getId()+" " + soma2);	
			break;
		case 2:
			int soma3 = 0;
			for (int j = 0; j < 5; j++) {
				soma3 = soma3 + matriz [base][j];
			}
			System.out.println("TID #" + getId()+" " + soma3);	
			break;
		default:
			break;
		}
		
	}
	
}
