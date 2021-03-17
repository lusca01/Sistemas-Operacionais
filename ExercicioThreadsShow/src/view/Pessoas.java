package view;
import java.util.concurrent.Semaphore;
import java.util.Random;
import controller.Sistema;

public class Pessoas {

	public static void main(String[] args) {
		int permissao = 1, i;
		Random aleatorio = new Random();		
		Semaphore semaforo = new Semaphore(permissao);
		
		for(i = 1; i <= 300; i++) {
			int ingressos = (aleatorio.nextInt(4)+1);
			Sistema sist = new Sistema(i, ingressos, semaforo);
			sist.start();
		}
	}
}
