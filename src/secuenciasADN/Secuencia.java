/**
 * @author Emmanuel Arias Soto B30640
 * La clase Secuencia controla ambas tiras de ADN
 */
package secuenciasADN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Secuencia {

	Base tira;
	/**
	 * Constructor
	 * @param tira
	 */
	public Secuencia(Base tira) {
		this.tira = tira;
	}

	/**
	 * Como este agrega un par de bases, busca la tira más larga y lo agrega al
	 * final.
	 * 
	 * @param l1
	 *            primera letra (izq)
	 * @param l2
	 *            segunda letra (der)
	 */
	public void agregarPar(char l1, char l2) {
		tira.agregarPar(l1, l2);
	}

	/**
	 * Agrega una base en la posicion indicada
	 * @param pos
	 * @param l1
	 * @param l2
	 */
	public void agregarParEn(int pos, char l1, char l2) {
		tira.agregarParEn(pos, l1, l2);
	}

	/**
	 * Agrega una secuencia desde una hilera con el formato A T A T A T.... etc
	 * donde las A son letras de la tira1 y las T de la tira2 util para cargar
	 * desde archivo
	 * 
	 * PD asuma que la cadena ya ha sido validada con letras PARES, sin espacios
	 * al inicio o final
	 * 
	 * @param s
	 */
	public void inicializaSecuencia(String s) {
		String str = s;
		while (str.length() > 0) {
			agregarPar(str.charAt(0), str.charAt(1));
			str = (str.length() == 2) ? "" : str.substring(2);
		}
	}

	/**
	 * Agrega una secuencia en forma de hilera previamente
	 * validada en la posicion indicada
	 * @param pos posicion
	 * @param s secuencia
	 */
	public void agregarSecuencia(int pos, String s) {
		String str = s;
		int c = 0;
		while (str.length() > 0) {
			agregarParEn(pos + c, str.charAt(0), str.charAt(1));
			str = (str.length() == 2) ? "" : str.substring(2);
			c++;
		}
	}
	
	/**
	 * Devuelve una base en la posicion indicada
	 * @param pos
	 * @return base
	 */
	public Base getBase(int pos){
		return tira.getBase(pos);
	}

	/**
	 * Busca en la secuencia un termino indicado, usando las
	 * clases Pattern y Matcher
	 * @param s secuencia
	 * @param t termino
	 * @return msj de resultado (bien podria ser un boolean)
	 */
	public String buscarSecuencia(String s, int t) {
		String secuencia = tira.getSecuencia(t);
		String busqueda = s;
		String resultado = "";
		Pattern p = Pattern.compile(busqueda, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(secuencia);
		while (m.find()) {
			String encontrado = m.group();
			int indiceInicio = m.start();
			int indiceFin = m.end();
			resultado += encontrado + " entre los indices  "
					+ (indiceInicio + 1) + " y " + indiceFin + "\n";
		}
		return (resultado == "") ? s + " no encontrado" : resultado;
	}

	/**
	 * Valida en la secuencia (tira indicada) iniciando en una 
	 * posicion indicada
	 * @param inicio
	 * @param t
	 * @return True, si es valida
	 */
	public boolean validarSecuencia(int inicio, int t) {
		String secuencia = tira.getSecuencia(t).substring(inicio);
		// inicio
		Pattern p = Pattern.compile("AUG", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(secuencia);
		if (m.find() && m.start() == 0) {
			p = Pattern.compile("UAG", Pattern.CASE_INSENSITIVE);
			m = p.matcher(secuencia);
			if (m.find() && m.end() == secuencia.length())
				return true;
			else {
				p = Pattern.compile("UGA", Pattern.CASE_INSENSITIVE);
				m = p.matcher(secuencia);
				if (m.find() && m.end() == secuencia.length())
					return true;
				else {
					p = Pattern.compile("UAA", Pattern.CASE_INSENSITIVE);
					m = p.matcher(secuencia);
					if (m.find() && m.end() == secuencia.length())
						return true;
					else
						return false;
				}
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Asocia un comentario a la base en la posicion
	 * indicada
	 * @param pos
	 * @param c
	 */
	public void asociarComentario(int pos, Comentario c){
		tira.asociarComentario(pos, c);
	}

	/**
	 * Devuelve una hilera con la secuencia actual
	 * @return secuencia
	 */
	public String getSecuencia() {
		tira.ponerIndices();
		return tira.getSecuencia();
	}

	/**
	 * Devuelve una subsecuencia indicada
	 * @param inicio
	 * @param fin
	 * @return subsecuencia
	 */
	public String getSubsecuencia(int inicio, int fin) {
		return tira.getSubsecuencia(inicio, fin);
	}

	/**
	 * @return Longitud de la cadena
	 */
	public int length() {
		return tira.length();
	}

	/**
	 * Copia en la secuencia
	 * @param inicio
	 * @param fin
	 */
	public void copiar(int inicio, int fin) {
		tira.copiar(inicio, fin);
	}

	/**
	 * Corta en la secuencia
	 * @param inicio
	 * @param fin
	 */
	public void cortar(int inicio, int fin) {
		tira.cortar(inicio, fin);
	}

	/**
	 * Invierte una parte de la secuencia
	 * @param inicio
	 * @param fin
	 */
	public void invertir(int inicio, int fin) {
		tira.invertir(inicio, fin);
	}

	/**
	 * Pega en la secuencia
	 * @param inicio
	 */
	public void pegar(int inicio) {
		tira.pegar(inicio);
	}
}
