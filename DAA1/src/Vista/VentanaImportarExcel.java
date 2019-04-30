package Vista;
import java.util.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.TablaGeneral;

import javax.swing.*;

public class VentanaImportarExcel extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaImportarExcel frame = new VentanaImportarExcel(new Vector<Vector <Integer>>());
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
	public VentanaImportarExcel(Vector< Vector <Integer>> matriz) {
		setTitle("Importar");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_1 = new JTable();
		//table_1.setBounds(25, 49, 351, 185);
		table_1.setModel(TablaGeneral.crearJTableDeExcel(matriz));
		JScrollPane scrollpane = new JScrollPane(table_1);
		contentPane.add(table_1);
		getContentPane().add(contentPane);
		revalidate();
		repaint();
	}
}
