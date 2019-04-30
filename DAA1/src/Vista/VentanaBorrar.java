package Vista;
import Modelo.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Crud;

public class VentanaBorrar extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBorrar frame = new VentanaBorrar(new Carrera());
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
	public VentanaBorrar(Carrera carrera) {
		setModal(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
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
         dispose();
	}

}
