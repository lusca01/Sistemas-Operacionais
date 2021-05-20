package view;
import java.io.IOException;
import controller.ManipulaArquivos;
public class Main {
	public static void main(String[] args) {
		
		ManipulaArquivos arqCont = new ManipulaArquivos();
		String path = "C:\\Windows\\Temp";
		String nome = "generic_food.csv";
		try {
			arqCont.readFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
}