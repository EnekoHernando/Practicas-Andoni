import java.util.ArrayList;
import java.util.Arrays;

public class Recursividad {
	/**Método invertirFrase, que recibe un String y lo devuelve invertido letra a letra, de forma recursiva. 
	 * @param frase frase a Invertir
	 * @return
	 */
	public String metodoInvertirFrase(String fraseV, String fraseN, int pos) {
		String[] separada = fraseV.split("");
		fraseN+=separada[pos];
		--pos;
		if(pos>=0) fraseN = metodoInvertirFrase(fraseV, fraseN, pos);
		return fraseN;
	}
	
	/**
	 * Método invertirPalabras, que recibe un String y lo devuelve invertido palabra a palabra (considerando los
		separadores habituales espacio, tabulador, salto de línea, símbolos de puntuación), de forma recursiva.
	 * @return 
	 */
	public String invertirPalabras(String frase) {
		ArrayList<String> alfabeto = new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
		String[] fraseSeparada = frase.split("");
		String palabra = "";
		String fraseI="";
		for (int i = 0; i < fraseSeparada.length; i++) {
			if(alfabeto.contains(fraseSeparada[i].toLowerCase())) {
				System.out.println(fraseSeparada[i].toLowerCase());
				System.out.println(alfabeto.contains(fraseSeparada[i].toLowerCase()));
				palabra+=fraseSeparada[i];
			}if(!alfabeto.contains(fraseSeparada[i].toLowerCase())){
				fraseI+=metodoInvertirFrase(palabra, "", palabra.length()-1);
				palabra = "";
				fraseI+=fraseSeparada[i];
			}else if(i==fraseSeparada.length-1) fraseI+=metodoInvertirFrase(palabra, "", palabra.length()-1);

		}
		return fraseI;
	}
	public static void main(String[] args) {
		Recursividad r = new Recursividad();
		String s = "cocaina";
		System.out.println(r.metodoInvertirFrase(s,"",s.length()-1));
		System.out.println(r.invertirPalabras("HOLA MI-Bebe"));
	}
}
