package desafioum;

import java.util.*;

public class Desafio {
	
	public static List<Integer> indicesMaiusculos(String palavra){
		List<Integer> indicesMaiusculos = new ArrayList<Integer>();
		for (int i = 0; i < palavra.length(); i++) {
			if (Character.isUpperCase(palavra.charAt(i))) {
				indicesMaiusculos.add(i);
			}	
		}
		return indicesMaiusculos;
		
	}
	 
}
