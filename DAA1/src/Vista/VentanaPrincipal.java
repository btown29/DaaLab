package Vista;
import java.util.*;

import Controlador.*;
import Modelo.*;
import Controlador.ControladorBaseDatos.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.JDialog;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.table.*;
import javax.swing.*;
import Controlador.TablaGeneral;

import java.io.*;

/* Autor: Bryan Townsend
 * Fecha: 30/04/19
 * Programa : Permite realizar crud e importar y exportar archivos excel. Utilizando MVC
 * A mejorar a futuros trabajos: Manejar los controladores con la vista. Diferenciar claramente cuandos los atributos son: 
 * 								 público, privado o protegido. Por qué metodos publicos o estaticos o finales? Mejorar la legibilidad del código.
 *                               Implementar de mejor manera GUI ( Estudiar conceptos asociados a cómo hacer una GUI correcta)
 */
public class VentanaPrincipal extends JFrame {

	//Estos son los atributos de la vista. En realidad solo carreras lo veo necesario 
	public JScrollPane scrollPane;
	public  JTable table;
	public static ArrayList<Carrera> carreras;
	

	/**
	 * Aqui comienza el programa
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Se crea el constructor
	 */
	public VentanaPrincipal() {
		
		setTitle("Tarea1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Para que el marco principal tenga el tamaño del monitor
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int ancho = (int) tk.getScreenSize().getWidth() - 65; // Prueba y error
		int alto = (int) tk.getScreenSize().getHeight() -47; // Prueba y error
		setSize(ancho, alto);
		
		// Utilizo JMenu. Podría no utilizarlos un buen programa tiene un buen menu???????
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		// Conectarse a base de datos
		JMenu mnConectar = new JMenu("Conectar");
		menuBar.add(mnConectar);
		
		// Me conecto en esta maquina
		JMenuItem mntmPorDefecto = new JMenuItem("Por Defecto");
		mntmPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con = Administrador.conectar();
				
				if(con != null) {
					//table = TablaGeneral.actualizarTabla(new ControladorBaseDatos());
					table = new JTable();
					table = TablaGeneral.actualizarTabla();
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					scrollPane = new JScrollPane(table);
					getContentPane().add(scrollPane);
					revalidate();
					repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, "No se puede conectar por defecto en un computador externo");
				}
			    
				
			}
		});
		
		mnConectar.add(mntmPorDefecto);
		
		// Se puede conectar otra persona de manera remota. -------- SE DEBE IMPLEMENTAR ---------------
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		/*mntmNuevo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
				//Connection con = Administrador.conectar();
				JDialog ventanaConectarNuevo = new VentanaConectarNuevo();
				ventanaConectarNuevo.setVisible(true);
					ControladorBaseDatos cbd = new ControladorBaseDatos();
					if(ventanaConectarNuevo.)
					JTable table = TablaGeneral.actualizarTabla(cbd);
					System.out.print(table.getRowCount());
					JScrollPane scrollPane = new JScrollPane(table);
					getContentPane().add(scrollPane);
					revalidate();
					repaint();
					JOptionPane.showMessageDialog(null, "No se puede conectar a la base de datos");
				
			}
		});
		*/
		mnConectar.add(mntmNuevo);
		
		JMenu mnCrud = new JMenu("Crud");
		menuBar.add(mnCrud);
		
		// IMPORTANTE: USAR CLAVES PRIMARIAS. MI BASE DE DATOS NO TIENE CLAVE PRIMARIA
		// Lo que creo significa lo que inserto
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrear vc = new VentanaCrear(table);
				vc.setVisible(true);
					table = TablaGeneral.actualizarTabla();
					//revalidate();
					scrollPane = new JScrollPane(table);
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					getContentPane().add(scrollPane);
					//revalidate();
					repaint();
				
			}
		});
		mnCrud.add(mntmCrear);
		
		JMenuItem mntmLeer = new JMenuItem("Leer");
		mntmLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLeer vl = new VentanaLeer();
				vl.setVisible(true);
				carreras = vl.entregarLista();
				table = new JTable(TablaGeneral.crearJTable(carreras));
				scrollPane = new JScrollPane(table);
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				getContentPane().add(scrollPane);
				//revalidate();
				repaint();
				
			}
		});
		mnCrud.add(mntmLeer);
		
		JMenuItem mntmActualizar = new JMenuItem("Actualizar");
		mntmActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Carrera carrera = new Carrera();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRow = table.getSelectedRow();
				carrera.nombre = model.getValueAt(selectedRow, 0).toString();
				carrera.institucion = model.getValueAt(selectedRow, 1).toString();
				carrera.tipo = model.getValueAt(selectedRow, 2).toString();
				carrera.sede = model.getValueAt(selectedRow, 3).toString();
				carrera.jornada = model.getValueAt(selectedRow, 4).toString();
				carrera.arancel = Double.parseDouble(model.getValueAt(selectedRow, 5).toString());
				carrera.semestre = Double.parseDouble(model.getValueAt(selectedRow, 6).toString());
				carrera.costoTitulo = Double.parseDouble(model.getValueAt(selectedRow, 7).toString());
				VentanaActualizar va = new VentanaActualizar(carrera);	
				va.setVisible(true);
				table = TablaGeneral.actualizarTabla();
				scrollPane = new JScrollPane(table);
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				getContentPane().add(scrollPane);
				//revalidate();
				repaint();
			}
		});
		mnCrud.add(mntmActualizar);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Carrera carrera = new Carrera();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						int selectedRow = table.getSelectedRow();
						carrera.nombre = model.getValueAt(selectedRow, 0).toString();
						carrera.institucion = model.getValueAt(selectedRow, 1).toString();
						carrera.tipo = model.getValueAt(selectedRow, 2).toString();
						carrera.sede = model.getValueAt(selectedRow, 3).toString();
						carrera.jornada = model.getValueAt(selectedRow, 4).toString();
						carrera.arancel = Double.parseDouble(model.getValueAt(selectedRow, 5).toString());
						carrera.semestre = Double.parseDouble(model.getValueAt(selectedRow, 6).toString());
						carrera.costoTitulo = Double.parseDouble(model.getValueAt(selectedRow, 7).toString());
				        int n = JOptionPane.showConfirmDialog(null,
				                "¿Está seguro que desea eliminar la carrera seleccionada?",
				                "Borrar una carrera",
				                JOptionPane.YES_NO_OPTION);

				         if(n == JOptionPane.YES_OPTION){
				        	 	Crud crud = new Crud();
				        	 	crud.borrar(carrera);
				                JOptionPane.showMessageDialog(null, "Se ha borrado la carrera seleccionada");
				            }
				            else {
				                
				            }
						table = TablaGeneral.actualizarTabla();
						scrollPane = new JScrollPane(table);
						getContentPane().removeAll();
						getContentPane().revalidate();
						getContentPane().repaint();
						getContentPane().add(scrollPane);

						repaint(); // Estudiar esto

									
					}
				});

		mnCrud.add(mntmBorrar);
		
		JMenu mnExcel = new JMenu("Excel");
		menuBar.add(mnExcel);
		
		JMenuItem mntmImportar = new JMenuItem("Importar");
		mntmImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser();
				File archivo;
				if(jf.showDialog(null, "Cargar") == JFileChooser.APPROVE_OPTION){
						archivo = jf.getSelectedFile();
						//String archivo = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo que desea importar");
						Excel excel = new Excel();
						Vector< Vector <Integer> > ej = new Vector <Vector<Integer>>();
						ej = excel.importar(archivo.getAbsolutePath());
						//System.out.print(ej);
						JOptionPane.showMessageDialog(null, "Se ha importado el archivo", "Importación",JOptionPane.INFORMATION_MESSAGE);
						VentanaImportarExcel vie = new VentanaImportarExcel(ej);
						vie.setVisible(true);
		}
				
			}
		});
		mnExcel.add(mntmImportar);
		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mntmExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser();
				File archivo;
				if(jf.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION){
						archivo = jf.getSelectedFile();
						int filas = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingrese el número de filas que desea incorporar"));
						int col = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingrese el número de columnas que desea incorporar"));
						JOptionPane.showMessageDialog(null, "Exportación exitosa", "Exportar Excel",JOptionPane.INFORMATION_MESSAGE);
						Excel excel = new Excel();
						Vector< Vector <Integer> > ej = excel.crearMatriz(filas, col);
						excel.exportar(ej, archivo.getAbsolutePath());
				}
			}
		});
		mnExcel.add(mntmExportar);
		
		JMenu mnAcercaDe = new JMenu("Acerca de");
		menuBar.add(mnAcercaDe);
		JMenuItem mntmAcercaDe = new JMenuItem("Tarea1 Laboratorio DAA");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAcercaDe va = new VentanaAcercaDe();
				va.setVisible(true);
			}
		});
		mnAcercaDe.add(mntmAcercaDe);
		JPanel contentPane = new JPanel(new GridLayout(1,1));
		//table = TablaGeneral.actualizarTabla(true);
		JTable table = new JTable();
	    JScrollPane scrollPane = new JScrollPane(table);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.add(scrollPane, BorderLayout.SOUTH);
	    //setContentPane(contentPane);
	    
	    //getContentPane().add(contentPane);
	  }
		
		
}


