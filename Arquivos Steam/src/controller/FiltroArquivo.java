package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltroArquivo {
	
	public void readFile(String path, String nome, String ano, String mes, String media) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			System.out.println("Nome do jogo \t Média de jogadores ativos");
			while(linha != null) {
				String[] vetor = linha.split(",");
				if(vetor[1].contains(ano) && vetor[2].contains(mes) && (Double.parseDouble(vetor[3]) >= (Double.parseDouble(media)))) {
					System.out.println(vetor[0] + "\t" + vetor[3]);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("Arquivo Inválido");
		}
	}
}
