/**
 * @author Emmanuel Arias Soto B30640
 * Clase que maneja el programa
 */
package secuenciasADN;

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
	// objetos
	private Almacenamiento almacenamiento;
	private Base tira, tiraParalela;
	private Comentario comentario;
	private Interfaz interfaz;
	private Secuencia secuencia;

	/**
	 * Constructor, instancia los objetos y agrega los
	 * escuchadores
	 */
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

	/**
	 * Refresca la secuencia en la interfaz
	 */
	private void actualizarSecuencia() {
		interfaz.txtSecuencia.setText(secuencia.getSecuencia());
	}

	/**
	 * Refresca la lista de comentarios en la interfaz
	 */
	private void actualizarComentarios() {
		interfaz.txtComentarios.setText(comentario.getComentarios());
	}

	/**
	 * Crea los escuchadores de los elementos que interactuan con el 
	 * usuario.
	 */
	private void setListeners() {
		interfaz.btnComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// agregar comentario
				try {
					int inicio = Integer.parseInt(interfaz.txtInicio.getText());
					int fin = Integer.parseInt(interfaz.txtFin.getText());
					if (estaEnLimites(inicio, fin)) {
						Comentario nuevoComentario = new Comentario(secuencia.getBase(inicio), secuencia.getBase(fin),Integer
								.parseInt(interfaz.txtId.getText()),
								new Date(), interfaz.txtTipo.getText(),
								interfaz.txtDes.getText(), interfaz.txtNom
										.getText(),
								interfaz.txtEmail.getText(), interfaz.txtRef
										.getText(), interfaz.txtBd.getText(),
								interfaz.txtLink.getText());
						comentario.agregar(nuevoComentario);
						secuencia.asociarComentario(inicio, nuevoComentario);
						secuencia.asociarComentario(fin, nuevoComentario);
						actualizarComentarios();
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
				// acciones varias
				try {
					int inicio = Integer.parseInt(interfaz.txtInicio2.getText());
					int fin = (interfaz.rdbtnPegar.isSelected()) ? 0 : Integer
							.parseInt(interfaz.txtFin2.getText());
					if (interfaz.rdbtnCopiar.isSelected()) {
						// copiar
						if (estaEnLimites(inicio, fin))
							secuencia.copiar(inicio, fin);
						else
							throw new Exception();
					} else if (interfaz.rdbtnCortar.isSelected()) {
						// cortar
						if (estaEnLimites(inicio, fin)) {
							secuencia.cortar(inicio, fin);
							comentario.eliminar(inicio, fin);
							actualizarSecuencia();
							actualizarComentarios();
						} else
							throw new Exception();
					} else if (interfaz.rdbtnExtraer.isSelected()) {
						// extraer
						if (estaEnLimites(inicio, fin)) {
							StringSelection stringSelection = new StringSelection(
									secuencia.getSubsecuencia(inicio, fin));
							Clipboard clpbrd = Toolkit.getDefaultToolkit()
									.getSystemClipboard();
							clpbrd.setContents(stringSelection, null);
							JOptionPane
									.showMessageDialog(
											interfaz,
											"La secuencia extraida se ha copiado en el portapapeles",
											"Extraccion de secuencia",
											JOptionPane.INFORMATION_MESSAGE);
						} else
							throw new Exception();
					} else if (interfaz.rdbtnInvertir.isSelected()) {
						// invertir
						if (estaEnLimites(inicio, fin)) {
							secuencia.invertir(inicio, fin);
							comentario.eliminar(fin, fin);
							actualizarSecuencia();
							actualizarComentarios();
						} else
							throw new Exception();
					} else if (interfaz.rdbtnPegar.isSelected()) {
						// pegar
						if (estaEnLimites(inicio)) {
							secuencia.pegar(inicio);
							actualizarSecuencia();
						} else
							throw new Exception();
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(interfaz,
							"Error, datos incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				} finally {
					limpiarComponentes(interfaz.getComponentesAcciones());
				}
			}
		});

		interfaz.btnInsertar.addActionListener(new ActionListener() {
			// insertar
			public void actionPerformed(ActionEvent e) {
				try {
					String cadena = interfaz.txtCadena.getText().toUpperCase();
					int pos = Integer.parseInt(interfaz.txtInicio3.getText());
					if (estaEnLimites(pos) && cadena.length() % 2 == 0
							&& Pattern.matches("[A,T,G,C,U]+", cadena)) {
						secuencia.agregarSecuencia(pos, cadena);
						actualizarSecuencia();
						actualizarComentarios();
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(interfaz,
							"Error, datos incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		interfaz.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//buscar
				try {
					JOptionPane.showMessageDialog(interfaz, secuencia
							.buscarSecuencia(interfaz.txtBuscar.getText(),
									interfaz.comboBox.getSelectedIndex() + 1),
							"Busqueda", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(interfaz,
							"Error, datos incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		interfaz.btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validar
				try {
					int inicio = Integer.parseInt(interfaz.txtValidar.getText());
					String s = (secuencia.validarSecuencia(inicio - 1,
							interfaz.comboBox.getSelectedIndex() + 1)) ? "La secuencia a partir del indice "
							+ inicio + " es valida."
							: "La secuencia a partir del indice " + inicio
									+ " no es valida.";
					JOptionPane.showMessageDialog(interfaz, s, "Validar",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(interfaz,
							"Error, datos incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
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

	/**
	 * Verifica que los indices esten dentro de los limites
	 * de la secuencia
	 * @param i indice inicial
	 * @param f indice final
	 * @return True, si esta en limites
	 */
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

	/**
	 * Hace lo mismo que el anterior pero solo con el
	 * indice inicial
	 * @param i indice inicial
	 * @return True, si esta en limites
	 */
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

	/**
	 * Limpia componentes de entrada de texto
	 * @param componentes
	 */
	private void limpiarComponentes(JTextComponent[] componentes) {
		for (JTextComponent c : componentes)
			c.setText("");
	}
}