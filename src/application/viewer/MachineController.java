package application.viewer;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import application.MainAppFX;
import application.DAO.objets.Machine;

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
		public MainAppFX mainAppFX;


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
	 
	// AFFICHAGE DE DETAILS DANS LE GRIDVIEW
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
	 
	 // AJOUTER : Methode appelée lorsque l'utilisateur clique sur le boutton d'ajout
	 @FXML
	 private void handleNew() {
		  Machine newMachine = new Machine("","","","","","",""); // TODO - COMPOSANT
		  boolean okClic = mainAppFX.showMachineEditDialog(newMachine);
		  if (okClic) {
			  mainAppFX.getDataMachine().add(newMachine);
		  }
	 }
	 
	 //  MODIFIER : Methode appelée lorsque l'utilisateur clique sur le boutton de modification
	 @FXML
	 private void handleEdit() {
		 Machine selection = tableFX.getSelectionModel().getSelectedItem();
		 if (selection != null) {
			  boolean okClic = mainAppFX.showMachineEditDialog(selection);
			  if (okClic) {
				  showDetails(selection);
			  }
		 } else {
			  // Si rien n'est séléctionné
			  Alert alert = new Alert(AlertType.WARNING);
			  alert.initOwner(mainAppFX.getPrimaryStage());
			  alert.setTitle("Aucune selection");
			  alert.setHeaderText("Aucune donnée selectionnée");
			  alert.setContentText("Selectionnez une ligne dans la table");
			  alert.showAndWait();
		 }
	 }

	 // SUPPRIMER : Methode appelée lorsque l'utilisateur clique sur le boutton de suppression
	 @FXML
	 private void handleDelete() {
		  int selectedIndex = tableFX.getSelectionModel().getSelectedIndex();
		  if (selectedIndex >= 0) {
			  // Une ligne a été séléctionnée
			  tableFX.getItems().remove(selectedIndex);
		  } else {
			  // Aucune selection à supprimer...
			  Alert alert = new Alert(AlertType.WARNING);
			  alert.initOwner(mainAppFX.getPrimaryStage());
			  alert.setTitle("Erreur 404");
			  alert.setHeaderText("Aucune données à supprimer");
			  alert.setContentText("Veuillez selectionner une ligne dans le tableau !");
			  alert.showAndWait();
		  }
	 }


	 
	 /**
	 * Appellé par l'application principale pour avoir une référence de retour sur elle-même
	 *
	 * @param mainApp
	 */
	 public void setMainAppFX(MainAppFX mainAppFX) {		
		this.mainAppFX = mainAppFX; 
		// Ajout de la liste des données observables dans le tableview " tableFX "
		tableFX.setItems(mainAppFX.getDataMachine());		
	 }
	
}