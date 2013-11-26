package secuenciasADN;

public class Secuencia {

	Base tira;

	public Secuencia(Base tira) {
		this.tira = tira;
	}

	/**
	 * Como este agrega un par de bases, busca la tira m�s larga y lo agrega al
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
	 * Hacer luego las validaciones
	 * 
	 * @param pos
	 * @param l
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
	
	public void agregarSecuencia(int pos, String s){
		String str = s;
		int c = 0;
		while (str.length() > 0) {
			agregarParEn(pos+c, str.charAt(0), str.charAt(1));
			str = (str.length() == 2) ? "" : str.substring(2);
			c++;
		}
	}

	public String getSecuencia() {
		return tira.getSecuencia();
	}
	

	public String getSubsecuencia(int inicio, int fin){
		return tira.getSubsecuencia(inicio, fin);
	}

	public int length() {
		return tira.length();
	}

	public void copiar(int inicio, int fin) {
		tira.copiar(inicio, fin);
	}
	
	public void cortar(int inicio, int fin) {
		tira.cortar(inicio, fin);
	}
	
	public void invertir(int inicio, int fin) {
		tira.invertir(inicio, fin);
	}
	
	public void pegar(int inicio){
		tira.pegar(inicio);
	}
}
