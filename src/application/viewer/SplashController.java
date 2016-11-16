package application.viewer;

import application.MainAppFX;
import application.tools.Sound;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import java.util.ResourceBundle;
import javax.swing.*;
import javafx.scene.media.*;
import javafx.util.Duration;

/**
*
* @author Neo_Ryu
*/
public class SplashController extends JFrame {

		// Référence à l'application principale
		public static MainAppFX mainAppFX;
		
		// Sons
		public Sound sound = new Sound();
		public static ResourceBundle player = ResourceBundle.getBundle("application.Config");

		// VIDEO D'INTRODUCTION
		private String VID_URL = //"@../../../res/SEGA.mp4";
				"https://api.telecharger-videos-youtube.com/file/20161116080220-1a140a6ab337496b870d5f630a1d97c6.mp4/sega-logo.mp4";
		public String getVID_URL() {
			return VID_URL;
		}
		public void setVID_URL(String URL) {
			VID_URL = URL;
		}
		 @FXML    	private MediaPlayer mediaPlayer;
		 @FXML    	private Duration duration;
		 @FXML		private MediaView mediaView;
		 @FXML		private FlowPane paneVideo;
		
		// Boutons
		@FXML
		private Button START, SELECT, CANCEL, SWITCH;
		@FXML
		public static Button ENTER;
		public static String btnSelected = "";	// Permet de determiner le bouton selectionneé pour switchcase
		


	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appelée après le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
		// CONFIGURATION DES BOUTTONS
		 START.setFont(MainAppFX.f);
		 SELECT.setFont(MainAppFX.f);
		 CANCEL.setFont(MainAppFX.f);
		 
		 // INITFX
		 initFX();
	 }
	 

	 
	 // AFFICHAGE VIDEO
      public void initFX() {    	  
    	  if (VID_URL.equals(null))	{
    		  return;
    	  }
    	  
    	  final Media media = new Media(getVID_URL()); 
          final MediaPlayer mediaPlayer = new MediaPlayer(media); 
          mediaPlayer.setAutoPlay(true);  
    	  
    	  paneVideo.getChildren().setAll(mediaView);
		  mediaView.setMediaPlayer(mediaPlayer);  
          
		  mediaPlayer.setOnReady(new Runnable() {
			  @Override public void run() {	            			  
	    		  mediaView.fitWidthProperty().bind(paneVideo.widthProperty());
	    		  mediaView.fitHeightProperty().bind(paneVideo.heightProperty());
	    		  mediaView.getMediaPlayer().seek(Duration.ZERO);
	    		  mediaView.getMediaPlayer().play();	 
	    		  
			  }
	      }); 		  
		  
		  mediaPlayer.setOnEndOfMedia(new Runnable() {
			  @Override public void run() {
				  System.out.println("SEGA, C'EST PLUS FORT QUE TOI !");
				  mainAppFX.showOverview("viewer/Overview.fxml");
			  }
		  });		  
      }  
	 
	 // AJOUTER : Methode appelée lorsque l'utilisateur clique sur le boutton d'ajout
	 @FXML
	 private void handleSTART() {
		  if (player.getString("sound").equals("ON")) {
			  sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			  sound.Play();
		  }
		  btnSelected = "SELECT";
	 }
	 
	 //  MODIFIER : Methode appelée lorsque l'utilisateur clique sur le bouton de modification
	 @FXML
	 private void handleSELECT() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		 }
		 btnSelected = "SELECT";
	 }

	 // SUPPRIMER : Methode appelée lorsque l'utilisateur clique sur le bouton de suppression
	 @FXML
	 private void handleCANCEL() {
		  if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		  }
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
	 }		
	 
	 @FXML
	 private void handleDOWN() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
	 }   
	 
	 /**
	 * Appellé par l'application principale pour avoir une référence de retour sur elle-même
	 *
	 * @param mainApp
	 */     
	 public void setMainAppFX(MainAppFX mainApp) {		
			mainAppFX = mainApp; 
	 }
}