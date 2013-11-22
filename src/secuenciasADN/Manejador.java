package secuenciasADN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class Manejador {
	private Almacenamiento almacenamiento;
	private Base tira, tiraParalela;
	private Comentario comentario;
	private Interfaz interfaz;
	private Secuencia secuencia;

	public Manejador() {
		almacenamiento = new Almacenamiento();
		comentario = new Comentario();
		tira = new Base();
		tiraParalela = new Base();
		tira.asociarParalela(tiraParalela);
		tiraParalela.asociarParalela(tira);
		secuencia = new Secuencia(tira);

		interfaz = new Interfaz();

		setListeners();
		secuencia.inicializaSecuencia(almacenamiento.leerSecuencia());
		actualizarSecuencia();
		actualizarComentarios();

		interfaz.setVisible(true);
	}

	private void actualizarSecuencia() {
		interfaz.txtSecuencia.setText(secuencia.getSecuencia());
	}
	
	private void actualizarComentarios(){
		interfaz.txtComentarios.setText(comentario.getComentarios());
	}

	private void setListeners() {
		interfaz.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Comentario nuevoComentario = new Comentario(Integer
							.parseInt(interfaz.txtInicio.getText()), Integer
							.parseInt(interfaz.txtFin.getText()), Integer
							.parseInt(interfaz.txtId.getText()), new Date(),
							interfaz.txtTipo.getText(), interfaz.txtDes
									.getText(), interfaz.txtNom.getText(),
							interfaz.txtEmail.getText(), interfaz.txtRef
									.getText(), interfaz.txtBd.getText(),
							interfaz.txtLink.getText());
					comentario.agregar(nuevoComentario);
					actualizarComentarios();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(interfaz, "Error, datos incorrectos","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
