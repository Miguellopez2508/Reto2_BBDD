package Controlador;

import javafx.stage.Stage;
import Conexion.ModificarBD;
import Conexion.Textos;
import Modelo.Modelo;
import javafx.application.Application;


public class Main extends Application {
	
	static Modelo modelo;
	static Controlador controlador;
	static Stage stage;
	static Textos textos;
	ModificarBD modificar = new ModificarBD();
	
	
	/**
     * Método que inicia el programa
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
        
      
    }

    /**
     * Inicia el programa
     */
    @Override
    public void start(Stage stage) {
        Main.stage = stage;
        
        iniciarPrograma();
       
        textos.leerXml("C:\\WORKSPACE\\Reto2_BBDD\\textos\\empleados.xml");

        modificar.insertarEmpleados(modelo.getEmpleados().get(0));
        System.out.println(modelo.getEmpleados().get(0).toString());


    }
	
    /**
     * 
     */
    public static void iniciarPrograma() {
        
        modelo = new Modelo();
        controlador = new Controlador(stage);
        textos = new Textos(modelo); 
        
    }
}
