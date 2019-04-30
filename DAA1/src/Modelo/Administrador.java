package Modelo;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import Controlador.*;
public class Administrador {
	
	static String url = "jdbc:postgresql://localhost:5432/postgres";
	static String usr = "postgres";
	static String psw = "astronomia";	 // ESTO NUNCA DEBERIA ESTAR A LA VISTA
	static String puerto = "5432";
	static String tabla = "coquimbo";
	
	public static Connection conectar() {
			Connection con = null;
			
			try {
				con = DriverManager.getConnection(url, usr, psw);
				if (con != null) {
					System.out.println("Conectado");
				}
			} catch (SQLException e) {
				System.out.println("No se pudo conectar a la base de datos");
				e.printStackTrace();
			}
			return con;
		}
	public static Connection conectar(ControladorBaseDatos cbd) {
		Connection con = null;
		String url = "jdbc:postgresql://localhost:" +cbd.puerto+ "/postgres";
		String usr = cbd.usuario;
		String psw = cbd.Contraseña;
		System.out.println(url +"  "+ usr+ "  "+  psw);
		try {
			con = DriverManager.getConnection(url, usr, psw);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}
	

}
