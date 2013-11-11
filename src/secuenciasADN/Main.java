package secuenciasADN;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Secuencia s = new Secuencia();
		s.inicializaSecuencia("A T A T A T");
		s.agregarPar('G', 'C');
		s.agregarPar('G', 'C');
		s.agregarPar('G', 'C');
		s.agregarParEn(3, 'Y', 'X');
		System.out.println(s.getSecuencia());
	}

}
