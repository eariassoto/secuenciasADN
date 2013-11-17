package secuenciasADN;

public class Secuencia {

	Base tira;

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
			agregarPar(str.charAt(0), str.charAt(2));
			str = (str.length() == 3) ? "" : str.substring(4);
		}
	}

	public void pruebaSecuencia() {
		System.out.println(tira.getSecuencia());
		System.out.println(tira.getInicio(1));
		System.out.println(tira.getInicio(2));
		tira.invertir(4, 8);
		System.out.println(tira.getSecuencia());
		System.out.println(tira.getInicio(1));
		System.out.println(tira.getInicio(2));
		tira.copiar(1, 4);
		tira.pegar(8);
		System.out.println(tira.getSecuencia());
	}
}
