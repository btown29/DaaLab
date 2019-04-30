package Vista;
import javax.swing.*;
import Controlador.*;
import Modelo.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrear extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.d
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTable jtable = new JTable();
					VentanaCrear frame = new VentanaCrear(new JTable());
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
	public VentanaCrear(JTable table) {
		setModal(true);
		setResizable(false);
		setTitle("Crear");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 430);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 49, 70, 15);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Carreras.nombre = textField.getText();
				//System.out.println(Carreras.nombre);
			}
		});
		textField.setBounds(128, 47, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInstitucin = new JLabel("Institución:");
		lblInstitucin.setBounds(29, 109, 88, 15);
		contentPane.add(lblInstitucin);
		
		JLabel lblSede = new JLabel("Sede:");
		lblSede.setBounds(29, 169, 70, 15);
		contentPane.add(lblSede);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(29, 229, 70, 15);
		contentPane.add(lblTipo);
		
		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setBounds(29, 279, 70, 15);
		contentPane.add(lblJornada);
		
		JLabel lblArancel = new JLabel("Arancel:");
		lblArancel.setBounds(301, 49, 100, 15);
		contentPane.add(lblArancel);
		
		JLabel lblSemestres = new JLabel("Semestres:");
		lblSemestres.setBounds(301, 110, 100, 15);
		contentPane.add(lblSemestres);
		
		JLabel lblCostotitulo = new JLabel("Costo titulo:");
		lblCostotitulo.setBounds(301, 170, 100, 15);
		contentPane.add(lblCostotitulo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 109, 114, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 169, 114, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 229, 114, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 279, 114, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(400, 49, 114, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(400, 110, 114, 19);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(400, 170, 114, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crud crud = new Crud();
				ControladorCrear cc = new ControladorCrear();
				cc.nombre = textField.getText();
			    cc.institucion = textField_1.getText();
			    cc.tipo = textField_2.getText();
			    cc.sede = textField_3.getText();
			    cc.jornada = textField_4.getText();
		    	if(textField_5.getText() == null) {cc.arancel = 0;}
		    	try {
		    	    cc.arancel = Double.parseDouble(textField_5.getText());
		    	} catch (NumberFormatException eh) {
		    	    //cc.arancel = 0;
		    	}
			    try {
			    	cc.semestres= Double.parseDouble(textField_6.getText());
			    	} catch (NumberFormatException ef) {
			    	    //cc.semestres = 0;}
			    	}
				    	try {
				    	    cc.costoTitulo = Double.parseDouble(textField_7.getText());
				    	} catch (NumberFormatException eg) {
				    	    //cc.costoTitulo = 0;
				    	}
				Carrera carrera = cc.crearCarrera();
				System.out.println(crud.crear(carrera));
				dispose();
			
			}
		});
		btnInsertar.setBounds(429, 364, 117, 25);
		contentPane.add(btnInsertar);
		
		JLabel label = new JLabel("(*)");
		label.setForeground(Color.RED);
		label.setBackground(Color.RED);
		label.setBounds(240, 49, 70, 15);
		contentPane.add(label);
		
		JLabel lblCampoObligatorio = new JLabel("(*) Campo obligatorio");
		lblCampoObligatorio.setForeground(Color.RED);
		lblCampoObligatorio.setBounds(29, 326, 179, 15);
		contentPane.add(lblCampoObligatorio);
	}
}
