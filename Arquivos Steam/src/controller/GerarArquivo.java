package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GerarArquivo {

	public void createFile(String path, String nome, String ano, String mes) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			String conteudo = geraTxt("C:\\Windows\\Temp","SteamCharts.csv", ano, mes);
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		}else {
			throw new IOException("Diretório Inválido!");
		}
	}

	private String geraTxt(String path, String nome, String ano, String mes) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			StringBuffer buf = new StringBuffer();
			String lin = "";
			while(linha != null) {
				String vetor[] = linha.split(",");
				if(vetor[1].contains(ano) && vetor[2].contains(mes)) {
					lin = vetor[0] + "\t" + vetor[3];
					buf.append(lin + "\t \n");
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			return buf.toString();
		}else {
			throw new IOException("Arquivo Inválido");
		}
	}
}
