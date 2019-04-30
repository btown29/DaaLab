package Controlador;
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

public class ControladorCrear  {
	
	public String nombre;
    public String institucion;
    public String tipo;
    public String sede;
    public String jornada;
    public double arancel;
    public double semestres;
    public double costoTitulo;
    
    public Carrera crearCarrera() {
    	
    	Carrera carrera = new Carrera(nombre, institucion, tipo, sede, jornada, arancel, semestres, costoTitulo);
    	return carrera;
    	
    }
}

	