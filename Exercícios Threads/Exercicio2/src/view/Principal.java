//2) Fazer uma aplicação que rode 5 Threads que
//cada uma delas imprima no console o seu número.
package view;

import controller.Threads;

public class Principal {

	public static void main(String[] args) {
		int a = 5, b = 10, c = 15, d = 20, e = 25;
		for (int x = 0; x <= 5 ; x++) {
			Thread Threads5 = new Threads(a, b, c, d, e, x);
			Threads5.start();
		}
	}

}
