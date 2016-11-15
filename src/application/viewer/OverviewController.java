package application.viewer;

import java.util.ResourceBundle;

import application.MainAppFX;
import application.tools.Sound;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
*
* @author Neo_Ryu
*/
public class OverviewController {
		
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
		private Button START, SELECT, CANCEL;
		@FXML
		public static Button ENTER;
		public static String btnSelected = "";

		// Référence à l'application principale
		public static MainAppFX mainAppFX;
		public static Sound sound = new Sound();
		public static ResourceBundle player = ResourceBundle.getBundle("application.Config");


	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appelée après le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
		 if (player.getString("sound").equals("ON")) {
	 		 sound = new Sound(mainAppFX, "../../res/bitVALID.wav");
	 		 sound.Play();
		 }
	}
	 
	 
// GAMEPAD
 	 // Methode appelée lorsque l'utilisateur clique sur le bouton START
	 @FXML
	 private void handleSTART() {
		  btnSelected = "START";
		  if (player.getString("sound").equals("ON")) {
			  sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			  sound.Play();
		  }
	 }
	 
	 //   Methode appelée lorsque l'utilisateur clique sur le bouton SELECT
	 @FXML
	 private void handleSELECT() {
		 btnSelected = "SELECT";
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		 }
	 }

	 // Methode appelée lorsque l'utilisateur clique sur le bouton CANCEL
	 @FXML
	 private void handleCANCEL() {
		 btnSelected = "CANCEL";
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		 }
	 } 
	 
	// Simule un clic sur l'un des boutons selectionnés sur la droite du PAD
	 @FXML
	 private void handleENTER() {
		 if (player.getString("sound").equals("ON")) {
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
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 switch (btnSelected) {
			 case "START" :
				 CANCEL.requestFocus();
				 btnSelected = "CANCEL";
				 break;
			 case "SELECT" :
				 START.requestFocus();
				 btnSelected = "START";
				 break;
			 case "CANCEL" :
				 SELECT.requestFocus();
				 btnSelected = "SELECT";
				 break;
			 default :
				START.requestFocus();
				btnSelected = "START";
				break;
		 }	 
	 }
	 
	 // Permet de se deplacer vers la DROITE du ButtonBar
	 @FXML
	 private void handleRIGHT() {
		 if (player.getString("sound").equals("ON")) {
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
				 START.requestFocus();
				 btnSelected = "START";
				 break;
			 default :
				START.requestFocus();
				btnSelected = "START";
				break;
		 }		 
	 }
	 
	 // TODO
	 @FXML
	 private void handleUP() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 handleRIGHT();		 
	 }	 
	 
	 // TODO
	 @FXML
	 private void handleDOWN() {
		 if (player.getString("sound").equals("ON")) {
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
	 }	
}