package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.ControladorBaseDatos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controlador.*;
public class VentanaBaseDatos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBaseDatos frame = new VentanaBaseDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaBaseDatos() {
		setTitle("Conectar a Base de Datos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");

		lblUsuario.setBounds(28, 55, 114, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(28, 105, 142, 15);
		contentPane.add(lblContrasea);
		
		JLabel lblPuerto = new JLabel("puerto:");
		lblPuerto.setBounds(28, 155, 142, 15);
		contentPane.add(lblPuerto);
		
		JLabel lblTabla = new JLabel("tabla:");
		lblTabla.setBounds(28, 205, 155, 15);
		contentPane.add(lblTabla);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorBaseDatos.usuario = textField.getText();
			}
		});
		textField.setBounds(148, 55, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorBaseDatos.Contraseña = textField_1.getText();
			}
		});
		textField_1.setBounds(148, 103, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorBaseDatos.puerto = textField_2.getText();
			}
		});
		textField_2.setBounds(148, 153, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorBaseDatos.tabla = textField_3.getText();
			}
		});
		textField_3.setBounds(148, 203, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VentanaPrincipal.table = ConexionBaseDeDatos.actualizarTabla();
			}
		});
		
		btnConectar.setBounds(92, 313, 117, 25);
		contentPane.add(btnConectar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(402, 313, 117, 25);
		contentPane.add(btnSalir);
	}
}
