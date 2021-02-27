package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController controller = new RedesController();
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("1 - IP do Host \n2 - PING do Uol \n3 - EXIT"));
			String os = System.getProperty("os.name");
			switch (op) {
			case 1:
				controller.ip(os);
				break;
			case 2:
				controller.ping(os);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Encerrando...");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Opção inválida.");
			}
		}while (op != 3);
	}
}

//Para auxiliar na resolução dos exercícios:
//para verificar informações de adaptadores ethernet:
//Windows: ipconfig
//Linux: ifconfig
//
//para definir quantidade de pings (-n ou -c é o número de iterações, -4 é para forçar a operação em IPv4):
//Exemplo Windows: ping -4 -n 10 www.uol.com.br
//Exemplo Linux: ping -4 -c 10 www.uol.com.br
//
//para listar os processos:
//Windows: TASKLIST /FO TABLE
//Linux: ps -ef
//star 1 like 1
//para matar processo por PID:
//Windows: TASKKILL /PID numero_do_PID
//Linux: kill -9 numero_do_PID
//like 1
//para matar processo por Nome:
//Windows: TASKKILL /IM nome_do_processo
//Linux: pkill -f nome_do_processo
//like 1

