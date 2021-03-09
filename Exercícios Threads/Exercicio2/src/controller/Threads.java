//2) Fazer uma aplicação que rode 5 Threads que
//cada uma delas imprima no console o seu número.
package controller;

public class Threads extends Thread {
	private int a, b, c, d, e, x;
	
	public Threads(int a, int b, int c, int d, int e, int x) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.x = x;
	}
	
	@Override
	public void run() {
		borave();
	}

	private void borave() {
		switch (x) {
		case 1:
			System.out.println("TID #" + getId()+" " + a);			
			break;
		case 2:
			System.out.println("TID #" + getId()+" " + b);
			break;
		case 3:
			System.out.println("TID #" + getId()+" " + c);
			break;
		case 4:
			System.out.println("TID #" + getId()+" " + d);
			break;
		case 5:
			System.out.println("TID #" + getId()+" " + e);
			break;
		}

	}
	
}
