package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManipulaArquivos {
	
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			System.out.println("FOOD NAME \t SCIENTIFIC NAME \t GROUP \t SUB GROUP");
			while(linha != null) {
				if(linha.contains("Fruits")) {
					divideLinha(linha);
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

	public void divideLinha(String frase) {
		String[] vetorPalavras = frase.split(",");
		for (String palavras : vetorPalavras) {
			System.out.print(palavras + "\t");
		}
		System.out.print("\n");
	}
}