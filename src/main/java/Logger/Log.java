package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;



public class Log {
	
	private static Log log;

    private Log(){
    	
    }

    public static Log getInstance() {
       if (log == null) { 
    	   log = new Log();
       }
        return log;
    }
    
    public void escribirLogger(String mensaje, Object objeto) {

        
        String ruta = System.getProperty("user.dir") + "\\log.txt";

        try {
        	Calendar fecha = Calendar.getInstance();
        	FileWriter fw = abrirArchivo(ruta);
        	fw.write(fecha.get(Calendar.DAY_OF_MONTH) + " " + (fecha.get(Calendar.MONTH)+1) + " " + fecha.get(Calendar.YEAR) + " " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + fecha.get(Calendar.MINUTE) + " " + ". Clase: " + objeto.getClass() + ". Info: " + mensaje + "\r\n");
        	cerrarArchivo(fw);
           
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private void cerrarArchivo(FileWriter fw) throws IOException {
		fw.close();
	}
	
	private FileWriter abrirArchivo(String ruta) throws IOException {
		return new FileWriter(ruta, true);     	
    }



}
