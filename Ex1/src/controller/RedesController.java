package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
//O primeiro, chamado ip, que recebe o nome do Sistema Operacional como
//parâmetro e, de acordo com o S.O., faz a chamada de configuração de IP e
//filtra a saída do processo, retornando um String com o nome do Adaptador
//Ethernet e o IPv4 apenas (Não importa o número de adaptadores ethernet,
//devem aparecer todos). Os adaptadores que não tiverem IPv4 não devem
//ser mostrados.	
	public void ip (String so) {
		if (so.contains("Windows")) {
			try {
				Process x = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = x.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if(linha.contains("Ethernet") || linha.contains("IPv4.")) {
					System.out.println(linha);
					}
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
				Process x = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = x.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if(linha.contains("flags=") || linha.contains("inet ")) {
					System.out.println(linha);
					}
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

//	O segundo, chamado ping, que recebe o nome do Sistema Operacional
//	como parâmetro e, de acordo com o S.O., faz a chamada de ping com 10
//	iterações, filtra a saída, pegando apenas o tempo e dá a saída, em ms, do
//	tempo médio do ping. (O endereço para ping, pode ser o
//	www.google.com.br) 
	public void ping (String so) {
		if (so.contains("Windows")){
			try {
				Process x = Runtime.getRuntime().exec("ping -4 -n 10 www.uol.com.br");
				InputStream fluxo = x.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				int c = 0;
				while (c <= 10) {
					String[] tempo = linha.split(" ");
					for (String palavras : tempo) {
						if (palavras.contains("tempo")) {
						System.out.println(palavras);	
						}
					}
					linha = buffer.readLine();
					c++;
				}
				while (linha != null) {
					String[] tempo = linha.split(",");
					for (String palavras : tempo) {
						if (palavras.contains("dia")) {//Coloquei "dia" porque "Média" dá erro no "é"
						System.out.println(palavras);	
						}
					}
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
				Process x = Runtime.getRuntime().exec("ping -4 -c 10 www.uol.com.br");
				InputStream fluxo = x.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				int c = 0;
				while (c <= 10) {
					String[] tempo = linha.split(" ");
					for (String palavras : tempo) {
						if (palavras.contains("tempo")) {
						System.out.println(palavras +"ms");	
						}
					}
					linha = buffer.readLine();
					c++;
				}
				buffer.readLine();
				while (linha != null) {
					if (linha.contains("min/avg")) {
						System.out.println(linha);	
					}
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
}