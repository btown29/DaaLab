package Vista;
import Modelo.*;
import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorCrear;
import Modelo.Carrera;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaLeer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	HashMap <String, String> HashMapInputsStrings = new HashMap <String, String>() ;
	HashMap <String, Double> HashMapInputsDoubles = new HashMap <String, Double>();
	public ArrayList <Carrera> carreras = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLeer frame = new VentanaLeer();
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
	public VentanaLeer() {
		setTitle("Leer");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione el tipo de institución que quiere leer: ");
		lblNewLabel.setBounds(38, 53, 365, 15);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnUniversidad = new JRadioButton("Universidad");
		rdbtnUniversidad.setSelected(true);
		rdbtnUniversidad.setBounds(19, 120, 149, 23);
		contentPane.add(rdbtnUniversidad);
		
		JRadioButton rdbtnIp = new JRadioButton("IP");
		rdbtnIp.setBounds(170, 120, 74, 23);
		contentPane.add(rdbtnIp);
		
		JRadioButton rdbtnCft = new JRadioButton("CFT");
		rdbtnCft.setBounds(260, 120, 149, 23);
		contentPane.add(rdbtnCft);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnUniversidad);
		buttonGroup.add(rdbtnIp);
		buttonGroup.add(rdbtnCft);
		
		JLabel lblArancelMximo = new JLabel("Arancel máximo:");
		lblArancelMximo.setBounds(51, 207, 137, 15);
		contentPane.add(lblArancelMximo);
		
		textField = new JTextField();
		textField.setBounds(180, 205, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLeer = new JButton("Leer");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crud crud = new Crud();
		    if(rdbtnCft.isSelected()) {HashMapInputsStrings.put("tipo","CFT");}
		    if(rdbtnIp.isSelected()) {HashMapInputsStrings.put("tipo","IP");}
		    if(rdbtnUniversidad.isSelected()) {HashMapInputsStrings.put("tipo","UNIVERSIDAD");}

				
    	try {
    		double arancel =  Double.parseDouble(textField.getText());
	    	HashMapInputsDoubles.put("arancel", arancel);
    	}
    		catch (NumberFormatException eh) {
    	    HashMapInputsDoubles.put("arancel", 0.0);
    	}
    		carreras = crud.leer(HashMapInputsDoubles, HashMapInputsStrings );
			}
		});
		
		btnLeer.setBounds(308, 243, 117, 34);
		contentPane.add(btnLeer);
	}
		public ArrayList <Carrera> entregarLista(){
			return carreras;
		}
}
