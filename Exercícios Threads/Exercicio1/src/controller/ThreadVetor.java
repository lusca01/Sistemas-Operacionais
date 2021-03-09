//1.Endereço do Github com a resposta do exercício: Criar em java um projeto com uma Thread chamada ThreadVetor, que receba um valor numérico e vetor como parâmetros. V
//Caso o valor numérico seja par, a thread deve percorrer o vetor utilizando uma estrutura for (int i = 0 ; i < vet.length; i++) e contar o tempo para percorrer o vetor.
//Caso o valor numérico seja ímpar, a thread deve percorrer o vetor utilizando uma estrutura foreach e contar o tempo para percorrer o vetor.
//No final, ambas as possibilidades devem apresentar o tempo em segundos. A operação main deve gerar um vetor de 1000 posições com valores aleatórios de 1 a 100. 
//Deve iniciar 2 ThreadVetor e para uma passar o número 1 e o vetor e para a outra, passar o número 2 e o mesmo vetor.
package controller;

public class ThreadVetor extends Thread {
	private int	vetor [];
	private int x = 0;
	
	public ThreadVetor(int x, int[] vetor) {
		this.x = x;
		this.vetor = vetor;
	}
	
	
	public void run() {
		corrida();
	}


	private void corrida() {
		switch (x) {
		case 1:
			double tempoInicial = System.nanoTime();
			for (int i : vetor) {
				vetor[i] = vetor [i];
			}
			double tempoFinal = System.nanoTime();
			
			double tempoTotal = tempoFinal - tempoInicial; 
			
			tempoTotal = (tempoTotal / Math.pow(10, 9));
			System.out.println("Tempo gasto com 'foreach' " +tempoTotal+"s.");	
			break;
		case 2:
			double tempoInicial2 = System.nanoTime();
			for (int i = 0; i < vetor.length; i++) {
				vetor[i] = vetor [i];
			}
			double tempoFinal2 = System.nanoTime();			
			
			double tempoTotal2 = tempoFinal2 - tempoInicial2; 
			
			tempoTotal2 = tempoTotal2 / Math.pow(10, 9);
			System.out.println("Tempo gasto com 'lenght' " +tempoTotal2+"s.");
		default:
			break;
		}
		
	}

}