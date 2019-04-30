package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class Crud {
	
	// Atributos 
	
	Administrador admin;
	Connection con;
	
	public boolean crear(Carrera carrera) {
		
		try {
			 
			 con = admin.conectar();
			 
             
			  String query = " insert into  coquimbo( nombre, institucion, tipo, sede, jornada, arancel, semestres,costo_titulo ) values (?, ?, ?, ?, ?, ?, ?, ?)";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString(1, carrera.nombre);
		      preparedStmt.setString(2, carrera.institucion);
		      preparedStmt.setString(3, carrera.tipo);
		      preparedStmt.setString(4, carrera.sede);
		      preparedStmt.setString(5, carrera.jornada);
		      preparedStmt.setDouble(6, carrera.arancel);
		      preparedStmt.setDouble(7, carrera.semestre);
		      preparedStmt.setDouble(8, carrera.costoTitulo);
		      preparedStmt.execute();
		      
		      con.close();
		      return true;
			}
		
		catch(Exception ex) {
			 System.out.println(ex.getMessage());
			return false;
		}
	}
public boolean buscar(Carrera carrera) {
		
		try {
			 
			 con = admin.conectar();
			 
			 
			  String query = " select from  coquimbo where(nombre = '"+ carrera.nombre + "' and"   
			  							+ "institucion = '"+ carrera.institucion + "' and tipo = '"+ carrera.tipo + "' and sede = '"+ carrera.sede + "' and " 
			  							+ "jornada = '"+ carrera.jornada + "' and  arancel = "+ carrera.arancel + " and  semestres = "+ carrera.semestre + " and " 
			  							+ "costo_titulo = "+ carrera.costoTitulo +")"; 
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      /*preparedStmt.setString(1, carrera.nombre);
		      preparedStmt.setString(2, carrera.institucion);
		      preparedStmt.setString(3, carrera.tipo);
		      preparedStmt.setString(4, carrera.sede);
		      preparedStmt.setString(5, carrera.jornada);
		      preparedStmt.setDouble(6, carrera.arancel);
		      preparedStmt.setDouble(7, carrera.semestre);
		      preparedStmt.setDouble(8, carrera.costoTitulo);
		      */
		      preparedStmt.execute();
		      
		      con.close();
		      return true;
			}
		
		catch(Exception ex) {
			 System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public ArrayList<Carrera> leer(HashMap<String, Double> inputDouble, HashMap<String, String> inputStrings) {


			//String query;
			String tipo = inputStrings.get("tipo");
			Double arancel = inputDouble.get("arancel");
			//query = "select * from coquimbo where (tipo = "+ tipo + " and arancel < " + String.valueOf(arancel) + ")";
		    ArrayList<Carrera> carrerasCoquimbo= new ArrayList<Carrera>(); // Aqui uso generico
			try {
				con = admin.conectar();
				String query;
				tipo = inputStrings.get("tipo");
				arancel = inputDouble.get("arancel");
				query = "select * from coquimbo where (tipo = '"+ tipo + "' and arancel < " + String.valueOf(arancel) + ")";
		        PreparedStatement stmt = con.prepareStatement(query);
				ResultSet Rs = stmt.executeQuery();
				System.out.println(tipo);
				while (Rs.next()) {
					Carrera carrera = new Carrera();
					carrera.nombre = Rs.getString(1);
				    carrera.institucion = Rs.getString(2);
				    carrera.tipo = Rs.getString(3);
				    carrera.sede = Rs.getString(4);
				    carrera.jornada = Rs.getString(5);
				    carrera.arancel = Rs.getDouble(6);
				    carrera.semestre = Rs.getDouble(7);
				    carrera.costoTitulo = Rs.getDouble(8);
				    System.out.println(carrera.nombre + "  " + carrera.arancel);
				    carrerasCoquimbo.add(carrera);
				}
				return carrerasCoquimbo;
			}
			
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				return carrerasCoquimbo;
			}
	}
	
	
	public boolean actualizar(Carrera carrera, String nombre) {
		
		try {
			con = admin.conectar();
			String query = "update coquimbo set nombre = '"+ nombre + "' where (nombre = '"+ carrera.nombre + "' and "
					+ "institucion = '"+ carrera.institucion + "' and tipo = '"+ carrera.tipo + "' and sede = '"+ carrera.sede + "' and "
					+ "jornada = '"+ carrera.jornada + "' and  arancel = "+ carrera.arancel + " and  semestres = "+ carrera.semestre + " and "
					+ "costo_titulo = "+ carrera.costoTitulo +")"; 

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			stmt.close();
			return true;
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean borrar(Carrera carrera) {
		
		try {
			con = admin.conectar();
			String query = "delete from coquimbo where (nombre = '"+ carrera.nombre + "' and " + "institucion = '"+ carrera.institucion + "' and tipo = '"
							+ carrera.tipo + "' and sede = '"+ carrera.sede + "' and " + "jornada = '"+ carrera.jornada + "' and  arancel = "+ carrera.arancel +
							" and  semestres = "+ carrera.semestre + " and " + "costo_titulo = "+ carrera.costoTitulo +")"; 
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			stmt.close();
			return true;

		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	

}
