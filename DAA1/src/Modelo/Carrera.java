package Modelo;

public class Carrera {
	
	    
		public String nombre;
	    public String institucion = "";
	    public String tipo = "";
	    public String sede = "";
	    public String jornada = "";
	    public double arancel ;
	    public double semestre ;
	    public double costoTitulo ;
	    
	    public Carrera() {
	    	
	    }

	    public Carrera(String nombre, String institucion, String tipo, String sede, String jornada, double arancel, double semestre,
	    		double costoTitulo) {
	    	this.nombre = nombre;
	    	this.institucion = institucion;
	    	this.tipo = tipo;
	    	this.sede = sede;
	    	this.jornada = jornada; 
	    	this.arancel = arancel;
	    	this.semestre = semestre;
	    	this.costoTitulo = costoTitulo;
	    	
	    }
	}


