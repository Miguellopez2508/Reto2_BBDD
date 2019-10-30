package Controlador;

import java.io.IOException;

import com.jfoenix.controls.JFXDecorator;

import Modelo.Modelo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controlador {
	
	public Stage stage;
 
	public Controlador(Stage stage) {
		this.stage = stage;
		
		CambiarScene("Principal.fxml");
	}
	
	/**
	 * Cambia de escena (vista)
	 * @param FXMLLink
	 */
	public void CambiarScene(String FXMLLink) {
		Parent FXML = loadFXML(FXMLLink);
		if (FXML != null) {
			Stage stageAntiguo = stage;
			stage = new Stage();
			JFXDecorator decorator = new JFXDecorator(stage, FXML, false, false, true);
			decorator.getStylesheets().add("reto2.css");
			Scene scene = new Scene(decorator);
			scene.getStylesheets().add("reto2.css");
			stage.setTitle("Colegio");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			stageAntiguo.close();
		}
	}
	
	/**
	 * Carga un archivo FXML
	 * @param FXMLLink
	 * @return
	 */
	
	public Parent loadFXML(String FXMLLink) {
		Parent FXML = null;
		try {
			FXML = FXMLLoader.load(getClass().getResource("/vista/" + FXMLLink));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FXML;
	}
	
}
