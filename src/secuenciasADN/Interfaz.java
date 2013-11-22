package secuenciasADN;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Interfaz extends JFrame {

	private JPanel contentPane;
	public JTextArea txtSecuencia;
	public JButton btnAgregar;
	private JLabel lblAgregarUnComentario;
	private JLabel lblInicio;
	public JTextField txtInicio;
	public JTextField txtFin;
	public JTextField txtId;
	public JTextField txtTipo;
	private JLabel lblDescripcion;
	private JScrollPane scrollPane_1;
	public JTextArea txtDes;
	private JLabel lblNombreUtor;
	public JTextField txtNom;
	private JLabel lblRefrencia;
	public JTextField txtRef;
	private JLabel lblBaseDeDatos;
	public JTextField txtBd;
	private JLabel lblLinkBaseDe;
	public JTextField txtLink;
	public JTextField txtEmail;
	private JLabel lblComentariosAsociados;
	public JTextArea txtComentarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Interfaz frame = new Interfaz();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		scrollPane.setBounds(15, 38, 71, 418);
		contentPane.add(scrollPane);
		
		txtSecuencia = new JTextArea();
		txtSecuencia.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtSecuencia.setEditable(false);
		scrollPane.setViewportView(txtSecuencia);
		
		lblAgregarUnComentario = new JLabel("Agrega un comentario:");
		lblAgregarUnComentario.setBounds(473, 5, 143, 14);
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
		txtTipo.setText("a");
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
		txtDes.setText("b");
		scrollPane_1.setViewportView(txtDes);
		
		lblNombreUtor = new JLabel("Nombre autor:");
		lblNombreUtor.setBounds(454, 173, 103, 14);
		contentPane.add(lblNombreUtor);
		
		txtNom = new JTextField();
		txtNom.setText("c");
		txtNom.setBounds(574, 170, 177, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		lblRefrencia = new JLabel("Referencia:");
		lblRefrencia.setBounds(454, 228, 110, 14);
		contentPane.add(lblRefrencia);
		
		txtRef = new JTextField();
		txtRef.setText("e");
		txtRef.setToolTipText("e");
		txtRef.setBounds(557, 225, 194, 20);
		contentPane.add(txtRef);
		txtRef.setColumns(10);
		
		lblBaseDeDatos = new JLabel("Base de datos:");
		lblBaseDeDatos.setBounds(454, 253, 123, 14);
		contentPane.add(lblBaseDeDatos);
		
		txtBd = new JTextField();
		txtBd.setText("f");
		txtBd.setBounds(567, 250, 182, 20);
		contentPane.add(txtBd);
		txtBd.setColumns(10);
		
		lblLinkBaseDe = new JLabel("Link Base de datos:");
		lblLinkBaseDe.setBounds(454, 278, 143, 14);
		contentPane.add(lblLinkBaseDe);
		
		txtLink = new JTextField();
		txtLink.setText("g");
		txtLink.setBounds(602, 275, 145, 20);
		contentPane.add(txtLink);
		txtLink.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(662, 306, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(454, 203, 78, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("d");
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
	}
}
