package secuenciasADN;

public class Manejador {
	private Almacenamiento almacenamiento;
	private Base tira, tiraParalela;
	private Interfaz interfaz;
	private Secuencia secuencia;
	
	public Manejador() {
		almacenamiento = new Almacenamiento();
		tira = new Base();
		tiraParalela = new Base();
		tira.asociarParalela(tiraParalela);
		tiraParalela.asociarParalela(tira);
		secuencia = new Secuencia(tira);

		interfaz = new Interfaz();
		
		secuencia.inicializaSecuencia(almacenamiento.leerSecuencia());
		actualizarSecuencia();
		
		interfaz.setVisible(true);
	}
	
	private void actualizarSecuencia(){
		interfaz.txtArea.setText(secuencia.getSecuencia());
	}
}
