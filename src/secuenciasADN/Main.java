package secuenciasADN;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Base tira = new Base();
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
		s.pruebaSecuencia();*/
		Comentario c = new Comentario(2, 5, 123, null, "", "", "", "", "", "", "", "");
		Comentario c1 = new Comentario(1, 9, 123, null, "", "", "", "", "", "", "", "");
		c.agregar(c1);
		Comentario c2 = new Comentario(3, 4, 123, null, "", "", "", "", "", "", "", "");
		c.agregar(c2);
		c.agregar(new Comentario(1, 4, 123, null, "", "", "", "", "", "", "", ""));
		c.agregar(new Comentario(1, 12, 123, null, "", "", "", "", "", "", "", ""));
		c.mostrar();
	}

}
