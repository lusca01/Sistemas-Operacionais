package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Comandos {
	public String identificaSO() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void listaProcessos(String so) {
		if(so.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void matarPID (String so, int pid) {
		if(so.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("TASKKILL /PID "+pid);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				Runtime.getRuntime().exec("kill -9 "+pid);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		listaProcessos(so);
	}
	
	public void matarNome(String so, String name) {
		if(so.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("TASKKILL /IM "+name);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				Runtime.getRuntime().exec("pkill -f "+name);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		listaProcessos(so);
	}
}


//No package controller, deverá ter:
//1) Uma classe que tenha um método que identifique o SO;
//2) Um método que, recebendo o SO, no qual está rodando, como
//parâmetro de entrada, selecione o comando para listar os processos
//ativos;
//3) Um método que, recebendo o SO, no qual está rodando, e o PID do
//processo, como parâmetros de entrada, selecione o comando para
//matar o processo e o finalize;
//4) Um método que, recebendo o SO, no qual está rodando, e o Nome
//do processo, como parâmetros de entrada, selecione o comando
//para matar o processo e o finalize;