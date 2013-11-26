package secuenciasADN;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

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
		interfaz.btnComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO controlar limites de indices
					// limpiar despues de errores
					int inicio = Integer.parseInt(interfaz.txtInicio.getText());
					int fin = Integer.parseInt(interfaz.txtFin.getText());
					if (estaEnLimites(inicio, fin)) {
						Comentario nuevoComentario = new Comentario(inicio,
								fin,
								Integer.parseInt(interfaz.txtId.getText()),
								new Date(), interfaz.txtTipo.getText(),
								interfaz.txtDes.getText(), interfaz.txtNom
										.getText(),
								interfaz.txtEmail.getText(), interfaz.txtRef
										.getText(), interfaz.txtBd.getText(),
								interfaz.txtLink.getText());
						comentario.agregar(nuevoComentario);
						actualizarComentarios();
						limpiarComponentes(interfaz.getComponentesComentarios());
					} else 
						throw new Exception();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(interfaz,
							"Error, datos incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
					limpiarComponentes(interfaz.getIndicesComentarios());
				}
			}
		});

		interfaz.btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int inicio = Integer.parseInt(interfaz.txtInicio2.getText());
					int fin = (interfaz.rdbtnPegar.isSelected())?0:Integer.parseInt(interfaz.txtFin2.getText());
					if (interfaz.rdbtnCopiar.isSelected()) {
						if (estaEnLimites(inicio, fin))
							secuencia.copiar(inicio, fin);
						else
							throw new Exception();
					} else if (interfaz.rdbtnCortar.isSelected()) {
						if (estaEnLimites(inicio, fin)) {
							secuencia.cortar(inicio, fin);
							actualizarSecuencia();
						} else
							throw new Exception();
					} else if (interfaz.rdbtnExtraer.isSelected()) {
						if (estaEnLimites(inicio, fin)) {
							StringSelection stringSelection = new StringSelection (secuencia.getSubsecuencia(inicio, fin));
							Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
							clpbrd.setContents (stringSelection, null);
							JOptionPane.showMessageDialog(interfaz,
									"La secuencia extraida se ha copiado en el portapapeles", "Extraccion de secuencia",
									JOptionPane.INFORMATION_MESSAGE);
						} else
							throw new Exception();
					} else if (interfaz.rdbtnInvertir.isSelected()) {
						if (estaEnLimites(inicio, fin)) {
							secuencia.invertir(inicio, fin);
							actualizarSecuencia();
						} else
							throw new Exception();
					} else if (interfaz.rdbtnPegar.isSelected()) {
						if (estaEnLimites(inicio)) {
							secuencia.pegar(inicio);
							actualizarSecuencia();
						}else
							throw new Exception();
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(interfaz,
							"Error, datos incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}finally{
					limpiarComponentes(interfaz.getComponentesAcciones());
				}
			}
		});

		interfaz.btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cadena = interfaz.txtCadena.getText();
					int pos = Integer.parseInt(interfaz.txtInicio3.getText());
					if (estaEnLimites(pos) && cadena.length() % 2 == 0
							&& Pattern.matches("[A,T,G,C,U]+", cadena)) {
						secuencia.agregarSecuencia(pos, cadena);
						actualizarSecuencia();
					}
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		
		ActionListener actionListenerMos = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.lblFin_1.setVisible(true);
				interfaz.txtFin2.setVisible(true);
			}
		};
		
		ActionListener actionListenerEsc = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.lblFin_1.setVisible(false);
				interfaz.txtFin2.setVisible(false);
			}
		};
		
		interfaz.rdbtnPegar.addActionListener(actionListenerEsc);
		interfaz.rdbtnCopiar.addActionListener(actionListenerMos);
		interfaz.rdbtnCortar.addActionListener(actionListenerMos);
		interfaz.rdbtnExtraer.addActionListener(actionListenerMos);
		interfaz.rdbtnInvertir.addActionListener(actionListenerMos);
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

	private void limpiarComponentes(JTextComponent[] componentes) {
		for (JTextComponent c : componentes)
			c.setText("");
	}

}