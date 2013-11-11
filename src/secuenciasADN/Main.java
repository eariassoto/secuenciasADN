package secuenciasADN;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Secuencia s = new Secuencia();
		s.inicializaSecuencia("A T G C C G");
		//s.agregarPar('G', 'C');
		//s.agregarPar('G', 'C');
		//s.agregarPar('G', 'C');
		//s.agregarBase(1, 'A');
		//s.agregarBase(1, 'A');
		//s.agregarBase(2, 'T');
		s.agregarParEn(2, 'Y', 'X');
		System.out.println(s.getSecuencia());
	}

}
