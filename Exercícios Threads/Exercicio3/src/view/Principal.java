//2) Fazer uma aplicação que insira números
//aleatórios em uma matriz 3 x 5 e tenha 3
//Threads, onde cada Thread calcula a soma dos
//valores de cada linha, imprimindo a identificação
//da linha e o resultado da soma.

package view;
import java.util.Random;

import controller.Threads;
public class Principal {

	public static void main(String[] args) {
		int matriz [][] = new int [3][5], i;
		Random aleatorio = new Random();

		for (i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				matriz [i][j] = aleatorio.nextInt(100); //Limitei até 99 para não dar números gigantescos
//				System.out.println(matriz [i][j]); Caso queira ver os números gerados.
			}
//			System.out.print("\n");
		}
		
		for (i = 0; i < 3 ; i++) {
			Thread calc = new Threads(matriz, i);
			calc.start();
		}
		
	}

}
