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

/**
*
* @author Neo_Ryu
*/
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
		 
		// Nettoyage des details
		 showDetails(null);
		 
		 // Ajout d'un listener pour ecouter les changements :
		 // Nous obtenons la selectedItemProperty de la table de machines et lui ajoutons un listener. 
		 // Chaque fois que l'utilisateur sélectionne une machine dans la table, notre expression lambda est exécutée.
		 // Nous prenons la machine nouvellement sélectionnée pour la transmettre à la méthode showDetails(...).
		 tableFX.getSelectionModel().selectedItemProperty().addListener((observable, oldValeur, newValeur) -> showDetails(newValeur));
	}
	 
	 private void showDetails(Machine machine) {
		 if (machine != null) {
		 // Remplissage des labels avec les données Machine de l'item selectionné dans le tableview
			 label1.setText(machine.getIdSP());
			 label2.setText(machine.getIdAfpaSP());
			 label3.setText(machine.getIdUniqueSP());
			 label4.setText(machine.getDateAchatSP());
			 label5.setText(machine.getDureeGarantieSP());
			 label6.setText(machine.getAdresseIPSP());
			 label7.setText(machine.getTypeSP());
		 } else {
		 // Machine est null, on retire tout le texte
			 label1.setText("");
			 label2.setText("");
			 label3.setText("");
			 label4.setText("");
			 label5.setText("");
			 label6.setText("");
			 label7.setText("");
		 }
	}
	 
	 // Methode appelée lorsque l'utilisateur clique sur le boutton de suppression
	 @FXML
	 private void handleDeletePerson() {
	  int selectedIndex = tableFX.getSelectionModel().getSelectedIndex();
	  tableFX.getItems().remove(selectedIndex);
	 }


	 
	 /**
	 * Appellé par l'application principale pour avoir une référence de retour sur elle-même
	 *
	 * @param mainApp
	 */
	 public void setMainAppFX(MainAppFX mainAppFX) {		
		this.mainAppFX = mainAppFX;
		 
		// Affichage des données en mode console : fonctionnel	
		System.out.println(mainAppFX.getData().get(0).getAdresseIP());
		 
		// Ajout de la liste des données observables dans le tableview " tableFX "
		tableFX.setItems(mainAppFX.getData()); //TODO : les données sont dispo, mais l'insertion dans le tableview merde...
		
	 }
	
}