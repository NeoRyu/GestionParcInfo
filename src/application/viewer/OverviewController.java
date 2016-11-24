package application.viewer;

import java.util.ResourceBundle;

import application.MainAppFX;
import application.beans.Stats;
import application.dao.DAOStats;
import application.tools.Sound;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


/**
*
* @author Neo_Ryu
*/
public class OverviewController {
		
		DAOStats daoStats = new DAOStats();
		private ObservableList<Stats> listTypeMachine = FXCollections.observableArrayList();
	
		// Référence pour les labels
		@FXML private Label labDet, label1, label2, label3, label4, label5, label6, label7;
		@FXML private Label Label1, Label2, Label3, Label4, Label5, Label6, Label7;
		@FXML private GridPane gdPane; 
		
		@FXML private PieChart camembert; 
		
		@FXML
		private Button START, SELECT, CANCEL;
		@FXML
		public static Button ENTER;
		public static String btnSelected = "";

		// Référence à l'application principale
		public static MainAppFX mainAppFX;
		public static Sound sound = new Sound();
		public static ResourceBundle config = ResourceBundle.getBundle("application.Config");
		public static ResourceBundle request = ResourceBundle.getBundle("application.resources.query_fr_FR");

	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appelée après le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
        showDetails("");
	}
	 
	private void showDetails(String stat) {
		 // CONFIGURATION DE LA POLICE D'ECRITURE
			if (stat.equals("")) {
				// IHM GLOBALE
				START.setFont(MainAppFX.f);
			    SELECT.setFont(MainAppFX.f);
			    CANCEL.setFont(MainAppFX.f);
			    labDet.setFont(MainAppFX.f);
			    
		        // LIBELLE
		        Label1.setFont(MainAppFX.f);
		        Label1.setText("TYPES DE MACHINES :");
		        Label2.setFont(MainAppFX.f);
		        Label3.setFont(MainAppFX.f);
		        Label4.setFont(MainAppFX.f);
		        Label5.setFont(MainAppFX.f);
		        Label6.setFont(MainAppFX.f);
		        Label7.setFont(MainAppFX.f);
		        
		        // QUANTITE
		        label1.setFont(MainAppFX.f);
		        label2.setFont(MainAppFX.f);
		        label3.setFont(MainAppFX.f);
		        label4.setFont(MainAppFX.f);
		        label5.setFont(MainAppFX.f);
		        label6.setFont(MainAppFX.f);
		        label7.setFont(MainAppFX.f);
			}
	        
	     // ATTRIBUTION ET AFFICHAGE DES DONNEES 
	        // [ TYPE MACHINE ]
	        if (stat.equals("TypeMachine")) {	        	
	            int quantite = 0;
	            for (int i = 0 ; i < listTypeMachine.size() ; i++) {
	            	//quantite = quantite + listTypeMachine.get(i).getIntQteSP();
	            	quantite++;
	            	if(config.getString("test").equals("1")) {
	            		System.out.println("> "+listTypeMachine.get(i).getNom()+" : "+listTypeMachine.get(i).getQte());
	            	}
	            }
	            label1.setText(String.valueOf(quantite));
	            System.out.println("> TYPE MACHINE : "+String.valueOf(quantite));
	            
	            for (int i = 0 ; i < listTypeMachine.size() ; i++) {
	            	// LIBELLE + QTE
	            	System.out.println(
	            		listTypeMachine.get(i).getNomSP() 
	            			+ " -> " +	            	
	            		listTypeMachine.get(i).getIntQteSP()
	            	);
	            	
	            	// TODO : Mettre les données qui suivent dans un graphique en camenbert	
	            	camembert.setLabelLineLength(10);
	            	camembert.setLegendSide(Side.LEFT);
	            	System.out.println("CAMEMBERT");
	            }

	        }
	        
	        // TODO - idem qu'au dessus pour els autres types de données de stats	        
	}
	
	 
	 
// GAMEPAD
 	 // Methode appelée lorsque l'utilisateur clique sur le bouton START
	 @FXML
	 private void handleSTART() {
		  btnSelected = "START";
		  if (config.getString("sound").equals("ON")) {
			  sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			  sound.Play();
		  }
	 }
	 
	 //   Methode appelée lorsque l'utilisateur clique sur le bouton SELECT
	 @FXML
	 private void handleSELECT() {
		 btnSelected = "SELECT";
		 if (config.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		 }
	 }

	 // Methode appelée lorsque l'utilisateur clique sur le bouton CANCEL
	 @FXML
	 private void handleCANCEL() {
		 btnSelected = "CANCEL";
		 if (config.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		 }
	 } 
	 
	// Simule un clic sur l'un des boutons selectionnés sur la droite du PAD
	 @FXML
	 private void handleENTER() {
		 if (config.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		 }
		 
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
	 
	 // Permet de se deplacer vers la GAUCHE du ButtonBar	
	 @FXML
	 private void handleLEFT() {
		 if (config.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
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
	 
	 // Permet de se deplacer vers la DROITE du ButtonBar
	 @FXML
	 private void handleRIGHT() {
		 if (config.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
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
	 
	 // UP = RIGHT
	 @FXML
	 private void handleUP() {
		 if (config.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 handleRIGHT();		 
	 }	 
	 
	 // DOWN = LEFT
	 @FXML
	 private void handleDOWN() {
		 if (config.getString("sound").equals("ON")) {
			sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
		 	sound.Play();
		 }
		 handleLEFT();
	 }
		 
		 
	 /**
	 * Appellé par l'application principale pour avoir une référence de retour sur elle-même
	 *
	 * @param mainApp
	 */
	 public void setMainAppFX(MainAppFX mainAppFX) {		
		this.mainAppFX = mainAppFX;	
		mainAppFX.Reflexivite();
		
		// Récupération et stockage des données
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	listTypeMachine = daoStats.countTypeMachine(request.getString("countTypeMachine"));
            	showDetails("TypeMachine");
            }
        });		
	 }	
	 
}