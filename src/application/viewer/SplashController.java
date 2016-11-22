package application.viewer;

import application.MainAppFX;
import application.tools.Sound;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.*;
import javafx.scene.media.*;
import javafx.scene.media.MediaPlayer.Status;
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
		private File file = new File("src/res/Oracle.flv");	//src/res/SEGA.mp4
		private String VID_URL = file.toURI().toString();
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
		 @FXML		private HBox mediaBar;
		    
	    // Boutons
		@FXML private Button START, SELECT, CANCEL, SKIP;
		@FXML public static Button ENTER;
		public static String btnSelected = "";	// Permet de determiner le bouton selectionneé pour switchcase
	    
		// EASTER EGG	    
		protected List<String> Combo = new ArrayList<String>();
		@FXML public ImageView imgAnim;

	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appelée après le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
		// CONFIGURATION DES BOUTTONS - TODO police ne possede pas caracteres play pause stop
		 START.setText("⏵ PLAY");
		 START.setFont(MainAppFX.f);
		 SELECT.setText("⏸ PAUSE");
		 SELECT.setFont(MainAppFX.f);
		 CANCEL.setText("⏹ STOP");
		 CANCEL.setFont(MainAppFX.f);		 
		 SKIP.setFont(MainAppFX.f);
		 
		 // Chemin d'accès pour la vidéo d'introduction
		 if (player.getString("intro").isEmpty()) {
			 setVID_URL(file.toURI().toString());
		 } else {
			 if ((player.getString("intro").length() >= 4) && (player.getString("intro").substring(0,4).equals("www."))) {
				 System.out.println("Video via URL : "+player.getString("intro").toString());
				 try {
					 setVID_URL("http://"+player.getString("intro").toString());
				 } catch (IllegalArgumentException e) {
					 setVID_URL(file.toURI().toString());
				 }
			 } else if ( ((player.getString("intro").length() >= 7) && (player.getString("intro").substring(0,7).equals("http://")))
			   || ((player.getString("intro").length() >= 8) &&(player.getString("intro").substring(0,8).equals("https://"))) ) {
				 System.out.println("Video via URL : "+player.getString("intro").toString());
				 try {
					 setVID_URL(player.getString("intro").toString());
				 } catch (IllegalArgumentException e) {
					 setVID_URL(file.toURI().toString());
				 }
			 } else {
				 try {
					 System.out.println("Video via chemin local : "+player.getString("intro").toString());
					 File fichier = new File(player.getString("intro").toString());	
					 setVID_URL(fichier.toURI().toString());				 
				 } catch (IllegalArgumentException e) {
					 setVID_URL(file.toURI().toString());
				 }

			 }
		 }
		 
		 // INITFX
		 initFX();
	 }
	 

	 boolean TEST = false;
	 // AFFICHAGE VIDEO
      public void initFX() {    	    	  
    	  if (VID_URL.equals(null))	{
    		  return;
    	  }
    	  
    	  //if (!TEST) {
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
			  
			  mediaPlayer.setOnPlaying(new Runnable() {
				  @Override public void run() {	 
					  // LISTENERS GERANT LA LECTURE/PAUSE/STOP	  
					  START.setOnAction(new EventHandler<ActionEvent>() {
						    public void handle(ActionEvent e) {
						        Status status = mediaPlayer.getStatus();					   	 
						        if (status == Status.UNKNOWN  || status == Status.HALTED)
						        {
						           // ne rien faire
						           return;
						        }
						 
						          if ( status == Status.PAUSED
						             || status == Status.READY
						             || status == Status.STOPPED)
						          {
						             mediaPlayer.play();
						          } 
						          START.setDisable(true);
						          SELECT.setDisable(false);
						          CANCEL.setDisable(false);
					         }
					   });
					  
					  SELECT.setOnAction(new EventHandler<ActionEvent>() {
						    public void handle(ActionEvent e) {
						        Status status = mediaPlayer.getStatus();					   	 
						        if (status == Status.UNKNOWN  || status == Status.HALTED)
						        {
						           // ne rien faire
						           return;
						        }
						 
						          if ( status != Status.PAUSED
						             && status != Status.READY
						             && status != Status.STOPPED)
						          {					             
						            	 mediaPlayer.pause();
						          }
						          START.setDisable(false);
						          SELECT.setDisable(true);
						          CANCEL.setDisable(false);
					         }
					   });
					  
					  CANCEL.setOnAction(new EventHandler<ActionEvent>() {
						    public void handle(ActionEvent e) {
						        Status status = mediaPlayer.getStatus();
						        if (status == Status.UNKNOWN  || status == Status.HALTED)
						        {
						           // ne rien faire
						           return;
						        } else {
						        	mediaPlayer.stop();	
						        }
						        START.setDisable(false);
						        SELECT.setDisable(true);
						        CANCEL.setDisable(true);
					         }
					   });
				  }
		      }); 
			  
			  mediaPlayer.setOnError(new Runnable() {    
				    @Override
				    public void run() {
				        String message = mediaPlayer.errorProperty().get().getMessage();
				        System.out.println(message);
				    }
				});
			  
			  mediaPlayer.setOnEndOfMedia(new Runnable() {
				  @Override public void run() {
					  skipVideo();
				  }
			  });
      }  
      
      private void skipVideo() {
    	  System.out.println("SEGA, C'EST PLUS FORT QUE TOI !");
		  // PAGE QUI S'OUVRIRA A LA SUITE DE LA VIDEO		  
		  mainAppFX.showOverview("viewer/Machine.fxml");
		  //mainAppFX.showOverview("viewer/Overview.fxml");	//TODO
      }
      
     // SKIP : Methode appelée lorsque l'utilisateur clique sur le boutton pour passer la video
     @FXML
 	 private void handleSKIP() {
 		  if (player.getString("sound").equals("ON")) {
 			  sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
 			  sound.Play();
 		  }
 		  btnSelected = "SKIP";
 		  skipVideo();
 	 }
	 
	 // AJOUTER : Methode appelée lorsque l'utilisateur clique sur le boutton d'ajout
	 @FXML
	 private void handleSTART() {
		  if (player.getString("sound").equals("ON")) {
			  sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			  sound.Play();
		  }
		  btnSelected = "START";
	 }
	 
	 //  MODIFIER : Methode appelée lorsque l'utilisateur clique sur le bouton de modification
	 @FXML
	 private void handleSELECT() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		 }
		 btnSelected = "SELECT";
		 //System.out.println(btnSelected);
	 }

	 // SUPPRIMER : Methode appelée lorsque l'utilisateur clique sur le bouton de suppression
	 @FXML
	 private void handleCANCEL() {
		  if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitENTER.wav");
			 sound.Play();
		  }
		  btnSelected = "CANCEL";
	 } 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 // GAMEPAD
	 @FXML
	 private void handleENTER() {
		 hackCombo();
	 }
	 	 
	 int pressENTER = 0;
	 private void hackCombo() {
		 if (!Combo.isEmpty()) {
			 
			 // AFFICHAGE COMBO
			 System.out.print("[GamePad] > ");
			 for (int i = 0 ; i < Combo.size() ; i++) {
				 System.out.print(Combo.get(i)+" + ");
			 }
			 System.out.println(pressENTER+1 +"x[ENTER]");
			 
			 try {
				// STREET FIGHTERS - Metsu-Hadoken (Ryu)
				 if ((Combo.get(0) == "DOWN") 
				  && (Combo.get(1) == "RIGHT")
				  && (Combo.get(2) == "DOWN") 
				  && (Combo.get(3) == "RIGHT")) {
					 pressENTER++;
					 if (pressENTER >= 3) {
						 hackComboVideo("metsuhadoken.mp4",10000);
						 System.out.println("[CHEATCODE] METSU HADOKEN ! (Ryu - Street Fighters)");
						 pressENTER = 0;
					 }
				 } 
				// STREET FIGHTERS - Hadoken (Ryu)
				 else if ((pressENTER == 0) 
				  && (Combo.get(0) == "DOWN") 
				  && (Combo.get(1) == "RIGHT")) {
					 hackComboSound("../../res/bitHadoken.wav",1300); 
					 //hackComboPicture("Hadoken.gif", 1300);
					 // TODO - IMAGE...
				 } 
				// STREET FIGHTERS - Shoryuken (Ryu)
				 else if ((Combo.get(0) == "RIGHT") 
				  && (Combo.get(1) == "DOWN") 
				  && (Combo.get(2) == "RIGHT")) {
					 hackComboSound("../../res/bitShoryuken.wav",2500); 
				 } 
				// GALAGA - Challenge Completed
				 else if (
				     (Combo.get(0) == "UP") 
				  && (Combo.get(1) == "DOWN") 
				  && (Combo.get(2) == "UP")
				  && (Combo.get(3) == "DOWN")) {
					 hackComboSound("../../res/bitABOUT.wav",6300);
				 } 
				// On nettoie la liste Combo si on foire en appuyant sur ENTER
				 else {
					 if (pressENTER == 0) {
						 Combo.clear();
					 }
				 }
			 } catch (IndexOutOfBoundsException e) {
				 Combo.clear();
			 }
		 }
	 }	 
		 
	 private void hackComboSound(String son, int duree) {
	 
		 SKIP.setDisable(true);
		 START.setDisable(true);
         SELECT.setDisable(true);
         /*
         CANCEL.setDisable(false);
         CANCEL.requestFocus();
         CANCEL.isPressed();
         // TODO - mediaPlayer.stop();          
         */
         CANCEL.setDisable(true);
         sound = new Sound(mainAppFX, son);
         sound.Play();
         new Thread(new Runnable() {
	           @Override
	           public void run() {
					try {
						Thread.sleep(duree);
						START.setDisable(false);
						SKIP.setDisable(false);
						
					} catch (InterruptedException e) {
						e.printStackTrace(); // TODO LOGGER
					}
	           }
		 }).start(); 
         Combo.clear();
	 }
	 
	 private void hackComboVideo(String video, int duree) {
		 
		 SKIP.setDisable(true);
		 START.setDisable(true);
         SELECT.setDisable(true);
         CANCEL.setDisable(true);
         
         File fichier = new File((String) "src/res/"+video);	
		 setVID_URL(fichier.toURI().toString());				 
         initFX();
         
         new Thread(new Runnable() {
	           @Override
	           public void run() {
					try {
						Thread.sleep(duree);
						START.setDisable(false);
						SKIP.setDisable(false);						
					} catch (InterruptedException e) {
						e.printStackTrace(); // TODO LOGGER
					}
	           }
		 }).start(); 
         Combo.clear();
	 }
	 
	 private void hackComboPicture(String imgURL, int duree) {		 
		 String path = "\\bin\\res\\";
	     MainAppFX.explorer(path);
	    	
		 // TODO - Probleme affichage image
		 /*
		 mediaView.setVisible(false);
		 imgAnim.toFront();
		 imgAnim.setVisible(true);
		 System.out.println("IMAGE VIEW");
		 Image imgBG = new Image(imgURL, true);	
		 imgAnim.setImage(imgBG);
		 */
		 
		 if(!true) {
			 SwingUtilities.invokeLater(new Runnable(){
		            public void run(){
		            	//TODO - javax.imageio.IIOException: Can't read input file!
		        	    ImagePanel lol = new ImagePanel();
		        	    lol.Init(lol.createImage(imgURL));
		            }
		      });
		 }
		 
         new Thread(new Runnable() {
	           @Override
	           public void run() {
					try {
						Thread.sleep(duree);						
						if (!imgURL.isEmpty()) {
							imgAnim.setVisible(false);
							mediaView.setVisible(true);
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace(); // TODO LOGGER
					}
	           }
		 }).start(); 
         Combo.clear();
	 }
	 
	 
	 @FXML
	 private void handleLEFT() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 Combo.add("LEFT");
		 // Permet de se deplacer vers la GAUCHE du ButtonBar	
		 switch (btnSelected) {
			 case "START" :
				 if (!SKIP.isDisable()) {
					 SKIP.requestFocus();
					 btnSelected = "CANCEL";
				 }
				 break;	
			 case "SKIP" :
				 if (!CANCEL.isDisable()) {
					 CANCEL.requestFocus();
					 btnSelected = "CANCEL";
				 }
				 break;	
			 case "CANCEL" :
				 if (!SELECT.isDisable()) {
					 SELECT.requestFocus();
					 btnSelected = "SELECT";
				 }
				 break;		
			 case "SELECT" :
			 default :
				if (!START.isDisable()) {
					START.requestFocus();
					btnSelected = "START";
				}
				break;
		 }	 
	 }	 
	 
	 @FXML
	 private void handleRIGHT() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 Combo.add("RIGHT");
		 // Permet de se deplacer vers la DROITE du ButtonBar
		 switch (btnSelected) {
			 case "START" :
				 if (!SELECT.isDisable()) {
					 SELECT.requestFocus();
					 btnSelected = "SELECT";
				 }
				 break;
			 case "SELECT" :
				 if (!CANCEL.isDisable()) {
					 CANCEL.requestFocus();
					 btnSelected = "CANCEL";
				 }
				 break;
			 case "CANCEL" :
				 if (!SKIP.isDisable()) {
					 SKIP.requestFocus();
					 btnSelected = "CANCEL";
				 }
				 break;
			 case "SKIP" :
			 default :
				 if (!START.isDisable()) {
					 START.requestFocus();
					 btnSelected = "START";
				 }
				 break;
		 }		 
	 }
	 
	 @FXML
	 private void handleUP() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 Combo.add("UP");
	 }		
	 
	 @FXML
	 private void handleDOWN() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMOVE.wav");
			 sound.Play();
		 }
		 Combo.add("DOWN");
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