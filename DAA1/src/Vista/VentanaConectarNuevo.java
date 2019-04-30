package Vista;
import javax.swing.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorBaseDatos;
import Controlador.TablaGeneral;
import Modelo.Administrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VentanaConectarNuevo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	public ControladorBaseDatos cbd = new ControladorBaseDatos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaConectarNuevo dialog = new VentanaConectarNuevo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaConectarNuevo() {
		
		cbd.conexion = true;
		setTitle("Conexión Nueva");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(135, 60, 60, 15);
			contentPanel.add(lblUsuario);
		}
		{
			textField = new JTextField();
			textField.setBounds(230, 60, 114, 19);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(135, 100, 114, 15);
		contentPanel.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 100, 114, 19);
		contentPanel.add(passwordField);
		
		JLabel lblPuerto = new JLabel("Puerto: ");
		lblPuerto.setBounds(135, 140, 70, 15);
		contentPanel.add(lblPuerto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 140, 114, 19);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTabla = new JLabel("Tabla: ");
		lblTabla.setBounds(135, 180, 70, 15);
		contentPanel.add(lblTabla);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 180, 114, 19);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			JButton okButton = new JButton("Conectar");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbd = new ControladorBaseDatos();
					cbd.usuario = textField.getText();
					cbd.Contraseña = String.valueOf(passwordField.getPassword());
					cbd.puerto = textField_1.getText();
					cbd.tabla = textField_2.getText();
					Connection con = Administrador.conectar(cbd);
					if(con == null) {
						JOptionPane.showMessageDialog( null, "No se ha podido establecer la conexión");
					}
					else {
						JOptionPane.showMessageDialog( null, " Conexión Exitosa");
						cbd.conexion = true;
						
					}
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
			
			
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
			
		
	}
}
