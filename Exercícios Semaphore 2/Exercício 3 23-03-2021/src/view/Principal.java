//Voc� foi contratado para automatizar um treino de F�rmula 1.
//As regras estabelecidas pela dire��o da provas s�o simples:
//�No m�ximo 5 carros das 7 escuderias (14 carros no total)
//presentes podem entrar na pista simultaneamente, mas apenas
//um carro de cada equipe. O segundo carro deve ficar � espera,
//caso um companheiro de equipe j� esteja na pista. Cada piloto
//deve dar 3 voltas na pista. O tempo de cada volta dever� ser
//exibido e a volta mais r�pida de cada piloto deve ser
//armazenada para, ao final, exibir o grid de largada, ordenado
//do menor tempo para o maior.�

package view;

import java.util.concurrent.Semaphore;

import controller.Pista;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(5);	
		
		for (int i = 0; i < 7; i++) {
			Pista p = new Pista(i+1, semaforo);
			p.start();		
		}
		
	}

}
