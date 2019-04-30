package Controlador;
import Modelo.*;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Administrador;
import net.proteanit.sql.DbUtils;

public class TablaGeneral {


	public static JTable actualizarTabla() {
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable (modelo);

		try {
		    
			String query = " select * from coquimbo";
			System.out.println(query);
			Connection con = Administrador.conectar();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			ResultSet Rs = preparedStmt.executeQuery();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			table.setModel(DbUtils.resultSetToTableModel(Rs));
			/*
			table.getColumnModel().getColumn(0).setMaxWidth(700);
			table.getColumnModel().getColumn(1).setMaxWidth(700);
			table.getColumnModel().getColumn(2).setMaxWidth(200);
			table.getColumnModel().getColumn(3).setMaxWidth(400);
			table.getColumnModel().getColumn(4).setMaxWidth(200);
			table.getColumnModel().getColumn(5).setMaxWidth(100);
			table.getColumnModel().getColumn(6).setMaxWidth(100);
			table.getColumnModel().getColumn(7).setMaxWidth(100);
			*/
			table.getColumnModel().getColumn(0).setPreferredWidth(525);
			table.getColumnModel().getColumn(1).setPreferredWidth(300);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(200);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(90);
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			return table;
		}
		catch(Exception ex){
			return table;
			
		}
	}
	public static DefaultTableModel crearJTable(ArrayList<Carrera> list) {
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object fila [] = new Object[8];
		model.addColumn("nombre"); 
		model.addColumn("institucion"); 
		model.addColumn("tipo"); 
		model.addColumn("sede"); 
		model.addColumn("jornada"); 
		model.addColumn("arancel"); 
		model.addColumn("semestre"); 
		model.addColumn("costoTitulo"); 
		for(int i = 0; i < list.size(); i++) {
			fila[0] = list.get(i).nombre;
			fila[1] = list.get(i).institucion;
			fila[2] = list.get(i).tipo;
			fila[3] = list.get(i).sede;
			fila[4] = list.get(i).jornada;
			fila[5] = list.get(i).arancel;
			fila[6] = list.get(i).semestre;
			fila[7] = list.get(i).costoTitulo;
			
			model.addRow(fila);
		}
		for(int k = 1; k < 8 ; k++) {
			for(int l = 1; l < 8; l++) {
				System.out.println(model.getValueAt(k, l));
			}
		}

		return model;
	}
	public static DefaultTableModel crearJTableDeExcel(Vector<Vector<Integer>> matriz) {
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnCount(matriz.get(0).size());
		for(int i = 0; i < matriz.size(); i++) {
			Vector list = new Vector();
			for(int j = 0; j < matriz.get(0).size(); j++) {
				list.add(matriz.get(i).get(j).intValue());
				//System.out.println(matriz.get(i).get(j).intValue());
				//System.out.println(list);
				
			}
			model.addRow(list);
			//System.out.println(model.getValueAt(0, 0));
			
		}
		return model;
	}
	

}
