package view;
import javax.swing.JOptionPane;

import controller.Comandos;

public class Main {

	public static void main(String[] args) {
		Comandos com = new Comandos();
		int t; String so = " ";
		do {
			t = Integer.parseInt(JOptionPane.showInputDialog("1 - Identifcar o Sistema Operacinal \n2 - Listar processos em andamento"
					+ "\n3 - MATAR processo pelo PID \n4 - MATAR processo pelo nome \n5 - EXIT \n      :D"));
			switch(t) {
			case 1:
				so = com.identificaSO(); 
				break;
			case 2:
				if(so == " ") {
					JOptionPane.showMessageDialog(null,"Antes de querer listar os processos, identifique o Sistema Operacional.");
				}else {
					com.listaProcessos(so);
				}
				break;
			case 3:
				if(so == " ") {
					JOptionPane.showMessageDialog(null,"Antes de querer MATAR um processo, identifique o Sistema Operacional.");
				}else {
					int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do programa que queira MATAR:"));
					com.matarPID(so, pid);
				}
				break;
			case 4:
				if(so == " ") {
					JOptionPane.showMessageDialog(null,"Antes de querer MATAR um processo, identifique o Sistema Operacional.");
				}else {
					String name = JOptionPane.showInputDialog("Digite o nome do programa que queira MATAR:");
					com.matarNome(so, name);
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Encerrando...");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Op��o digitada inv�lida.");
			}
			
		}while(t != 5);
	}

}
//Fazer, em java, uma aplica��o que liste os processos ativos, permita ao
//usu�rio entrar com o nome ou o PID do processo e o mate.
//A aplica��o dever� funcionar, minimamente em Windows e Linux (Alunos
//com Mac podem fazer para os 3 SO).
//� not�rio que cada SO tem comandos diferentes para as a��es
//supracitadas. Pesquisar os comandos para cada SO.
//A aplica��o dever� ter, no package view, uma classe que tenha um m�todo
//main que d� ao usu�rio a possibilidade de ver os processos ativos ou matar
//os processos (Por Nome ou PID).

