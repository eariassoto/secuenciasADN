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

	private void actualizarComentarios() {
		interfaz.txtComentarios.setText(comentario.getComentarios());
	}

	private void setListeners() {
		interfaz.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO controlar limites de indices
					// limpiar despues de errores
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
					JOptionPane.showMessageDialog(interfaz,
							"Error, datos incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		interfaz.btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int inicio = Integer.parseInt(interfaz.txtInicio2.getText());
					int fin = Integer.parseInt(interfaz.txtFin2.getText());
					if (interfaz.rdbtnCopiar.isSelected()) {
						if (estaEnLimites(inicio, fin))
							secuencia.copiar(inicio, fin);
						else
							JOptionPane.showMessageDialog(interfaz,
									"Error, datos incorrectos", "Error",
									JOptionPane.ERROR_MESSAGE);
					} else if (interfaz.rdbtnCortar.isSelected()) {
						if (estaEnLimites(inicio, fin)) {
							secuencia.cortar(inicio, fin);
							actualizarSecuencia();
						}else
							JOptionPane.showMessageDialog(interfaz,
									"Error, datos incorrectos", "Error",
									JOptionPane.ERROR_MESSAGE);
					} else if (interfaz.rdbtnExtraer.isSelected()) {
						System.out.println("extraer");
					} else if (interfaz.rdbtnInvertir.isSelected()) {
						if (estaEnLimites(inicio, fin)) {
							secuencia.invertir(inicio, fin);
							actualizarSecuencia();
						}else
							JOptionPane.showMessageDialog(interfaz,
									"Error, datos incorrectos", "Error",
									JOptionPane.ERROR_MESSAGE);
					} else
						if(interfaz.rdbtnPegar.isSelected()){
							if(estaEnLimites(inicio)){
								secuencia.pegar(inicio);
								actualizarSecuencia();
							}
						}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(interfaz,
							"Error, datos incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
			}
		});
		
		interfaz.rdbtnPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.lblFin_1.setVisible(false);
				interfaz.txtFin2.setVisible(false);
			}
		});
		interfaz.rdbtnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.lblFin_1.setVisible(true);
				interfaz.txtFin2.setVisible(true);
			}
		});
		interfaz.rdbtnCortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.lblFin_1.setVisible(true);
				interfaz.txtFin2.setVisible(true);
			}
		});
		interfaz.rdbtnExtraer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.lblFin_1.setVisible(true);
				interfaz.txtFin2.setVisible(true);
			}
		});
		interfaz.rdbtnInvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.lblFin_1.setVisible(true);
				interfaz.txtFin2.setVisible(true);
			}
		});
	}

	private boolean estaEnLimites(int i, int f) {
		if (i < 1 || i > f)
			return false;
		else {
			int length = secuencia.length();
			if (i > length || f > length)
				return false;
			else
				return true;
		}
	}
	
	private boolean estaEnLimites(int i) {
		if (i < 1)
			return false;
		else {
			int length = secuencia.length();
			if (i > length)
				return false;
			else
				return true;
		}
	}
}
