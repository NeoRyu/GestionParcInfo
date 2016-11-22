package application.viewer;

import application.MainAppFX;
import application.beans.*;
import application.dao.DAOComposant;
import application.dao.DAOMachine;
import application.tools.LectureRB;
import application.tools.Sound;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Set;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static application.viewer.MachineController.idMachineSelect;

/**
 * @author Neo_Ryu
 */
public class ComposantController {

    static DAOMachine daoMachine = new DAOMachine();
    static DAOComposant daoComposant = new DAOComposant();

    // Référence pour le tableview et les colonnes
    @FXML
    private TableView<Composant> tableFX;
    @FXML
    private TableColumn<Composant, String> colone;
    @FXML
    private TableColumn<Composant, String> coltwo;

    private ObservableList<Composant> DataComposant = FXCollections.observableArrayList();

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
    @FXML
    private Label label8;
    @FXML
    private Label label9;


    // Référence à l'application principale
    public MainAppFX mainAppFX;
    public Sound sound = new Sound();
    public static ResourceBundle player = ResourceBundle.getBundle("application.Config");

    // priva

    @FXML
    private Button START, SELECT, CANCEL, SWITCH;
    @FXML
    public static Button ENTER;
    public static String btnSelected = "";    // Permet de determiner le bouton selectionneé pour switchcase
    @FXML
    private ButtonBar btnBar;
    @FXML
    private Label labDet, Label1, Label2, Label3, Label4, Label5, Label6, Label7, Label8, Label9;

    /**
     * Initialise la classe controller.
     * Cette methode est automatiquement appelée après le chargement du fichier FXML.
     */
    @FXML
    private void initialize() {
        if (player.getString("sound").equals("ON")) {
            sound = new Sound(mainAppFX, "../../res/bitVALID.wav");
            sound.Play();
        }
        List<Composant> liste = daoComposant.lecture(idMachineSelect);
        DataComposant.addAll(liste);


        // Initialise la tableFX avec deux colonnes
        colone.setCellValueFactory(cellData -> {
            return cellData.getValue().idSPProperty();
        });
        coltwo.setCellValueFactory(cellData -> {
            return cellData.getValue().typeSPProperty();
        });

        // Nettoyage des details
        showDetails(null);

        // Ajout d'un listener pour ecouter les changements :
        // Nous obtenons la selectedItemProperty de la table de machines et lui ajoutons un listener.
        // Chaque fois que l'utilisateur sélectionne une machine dans la table, notre expression lambda est exécutée.
        // Nous prenons la machine nouvellement sélectionnée pour la transmettre à la méthode showDetails(...).
        tableFX.getSelectionModel().selectedItemProperty().addListener((observable, oldValeur, newValeur) -> showDetails(newValeur));

    }

    public ObservableList<Composant> getDataComposant() {
        return DataComposant;
    }

