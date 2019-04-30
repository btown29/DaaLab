import java.util.HashMap;
import java.util.List;

import Modelo.Carrera;
import Modelo.Crud;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Crud crud = new Crud();
		Carrera carrera = new Carrera();
		carrera.nombre = "Prueba1";
		boolean funciono = crud.crear(carrera); 
		System.out.println(funciono);
		HashMap<String, Double> inputDouble = new HashMap <String, Double>();
		HashMap<String, String> inputString = new HashMap <String, String>();
		inputString.put("tipo","IP");
		inputDouble.put("arancel", 2000000.);
		
		crud.leer(inputDouble, inputString) ;
		crud.actualizar(carrera, "Ejemplo");
		crud.borrar(carrera);
	}

}
