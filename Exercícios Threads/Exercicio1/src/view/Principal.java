//1.Endere�o do Github com a resposta do exerc�cio: Criar em java um projeto com uma Thread chamada ThreadVetor, que receba um valor num�rico e vetor como par�metros.
//Caso o valor num�rico seja par, a thread deve percorrer o vetor utilizando uma estrutura for (int i = 0 ; i < vet.length; i++) e contar o tempo para percorrer o vetor.
//Caso o valor num�rico seja �mpar, a thread deve percorrer o vetor utilizando uma estrutura foreach e contar o tempo para percorrer o vetor.
//No final, ambas as possibilidades devem apresentar o tempo em segundos. A opera��o main deve gerar um vetor de 1000 posi��es com valores aleat�rios de 1 a 100. 
//Deve iniciar 2 ThreadVetor e para uma passar o n�mero 1 e o vetor e para a outra, passar o n�mero 2 e o mesmo vetor.

package view;
import java.util.Random;

import controller.ThreadVetor;

public class Principal {

	public static void main(String[] args) {
		int[] vet = new int [1000];
		Random aleatorio = new Random();
		
		for(int i = 0 ; i < 1000 ; i++) {
			vet [i] = aleatorio.nextInt(101);
		}
		
		Thread borave = new ThreadVetor(1, vet);
		Thread borave2 = new ThreadVetor(2, vet);
		borave.start();
		borave2.start();
	}

}
