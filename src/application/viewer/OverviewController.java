package application.viewer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import application.MainAppFX;
import application.DAO.objets.Machine;

public class OverviewController {
		
		@FXML
		private TableView<Machine> tableFX; 
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
		private MainAppFX mainAppFX;



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
	 public void setMainApp(MainAppFX mainAppFX) {
		 this.mainAppFX = mainAppFX;
		 // Ajout de la liste des données observables dans la tableFX
		 tableFX.setItems(mainAppFX.getData());
	 }
	
}