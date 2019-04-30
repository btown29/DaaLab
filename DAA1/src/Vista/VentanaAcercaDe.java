package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class VentanaAcercaDe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAcercaDe frame = new VentanaAcercaDe();
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
	public VentanaAcercaDe() {
		setTitle("Acerca de ");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrTrabajoDeLaboratorio = new JTextArea();
		txtrTrabajoDeLaboratorio.setText("Trabajo de Laboratorio de Daa. \n 1) El programa consiste en ....... Implementando ........");
		txtrTrabajoDeLaboratorio.setBounds(39, 41, 534, 361);
		contentPane.add(txtrTrabajoDeLaboratorio);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(556, 67, 17, 361);
		contentPane.add(scrollBar);
		
		JLabel lblLoQueSe = new JLabel("Estado de Avance");
		lblLoQueSe.setBounds(220, 12, 329, 37);
		contentPane.add(lblLoQueSe);
	}
}