    // AFFICHAGE DE DETAILS DANS LE GRIDVIEW
    private <T extends Composant> void showDetails(T composant) {

        // CONFIGURATION DES BOUTTONS
        START.setFont(MainAppFX.f);
        SELECT.setFont(MainAppFX.f);
        CANCEL.setFont(MainAppFX.f);
        SWITCH.setFont(MainAppFX.f);

        // Au premier appui touche sur le tableview, enclenche le changement de style
        Set<Node> cells = tableFX.lookupAll(".table-cell");
        cells.forEach((c) -> {
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
        label8.setFont(MainAppFX.f);
        label9.setFont(MainAppFX.f);
        labDet.setFont(MainAppFX.f);
        Label1.setFont(MainAppFX.f);
        Label2.setFont(MainAppFX.f);
        Label3.setFont(MainAppFX.f);
        Label4.setFont(MainAppFX.f);
        Label5.setFont(MainAppFX.f);
        Label6.setFont(MainAppFX.f);
        Label7.setFont(MainAppFX.f);
        Label8.setFont(MainAppFX.f);
        Label9.setFont(MainAppFX.f);

        // ATTRIBUTION DES DONNEES
        if (composant != null) {
            if (composant instanceof CarteMere) {
                CarteMere carteMere = (CarteMere) composant;
                label1.setText(String.valueOf(carteMere.getId()));
                label2.setText(carteMere.getLibelle());
                label3.setText(carteMere.getReference());
                label4.setText(carteMere.getConstructeur());
                label5.setText(carteMere.getDetails());
                label6.setText(String.valueOf(carteMere.getIdMachine()));
                label7.setText(carteMere.getType());
                Label8.setText(LectureRB.lireRB("UIResources", "lab_cm_format"));
                label8.setText((carteMere.getFormat()));
                Label9.setText("");
                label9.setText("");
            } else if (composant instanceof Ram) {
                Ram ram = (Ram) composant;
                label1.setText(String.valueOf(ram.getId()));
                label2.setText(ram.getLibelle());
                label3.setText(ram.getReference());
                label4.setText(ram.getConstructeur());
                label5.setText(ram.getDetails());
                label6.setText(String.valueOf(ram.getIdMachine()));
                label7.setText(ram.getType());
                Label8.setText(LectureRB.lireRB("UIResources", "lab_capacite"));
                label8.setText(String.valueOf(ram.getCapaciteGo()));
                Label9.setText("");
                label9.setText("");
            } else if (composant instanceof DisqueDur) {
                DisqueDur disqueDur = (DisqueDur) composant;
                label1.setText(String.valueOf(disqueDur.getId()));
                label2.setText(disqueDur.getLibelle());
                label3.setText(disqueDur.getReference());
                label4.setText(disqueDur.getConstructeur());
                label5.setText(disqueDur.getDetails());
                label6.setText(String.valueOf(disqueDur.getIdMachine()));
                label7.setText(disqueDur.getType());
                Label8.setText(LectureRB.lireRB("UIResources", "lab_dd_format"));
                label8.setText(disqueDur.getFormat());
                Label9.setText(LectureRB.lireRB("UIResources", "lab_capacite"));
                label9.setText(String.valueOf(disqueDur.getStockageGo()));
            } else if (composant instanceof Logiciel) {
                Logiciel logiciel = (Logiciel) composant;
                label1.setText(String.valueOf(logiciel.getId()));
                label2.setText(logiciel.getLibelle());
                label3.setText(logiciel.getReference());
                label4.setText(logiciel.getConstructeur());
                label5.setText(logiciel.getDetails());
                label6.setText(String.valueOf(logiciel.getIdMachine()));
                label7.setText(logiciel.getType());
                Label8.setText(LectureRB.lireRB("UIResources", "lab_architecture"));
                label8.setText(String.valueOf(logiciel.getArchitecture()));
                Label9.setText("");
                label9.setText("");
            } else if (composant instanceof Processeur) {
                Processeur processeur = (Processeur) composant;
                label1.setText(String.valueOf(processeur.getId()));
                label2.setText(processeur.getLibelle());
                label3.setText(processeur.getReference());
                label4.setText(processeur.getConstructeur());
                label5.setText(processeur.getDetails());
                label6.setText(String.valueOf(processeur.getIdMachine()));
                label7.setText(processeur.getType());
                Label8.setText(LectureRB.lireRB("UIResources", "lab_coeurs"));
                label8.setText(String.valueOf(processeur.getCoeurs()));
                Label8.setText(LectureRB.lireRB("UIResources", "lab_frequence"));
                label9.setText(String.valueOf(processeur.getFrequence()));
            } else if (composant instanceof SystemeExploitation) {
                SystemeExploitation systemeExploitation = (SystemeExploitation) composant;
                label1.setText(String.valueOf(systemeExploitation.getId()));
                label2.setText(systemeExploitation.getLibelle());
                label3.setText(systemeExploitation.getReference());
                label4.setText(systemeExploitation.getConstructeur());
                label5.setText(systemeExploitation.getDetails());
                label6.setText(String.valueOf(systemeExploitation.getIdMachine()));
                label7.setText(systemeExploitation.getType());
                Label8.setText(LectureRB.lireRB("UIResources", "lab_architecture"));
                label8.setText(systemeExploitation.getFormat());
                Label9.setText(LectureRB.lireRB("UIResources", "lab_architecture"));
                label9.setText(String.valueOf(systemeExploitation.getArchitecture()));
            } else {
                // Remplissage des labels avec les données Composant de l'item selectionné dans le tableview
                // Les champs de l'objet Composant
                label1.setText(String.valueOf(composant.getId()));
                label2.setText(composant.getLibelle());
                label3.setText(composant.getReference());
                label4.setText(composant.getConstructeur());
                label5.setText(composant.getDetails());
                label6.setText(String.valueOf(composant.getIdMachine()));
                label7.setText(composant.getType());
                Label8.setText("");
                label8.setText("");
                Label9.setText("");
                label9.setText("");
            }
        } else {
            // Composant est null, on retire tout le texte
            label1.setText("");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            label5.setText("");
            label6.setText("");
            label7.setText("");
            label8.setText("");
            label9.setText("");
        }

    }

    // AJOUTER : Methode appelée lorsque l'utilisateur clique sur le boutton d'ajout
    @FXML
    private void handleSTART() {
        if (player.getString("sound").equals("ON")) {
            sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
            sound.Play();
        }
        btnSelected = "SELECT";
          /*
          Collection<Composant> lol = new ArrayList<Composant>();
		 Machine newMachine = new Machine(0, 0, "", "", "", 0, "", "", false, 0, lol);
		  boolean okClic = mainAppFX.showMachineEditDialog(newMachine);
		  if (okClic) {
			  mainAppFX.getData().add(newMachine);
		  }
		  */
    }

    //  MODIFIER : Methode appelée lorsque l'utilisateur clique sur le bouton de modification
    @FXML
    private void handleSELECT() {
        if (player.getString("sound").equals("ON")) {
            sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
            sound.Play();
        }
        btnSelected = "SELECT";
         /*
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
		 */
    }

    // SUPPRIMER : Methode appelée lorsque l'utilisateur clique sur le bouton de suppression
    @FXML
    private void handleCANCEL() {
        if (player.getString("sound").equals("ON")) {
            sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
            sound.Play();
        }
          /*
		  int selectedIndex = tableFX.getSelectionModel().getSelectedIndex();
		  if (selectedIndex >= 0) {
			  // Une ligne a été séléctionnée
			  Alert alert = new Alert(AlertType.CONFIRMATION);
			  alert.initOwner(mainAppFX.getPrimaryStage());
			  alert.setTitle("Confirmation de suppression");
			  alert.setHeaderText("Êtes-vous sûr de vouloir supprimer cette donnée ?");
			  alert.setContentText("Une suppression est définitive, confirmer ?");
			  ButtonType buttonTypeConfirm = new ButtonType("CONFIRMER");
			  ButtonType buttonTypeCancel = new ButtonType("ANNULER", ButtonData.CANCEL_CLOSE);
			  alert.getButtonTypes().setAll(buttonTypeConfirm, buttonTypeCancel);
			  Optional<ButtonType> result = alert.showAndWait();
			  if (result.get() == buttonTypeConfirm){	// Bouton CONFIRMER
				  if (player.getString("sound").equals("ON")) {
					  sound = new Sound(mainAppFX, "../../res/bitDELETE.wav");
					  sound.Play();
				  }
				  tableFX.getItems().remove(selectedIndex);
				  // TODO : SQL DELETE
			  } else { 			// Bouton CANCEL ou fermeture de la fenetre
				  if (player.getString("sound").equals("ON")) {
					  sound = new Sound(mainAppFX, "../../res/bitCANCEL.wav");
					  sound.Play();
				  }
			  }	
		  } else {
			  // Aucune selection à supprimer...
			  Alert alert = new Alert(AlertType.WARNING);
			  alert.initOwner(mainAppFX.getPrimaryStage());
			  alert.setTitle("Erreur 404");
			  alert.setHeaderText("Aucune donnée à supprimer");
			  alert.setContentText("Veuillez selectionner une ligne dans le tableau !");
			  alert.showAndWait();
		  }
		  */
    }
	 
	 

	 // GAMEPAD
	 @FXML
	 private void handleENTER() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		 }
		 // Simule un clic sur l'un des boutons selectionné sur la droite du PAD
		 if (btnSelected != "") {
			 switch (btnSelected.toUpperCase()) {
			 	case "START" :
			 		handleSTART();
			 		break;
			 	case "SELECT" :
			 		handleSELECT();
			 		break;
			 	case "CANCEL" :
			 		handleCANCEL();
			 		break;
			 	default:			 		
					break;
			 }
		 } else {
			START.requestFocus();
			btnSelected = "START";
		 }
	 }
	 	 
