package Listator;

import java.io.File;

public class Exercicio1_1 {
	public static void main(String[] args) {
		validaParametros(args);
		String[] diretorio = new File(args[0]).list(); 
		imprimeArquivos(diretorio);
	}
	
	private static void validaParametros(String[] diretorio) {
	    if(diretorio.length == 0){
	        System.out.println("Nenhum diretório informado");
	    }
	}
	
	private static void imprimeArquivos(String[] diretorio) {
	    for(String arquivo : diretorio){
	        System.out.println(arquivo);
	    }
	}
}



