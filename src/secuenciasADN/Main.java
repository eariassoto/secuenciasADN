package secuenciasADN;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base tira = new Base();
		Base tP = new Base();
		tira.asociarParalela(tP);
		tP.asociarParalela(tira);
		Secuencia s = new Secuencia(tira);
		s.inicializaSecuencia("A T U A G T");
		s.agregarPar('G', 'C');
		s.agregarPar('G', 'A');
		s.agregarPar('G', 'U');
		s.agregarPar('T', 'G');
		s.agregarParEn(3, 'G', 'C');
		s.pruebaSecuencia();
	}

}
