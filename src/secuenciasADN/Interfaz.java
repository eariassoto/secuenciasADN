package secuenciasADN;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Interfaz extends JFrame {

	private JPanel contentPane;
	public JTextArea txtSecuencia;
	public JButton btnComentario, btnAccion, btnInsertar, btnBuscar, btnValidar;
	private JLabel lblAgregarUnComentario;
	private JLabel lblInicio;
	public JTextField txtInicio, txtFin, txtId, txtTipo, txtNom, txtRef, txtBd,
			txtLink, txtEmail, txtFin2, txtInicio2, txtCadena, txtInicio3,txtBuscar, txtValidar;
	public JRadioButton rdbtnCopiar, rdbtnCortar, rdbtnInvertir, rdbtnExtraer,
			rdbtnPegar;
	public JTextArea txtDes, txtComentarios;
	public JLabel lblFin_1;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBox;
	private JLabel lblDescripcion;
	private JScrollPane scrollPane_1;
	private JLabel lblNombreUtor;
	private JLabel lblRefrencia;
	private JLabel lblBaseDeDatos;
	private JLabel lblLinkBaseDe;
	private JLabel lblComentariosAsociados;
	private ButtonGroup btnGroup;
	private JLabel lblInicio_3;
	private JLabel label_1;
	private JComboBox comboBox_1;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSecuenciaDeAdn = new JLabel("Secuencia de ADN");
		lblSecuenciaDeAdn.setBounds(5, 5, 111, 17);
		lblSecuenciaDeAdn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblSecuenciaDeAdn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 38, 101, 418);
		contentPane.add(scrollPane);

		txtSecuencia = new JTextArea();
		txtSecuencia.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtSecuencia.setEditable(false);
		scrollPane.setViewportView(txtSecuencia);

		lblAgregarUnComentario = new JLabel("Agrega un comentario:");
		lblAgregarUnComentario.setBounds(450, 8, 143, 14);
		contentPane.add(lblAgregarUnComentario);

		lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(473, 26, 45, 14);
		contentPane.add(lblInicio);

		txtInicio = new JTextField();
		txtInicio.setBounds(516, 23, 35, 20);
		contentPane.add(txtInicio);
		txtInicio.setColumns(10);

		JLabel lblFin = new JLabel("Fin:");
		lblFin.setBounds(561, 26, 32, 14);
		contentPane.add(lblFin);

		txtFin = new JTextField();
		txtFin.setBounds(594, 23, 35, 20);
		contentPane.add(txtFin);
		txtFin.setColumns(10);

		JLabel lblIdDelCaso = new JLabel("ID del caso:");
		lblIdDelCaso.setBounds(640, 26, 74, 14);
		contentPane.add(lblIdDelCaso);

		txtId = new JTextField();
		txtId.setText("123");
		txtId.setBounds(711, 23, 40, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(454, 51, 40, 14);
		contentPane.add(lblTipo);

		txtTipo = new JTextField();
		txtTipo.setText("Inicio de codon");
		txtTipo.setBounds(539, 48, 212, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);

		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(454, 78, 74, 14);
		contentPane.add(lblDescripcion);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(557, 84, 194, 75);
		contentPane.add(scrollPane_1);

		txtDes = new JTextArea();
		txtDes.setText("Inicia la secuencia que modela\r\nel color de pelo oscuro");
		scrollPane_1.setViewportView(txtDes);

		lblNombreUtor = new JLabel("Nombre autor:");
		lblNombreUtor.setBounds(454, 173, 103, 14);
		contentPane.add(lblNombreUtor);

		txtNom = new JTextField();
		txtNom.setText("Emmanuel Arias");
		txtNom.setBounds(574, 170, 177, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);

		lblRefrencia = new JLabel("Referencia:");
		lblRefrencia.setBounds(454, 228, 110, 14);
		contentPane.add(lblRefrencia);

		txtRef = new JTextField();
		txtRef.setText("IMDB");
		txtRef.setToolTipText("e");
		txtRef.setBounds(557, 225, 194, 20);
		contentPane.add(txtRef);
		txtRef.setColumns(10);

		lblBaseDeDatos = new JLabel("Base de datos:");
		lblBaseDeDatos.setBounds(454, 253, 123, 14);
		contentPane.add(lblBaseDeDatos);

		txtBd = new JTextField();
		txtBd.setText("IMDB");
		txtBd.setBounds(567, 250, 182, 20);
		contentPane.add(txtBd);
		txtBd.setColumns(10);

		lblLinkBaseDe = new JLabel("Link Base de datos:");
		lblLinkBaseDe.setBounds(454, 278, 143, 14);
		contentPane.add(lblLinkBaseDe);

		txtLink = new JTextField();
		txtLink.setText("http://imbd.com");
		txtLink.setBounds(602, 275, 145, 20);
		contentPane.add(txtLink);
		txtLink.setColumns(10);

		btnComentario = new JButton("Agregar");
		btnComentario.setBounds(662, 306, 89, 23);
		contentPane.add(btnComentario);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(454, 203, 78, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText("emmanuel@mail.com");
		txtEmail.setToolTipText("d");
		txtEmail.setBounds(545, 197, 206, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		lblComentariosAsociados = new JLabel("Comentarios Asociados");
		lblComentariosAsociados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComentariosAsociados.setBounds(126, 6, 158, 14);
		contentPane.add(lblComentariosAsociados);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(136, 38, 286, 418);
		contentPane.add(scrollPane_2);

		txtComentarios = new JTextArea();
		txtComentarios.setEditable(false);
		scrollPane_2.setViewportView(txtComentarios);

		JLabel lblInicio_1 = new JLabel("Inicio:");
		lblInicio_1.setBounds(473, 356, 46, 14);
		contentPane.add(lblInicio_1);

		txtInicio2 = new JTextField();
		txtInicio2.setBounds(520, 353, 35, 20);
		contentPane.add(txtInicio2);
		txtInicio2.setColumns(10);

		lblFin_1 = new JLabel("Fin:");
		lblFin_1.setBounds(574, 356, 46, 14);
		contentPane.add(lblFin_1);

		txtFin2 = new JTextField();
		txtFin2.setBounds(609, 353, 35, 20);
		contentPane.add(txtFin2);
		txtFin2.setColumns(10);

		rdbtnCopiar = new JRadioButton("Copiar");
		rdbtnCopiar.setSelected(true);
		rdbtnCopiar.setBounds(477, 377, 78, 23);
		contentPane.add(rdbtnCopiar);

		rdbtnCortar = new JRadioButton("Cortar");
		rdbtnCortar.setBounds(565, 377, 71, 23);
		contentPane.add(rdbtnCortar);

		rdbtnInvertir = new JRadioButton("Invertir");
		rdbtnInvertir.setBounds(477, 407, 74, 23);
		contentPane.add(rdbtnInvertir);

		rdbtnExtraer = new JRadioButton("Extraer");
		rdbtnExtraer.setBounds(565, 407, 71, 23);
		contentPane.add(rdbtnExtraer);

		btnAccion = new JButton("Aplicar");
		btnAccion.setBounds(654, 352, 88, 23);
		contentPane.add(btnAccion);

		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnCopiar);
		btnGroup.add(rdbtnCortar);
		btnGroup.add(rdbtnInvertir);
		btnGroup.add(rdbtnExtraer);

		rdbtnPegar = new JRadioButton("Pegar");
		btnGroup.add(rdbtnPegar);
		rdbtnPegar.setBounds(631, 380, 109, 23);
		contentPane.add(rdbtnPegar);

		JLabel lblInicio_2 = new JLabel("Inicio:");
		lblInicio_2.setBounds(339, 470, 46, 14);
		contentPane.add(lblInicio_2);

		txtInicio3 = new JTextField();
		txtInicio3.setBounds(384, 467, 45, 20);
		contentPane.add(txtInicio3);
		txtInicio3.setColumns(10);

		JLabel lblCadena = new JLabel("Cadena:");
		lblCadena.setBounds(438, 470, 46, 14);
		contentPane.add(lblCadena);

		txtCadena = new JTextField();
		txtCadena.setBounds(496, 467, 158, 20);
		contentPane.add(txtCadena);
		txtCadena.setColumns(10);

		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(662, 466, 89, 23);
		contentPane.add(btnInsertar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(394, 498, 154, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblBuscarCadena = new JLabel("Cadena:");
		lblBuscarCadena.setBounds(342, 501, 50, 14);
		contentPane.add(lblBuscarCadena);
		
		JLabel lblTira = new JLabel("Tira:");
		lblTira.setBounds(561, 501, 46, 14);
		contentPane.add(lblTira);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(602, 498, 50, 20);
		contentPane.add(comboBox);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(662, 497, 89, 23);
		contentPane.add(btnBuscar);
		
		lblInicio_3 = new JLabel("Inicio:");
		lblInicio_3.setBounds(444, 532, 50, 14);
		contentPane.add(lblInicio_3);
		
		txtValidar = new JTextField();
		txtValidar.setColumns(10);
		txtValidar.setBounds(496, 529, 55, 20);
		contentPane.add(txtValidar);
		
		label_1 = new JLabel("Tira:");
		label_1.setBounds(561, 535, 46, 14);
		contentPane.add(label_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(602, 532, 50, 20);
		contentPane.add(comboBox_1);
		
		btnValidar = new JButton("Validar");
		btnValidar.setBounds(662, 531, 89, 23);
		contentPane.add(btnValidar);
	}
	
	public JTextComponent[] getComponentesComentarios(){
		return new JTextComponent[]{txtInicio, txtFin, txtId, txtTipo, txtDes, txtNom, txtEmail, txtRef, txtBd, txtLink};
	}
	
	public JTextComponent[] getIndicesComentarios(){
		return new JTextComponent[]{txtInicio, txtFin};
	}
	
	public JTextComponent[] getComponentesAcciones(){
		return new JTextComponent[]{txtInicio2, txtFin2};
	}
	
	public JTextComponent[] getComponentesInsertar(){
		return new JTextComponent[]{txtInicio3, txtCadena};
	}
}
