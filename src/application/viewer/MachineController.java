package application.viewer;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import application.MainAppFX;
import application.DAO.objets.Composant;
import application.DAO.objets.Machine;

/**
*
* @author Neo_Ryu
*/
public class MachineController {
		
		// R�f�rence pour le tableview et les colonnes
		@FXML
		private TableView<Machine> tableFX;
		@FXML
		private TableColumn<Machine, String> colone;
		@FXML
		private TableColumn<Machine, String> coltwo;
		 
		// R�f�rence pour les labels
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

		// R�f�rence � l'application principale
		public MainAppFX mainAppFX;
		
		@FXML
		private Button button1, button2, button3;
		@FXML
		private Label labDet, Label1, Label2, Label3, Label4, Label5, Label6, Label7;


	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appel�e apr�s le chargement du fichier FXML.
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
		 // Chaque fois que l'utilisateur s�lectionne une machine dans la table, notre expression lambda est ex�cut�e.
		 // Nous prenons la machine nouvellement s�lectionn�e pour la transmettre � la m�thode showDetails(...).
		 tableFX.getSelectionModel().selectedItemProperty().addListener((observable, oldValeur, newValeur) -> showDetails(newValeur));
	}
	 
	// AFFICHAGE DE DETAILS DANS LE GRIDVIEW
	private void showDetails(Machine machine) {
		// CONFIGURATION DES BOUTTONS
		 button1.setFont(MainAppFX.f);
		 button2.setFont(MainAppFX.f);
		 button3.setFont(MainAppFX.f);
		 
		 Set<Node> cells = tableFX.lookupAll(".table-cell");
	     cells.forEach( (c) -> {
	        c.setStyle("-fx-font-weight:lighter;-fx-font-style:italic;");
	     });
		 
		 // CONFIGURATION DES LABELS
		 label1.setFont(MainAppFX.f);
		 label2.setFont(MainAppFX.f);
		 label3.setFont(MainAppFX.f);
		 label4.setFont(MainAppFX.f);
		 label5.setFont(MainAppFX.f);
		 label6.setFont(MainAppFX.f);
		 label7.setFont(MainAppFX.f);
		 labDet.setFont(MainAppFX.f);
		 Label1.setFont(MainAppFX.f);
		 Label2.setFont(MainAppFX.f);
		 Label3.setFont(MainAppFX.f);
		 Label4.setFont(MainAppFX.f);
		 Label5.setFont(MainAppFX.f);
		 Label6.setFont(MainAppFX.f);
		 Label7.setFont(MainAppFX.f);
		 if (machine != null) {
		 // Remplissage des labels avec les donn�es Machine de l'item selectionn� dans le tableview
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
	 
	 // AJOUTER : Methode appel�e lorsque l'utilisateur clique sur le boutton d'ajout
	 @FXML
	 private void handleNew() {
		  Collection<Composant> lol = new ArrayList<Composant>();
		  Machine newMachine = new Machine("","","","","","","",lol); // TODO - COMPOSANT
		  boolean okClic = mainAppFX.showMachineEditDialog(newMachine);
		  if (okClic) {
			  mainAppFX.getDataMachine().add(newMachine);
		  }
	 }
	 
	 //  MODIFIER : Methode appel�e lorsque l'utilisateur clique sur le boutton de modification
	 @FXML
	 private void handleEdit() {
		 Machine selection = tableFX.getSelectionModel().getSelectedItem();
		 if (selection != null) {
			  boolean okClic = mainAppFX.showMachineEditDialog(selection);
			  if (okClic) {
				  showDetails(selection);
			  }
		 } else {
			  // Si rien n'est s�l�ctionn�
			  Alert alert = new Alert(AlertType.WARNING);
			  alert.initOwner(mainAppFX.getPrimaryStage());
			  alert.setTitle("Aucune selection");
			  alert.setHeaderText("Aucune donn�e selectionn�e");
			  alert.setContentText("Selectionnez une ligne dans la table");
			  alert.showAndWait();
		 }
	 }

	 // SUPPRIMER : Methode appel�e lorsque l'utilisateur clique sur le boutton de suppression
	 @FXML
	 private void handleDelete() {
		  int selectedIndex = tableFX.getSelectionModel().getSelectedIndex();
		  if (selectedIndex >= 0) {
			  // Une ligne a �t� s�l�ctionn�e
			  tableFX.getItems().remove(selectedIndex);
		  } else {
			  // Aucune selection � supprimer...
			  Alert alert = new Alert(AlertType.WARNING);
			  alert.initOwner(mainAppFX.getPrimaryStage());
			  alert.setTitle("Erreur 404");
			  alert.setHeaderText("Aucune donn�es � supprimer");
			  alert.setContentText("Veuillez selectionner une ligne dans le tableau !");
			  alert.showAndWait();
		  }
	 }


	 
	 /**
	 * Appell� par l'application principale pour avoir une r�f�rence de retour sur elle-m�me
	 *
	 * @param mainApp
	 */
	 public void setMainAppFX(MainAppFX mainAppFX) {		
		this.mainAppFX = mainAppFX; 
		// Ajout de la liste des donn�es observables dans le tableview " tableFX "
		tableFX.setItems(mainAppFX.getDataMachine());		
	 }
	
}