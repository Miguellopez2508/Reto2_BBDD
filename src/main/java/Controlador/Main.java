package Controlador;

import javafx.stage.Stage;
import Conexion.Textos;
import Modelo.Modelo;
import javafx.application.Application;


public class Main extends Application {
	
	public static Modelo modelo;
	public static Controlador controlador;
	public static Stage stage;
	
	public static Textos textos;
	
	/**
     * Método que inicia el programa usando el metodo start
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Inicia el programa y el Stage
     */
    @Override
    public void start(Stage stage) {
        Main.stage = stage;
        
        iniciarPrograma();
       
        modelo.setPrimeraVezDesdeBDD();
        
        if (modelo.primeraVez) {
        	modelo.getModificar().crearPrimeraVez();
        	cargarBasesDeDatos();
        }
    }
	
    /**
     *  Inicia el modelo y el controlador
     *  
     */
    public static void iniciarPrograma() {
        modelo = new Modelo();
        controlador = new Controlador(stage);
        textos = new Textos(modelo);
    }
    
    /**
     *  Carga los objetos departamento y empleados y los sube a la BDD
     */
    public static void cargarBasesDeDatos() {
    	
    	 final String xml = System.getProperty("user.dir") + "\\empleados.xml";
    	 final String csv = System.getProperty("user.dir") + "\\departamentos.csv";
    	
    	 textos.leerXml(xml);
    	 textos.cogerDatosCsV(csv);

    	 for (int i = 0; i < modelo.getDepartamentos().size(); i++) {
    		 modelo.getModificar().insertarDepartamentos(modelo.getDepartamentos().get(i));
    	 }
    	 
    	 for (int i = 0; i < modelo.getEmpleados().size(); i++) {
    		 modelo.getModificar().insertarEmpleados(modelo.getEmpleados().get(i));
    	 }
    }
}
