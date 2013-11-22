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
	public JTextArea txtArea;
	private JLabel lblAgregarUnComentario;
	private JLabel lblInicio;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblDescripcion;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JLabel lblNombreUtor;
	private JTextField textField_4;
	private JLabel lblRefrencia;
	private JTextField textField_5;
	private JLabel lblBaseDeDatos;
	private JTextField textField_6;
	private JLabel lblLinkBaseDe;
	private JTextField textField_7;

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
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtArea.setEditable(false);
		scrollPane.setViewportView(txtArea);
		
		lblAgregarUnComentario = new JLabel("Agrega un comentario:");
		lblAgregarUnComentario.setBounds(353, 8, 143, 14);
		contentPane.add(lblAgregarUnComentario);
		
		lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(353, 29, 45, 14);
		contentPane.add(lblInicio);
		
		textField = new JTextField();
		textField.setBounds(396, 26, 35, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFin = new JLabel("Fin:");
		lblFin.setBounds(441, 29, 32, 14);
		contentPane.add(lblFin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(474, 26, 35, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIdDelCaso = new JLabel("ID del caso:");
		lblIdDelCaso.setBounds(520, 29, 74, 14);
		contentPane.add(lblIdDelCaso);
		
		textField_2 = new JTextField();
		textField_2.setBounds(591, 26, 40, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(370, 56, 40, 14);
		contentPane.add(lblTipo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(426, 53, 212, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(370, 80, 74, 14);
		contentPane.add(lblDescripcion);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(456, 84, 194, 75);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		lblNombreUtor = new JLabel("Nombre autor:");
		lblNombreUtor.setBounds(353, 173, 103, 14);
		contentPane.add(lblNombreUtor);
		
		textField_4 = new JTextField();
		textField_4.setBounds(473, 170, 177, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblRefrencia = new JLabel("Referencia:");
		lblRefrencia.setBounds(353, 198, 110, 14);
		contentPane.add(lblRefrencia);
		
		textField_5 = new JTextField();
		textField_5.setBounds(456, 195, 194, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblBaseDeDatos = new JLabel("Base de datos:");
		lblBaseDeDatos.setBounds(353, 223, 123, 14);
		contentPane.add(lblBaseDeDatos);
		
		textField_6 = new JTextField();
		textField_6.setBounds(466, 220, 182, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblLinkBaseDe = new JLabel("Link Base de datos:");
		lblLinkBaseDe.setBounds(353, 248, 143, 14);
		contentPane.add(lblLinkBaseDe);
		
		textField_7 = new JTextField();
		textField_7.setBounds(501, 245, 145, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(561, 276, 89, 23);
		contentPane.add(btnAgregar);
	}
}
