package application.viewer;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.io.IOException;

import com.sun.media.jfxmedia.logging.Logger;

import application.MainAppFX;
import application.DAO.objets.Machine;

import javafx.fxml.FXMLLoader;


public class OverviewController {
		
		@FXML
		private static TableView<Machine> tableFX; 
		@FXML
		private TableColumn<Machine, String> col1;
		@FXML
		private TableColumn<Machine, String> col2;
		 
		@FXML
		private Label label1;
		@FXML
		private Label label2;
		@FXML
		private Label label3;
		@FXML
		private Label label4;
		@FXML
		private Label label5;
		@FXML
		private Label label6;
		@FXML
		private Label label7;

		// Référence à l'application principale
		public static MainAppFX mainAppFX;
		public static ObservableList<Machine> liste; 

		/*
		public OverviewController() throws IOException {
			super();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Overview.fxml")); //= new FXMLLoadergetClass().getResource("Overview.fxml");
			loader.setController(new OverviewController());
			Pane mainPane = FXMLLoader.load(getClass().getResource("/Overview.fxml"));
			
		}


		*/
		

	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appelée après le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
		
		
		// Initialise la tableFX avec deux colonnes
		 col1.setCellValueFactory(cellData -> cellData.getValue().idProperty()); 
		 col2.setCellValueFactory(cellData -> cellData.getValue().adresseIPProperty());
		 
	}
	 
	 /**
	 * Appellé par l'application principale pour avoir une référence de retour sur elle-même
	 *
	 * @param mainApp
	 */
	 public static void setMainAppFX() {
		 
		 liste = mainAppFX.getData();
		 
		 // Ajout de la liste des données observables dans la tableFX
		 //tableFX.setEditable(true);
		 
		 System.out.println(mainAppFX.getData().get(1));
		 //tableFX.setItems(liste); //TODO gros probleme
		 
		
	 }
	
}