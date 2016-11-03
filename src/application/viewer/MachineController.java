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


public class MachineController {
		
		// Référence pour le tableview et les colonnes
		@FXML
		private TableView<Machine> tableFX;
		@FXML
		private TableColumn<Machine, String> colone;
		@FXML
		private TableColumn<Machine, String> coltwo;
		 
		// Référence pour les labels
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


	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appelée après le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
		// Initialise la tableFX avec deux colonnes
		 colone.setCellValueFactory(cellData -> cellData.getValue().idAfpaProperty()); 
		 coltwo.setCellValueFactory(cellData -> cellData.getValue().adresseIPProperty());
		 
		 
	}
	 
	 /**
	 * Appellé par l'application principale pour avoir une référence de retour sur elle-même
	 *
	 * @param mainApp
	 */
	 public void setMainAppFX(MainAppFX mainAppFX) {		
		this.mainAppFX = mainAppFX;
		 
		// Affichage des données en mode console : fonctionnel	
		//System.out.println(mainAppFX.getData().get(0).getAdresseIP());
		 
		// Ajout de la liste des données observables dans le tableview " tableFX "
		tableFX.setItems(mainAppFX.getData()); //TODO : les données sont dispo, mais l'insertion dans le tableview merde...
		
	 }
	
}