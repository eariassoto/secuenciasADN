/**
 * @author Emmanuel Arias Soto B30640
 * La clase Almacenamiento se encarga de manejar
 * la lectura y escritura de los archivos necesarios
 * para cargar las secuencias de ADN
 */
package secuenciasADN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Almacenamiento {
	
	/**
	 * Lee un simple archivo txt que contiene la secuencia
	 * de ADN que se debe cargar inicialmente
	 * @return hilera con el contenido del archivo
	 */
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
		return (s.length() % 2 == 0 && Pattern.matches("[A,T,G,C,U]+", s)) ? s : "";
	}

	/**
	 * Guarda la secuencia en el archivo
	 * @param s hilera con la secuencia
	 */
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
