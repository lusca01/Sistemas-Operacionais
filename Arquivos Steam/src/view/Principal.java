package view;

import java.io.IOException;
import controller.GerarArquivo;
import controller.FiltroArquivo;

public class Principal {

	public static void main(String[] args) {
		
		FiltroArquivo filtroArq = new FiltroArquivo();
		GerarArquivo bora = new GerarArquivo();
		String path = "C:\\Windows\\Temp";
		String nome = "SteamCharts.csv";
		String nome1 = "Steam.csv";
		String ano = "2020";
		String mes = "June";
		String media = "10000";
		
		/*
		 Pretendia colocar uma forma de receber os dados do usuário
		 para filtrar e tals, mas acabei me enrolando.
		  */
		try {
			filtroArq.readFile(path, nome, ano, mes, media);
			bora.createFile(path, nome1, ano, mes);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
}