	 @FXML
	 private void handleLEFT() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 // Permet de se deplacer vers la GAUCHE du ButtonBar	
		 switch (btnSelected) {
			 case "START" :
				 CANCEL.requestFocus();
				 btnSelected = "CANCEL";
				 break;			 
			 case "CANCEL" :
				 SELECT.requestFocus();
				 btnSelected = "SELECT";
				 break;
			 case "SELECT" :
			 default :
				START.requestFocus();
				btnSelected = "START";
				break;
		 }	 
	 }
	 
	 @FXML
	 private void handleRIGHT() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 // Permet de se deplacer vers la DROITE du ButtonBar
		 switch (btnSelected) {
			 case "START" :
				 SELECT.requestFocus();
				 btnSelected = "SELECT";
				 break;
			 case "SELECT" :
				 CANCEL.requestFocus();
				 btnSelected = "CANCEL";
				 break;
			 case "CANCEL" :
			 default :
				 START.requestFocus();
				 btnSelected = "START";
				 break;
		 }		 
	 }
	 
	 @FXML
	 private void handleUP() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 // Permet de se deplacer vers le HAUT du TableView
		 scrollTableFX(true);
	 }	
	 
	 @FXML
	 private void handleDOWN() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 // Permet de se deplacer vers le BAS du TableView
		 scrollTableFX(false);
	 }
	 
	 // METHODE PERMETTANT DE NAVIGUER DANS LE TABLEVIEW
	 private void scrollTableFX(Boolean dir) {
		 int taille = tableFX.getItems().size();	 
		 int Index = tableFX.getSelectionModel().getSelectedIndex();
		 if(Index <= taille) {
			 if (dir) {	// TRUE = handleUP()
				 Index--;
			 } else {	// FALSE = handleDOWN()
				 Index++;
			 }
             tableFX.scrollTo(Index);
             tableFX.getFocusModel().focus(Index);
             tableFX.getSelectionModel().select(Index);
		 }
	}
	 
	 
	 @FXML
	 private void handleSWITCH() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMENU.wav");
			 sound.Play();
		 }
		 // Permet de switcher entre les fenetres MACHINE et COMPOSANT
		 mainAppFX.showOverview("viewer/Machine.fxml");
	 }
	 
	 
	 /**
	 * Appellé par l'application principale pour avoir une référence de retour sur elle-même
	 *
	 * @param mainApp
	 */     
	 public void setMainAppFX(MainAppFX mainAppFX) {
	        this.mainAppFX = mainAppFX;
	        mainAppFX.Reflexivite();
	        
	        // Ajout de la liste des données observables dans le tableview " tableFX "
	        tableFX.setItems(DataComposant);

	        // selection du premier element
	        try {
	            tableFX.getSelectionModel().select(0);
	        } catch (NullPointerException e) {
	            Logger.getLogger(ComposantController.class.getName()).log(Level.SEVERE, null, e);
	        }		
	 }	
}