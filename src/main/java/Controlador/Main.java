package Controlador;

import javafx.stage.Stage;



import Modelo.Modelo;
import javafx.application.Application;


public class Main extends Application {
	
	static Modelo modelo;
	static Controlador controlador;
	static Stage stage;
	
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
    public void start(Stage stage) {
        Main.stage = stage;
        iniciarPrograma();
    }
	
    public static void iniciarPrograma() {
        try{
            modelo = new Modelo();
            controlador = new Controlador(stage);
        } catch(Exception e1) {
            e1.printStackTrace();
           
        }
    }
}
