package Modelo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
public class Excel {
	
	public Vector< Vector <Integer> > importar(String archivo) {
		
		File archivoXLS = new File(archivo);
		System.out.println(archivoXLS.exists());
		Vector<Vector<Integer>>  matriz = new Vector<Vector<Integer>>();
		try {
			FileInputStream file = new FileInputStream(archivoXLS);
            
		// Crear el objeto que tendra el libro de Excel

			XSSFWorkbook libro = new XSSFWorkbook(file);
			Sheet sheet = libro.getSheetAt(0);  // El input es la hoja que buscamos
			Iterator <Row> filas = sheet.iterator();
			Row fila;
			System.out.println(filas.hasNext());
			while (filas.hasNext()){
				System.out.println("FILA" );
				fila = filas.next();
				Vector<Integer> row = new Vector<>();

	           // Obtenemos el iterator que permite recorres todas las celdas de una fila

                System.out.println("FILA" );
				Iterator<Cell> celdas= fila.cellIterator();
			    Cell celda;
			    while (celdas.hasNext()){

			    	celda = celdas.next();
                    

			    	// Dependiendo del formato de la celda 
			    	row.add((int) celda.getNumericCellValue());

			    	System.out.println(celda.getNumericCellValue());
			    }
			    matriz.add(row);
					
			}
			libro.close();
			return matriz;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return matriz;
		}
		
	}
	
	public void exportar(Vector< Vector <Integer> > matriz, String archivo) {
		String rutaArchivo = archivo;
		File archivoXLS = new File(rutaArchivo);
		int numFila = matriz.size();
		int numCol = matriz.get(0).size();
		System.out.println(numFila);
		System.out.println(numCol);
		try {
			XSSFWorkbook libro = new XSSFWorkbook();
			
			// La planilla de celdas
			Sheet hoja = libro.createSheet("DAA1");
            for (int i = 0; i < numFila; i++) {

                Row fila = hoja.createRow(i);

                for (int j = 0; j < numCol; j++) {

                    Cell celda = fila.createCell(j);
                    //System.out.println(matriz.get(i+1).get(j));
                    celda.setCellValue(matriz.get(i).get(j)); // aqui puedo ir cambiando los valores


 
                   FileOutputStream fos = new FileOutputStream(archivoXLS);
                   libro.write(fos);

                }

            }
			}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
	
	/*public String abrirArchivo() {
		  String aux="";   
		  texto="";
		  try
		  {
		   JFileChooser file=new JFileChooser();
		   file.showOpenDialog(this);
		   
		   File abre=file.getSelectedFile();
	
		   if(abre!=null)
		   {     
		      FileReader archivos=new FileReader(abre);
		      BufferedReader lee=new BufferedReader(archivos);
		      while((aux=lee.readLine())!=null)
		      {
		         texto+= aux+ "\n";
		      }
		         lee.close();
		    }    
		   }
		   catch(IOException ex)
		   {
		     JOptionPane.showMessageDialog(null,ex+"" +
		           "\nNo se ha encontrado el archivo",
		                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		    }
		  return texto;//El texto se almacena en el JTextArea
		}
	*/
	public Vector< Vector <Integer> > crearMatriz(int m, int n){

		Vector<Vector<Integer>>  matriz = new Vector<Vector<Integer>>();
		for(int i=0;i<m;i++){
			Vector<Integer> fila = new Vector<>();
			for(int j=0;j<n;j++){

				fila.add((int) (Math.random()*100));
			}
			matriz.add(fila);
		}
		return matriz;
		
	}
}
