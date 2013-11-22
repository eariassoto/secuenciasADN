package secuenciasADN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Almacenamiento {

	public String leerSecuencia() {
		String s = "";
		Scanner scanner;
		try {
			scanner = new Scanner(new File("secuencia.txt"));
			s = scanner.useDelimiter("\\A").next();
			scanner.close();
		} catch (FileNotFoundException e) {
		}
		// analiza con expresiones regulares las bases permitidas
		// TODO hacerlo mas bonito con parametros y un vector
		return (s.length() % 2 == 0 && Pattern.matches("[A,T,G,C,U]+", s)) ? s : "";
	}

	public void saveSecuencia(String s) {
		PrintWriter out;
		try {
			out = new PrintWriter("secuencia.txt");
			out.println(s);
			out.close();
		} catch (FileNotFoundException e) {
		}
	}

}
