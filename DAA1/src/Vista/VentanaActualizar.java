package Vista;
import javax.swing.*;
import Modelo.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaActualizar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaActualizar dialog = new VentanaActualizar(new Carrera());
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaActualizar(Carrera carrera) {

		setBounds(100, 100, 450, 300);
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModificarElNombre = new JLabel("Modificar el nombre de la carrera");
			lblModificarElNombre.setBounds(107, 10, 235, 15);
			contentPanel.add(lblModificarElNombre);
		}
		
		JLabel lblNuevoNombre = new JLabel("Nuevo Nombre: ");
		lblNuevoNombre.setBounds(58, 98, 158, 15);
		contentPanel.add(lblNuevoNombre);

		
		textField = new JTextField();
		textField.setBounds(204, 93, 114, 25);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Actualizar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Crud crud = new Crud();
						crud.actualizar(carrera,textField.getText()) ;
						dispose();
					}
				});
				okButton.setActionCommand("Actualizar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				dispose();
			}

		}
	}
}
