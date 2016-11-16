package application.viewer;

import java.util.Locale;
import java.util.ResourceBundle;

import application.MainAppFX;
import application.beans.Machine;
import application.tools.Language;
import application.tools.Sound;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
*
* @author Neo_Ryu
*/
public class RootLayoutController {
	 private static MainAppFX mainAppFX;
	 private static Locale lang;
	 private static ResourceBundle rsc;
	 private static String layoutActuel;
	 private Sound sound = new Sound();
	 public static ResourceBundle player = ResourceBundle.getBundle("application.Config");
	
	 public static void setMainApp(MainAppFX mainApp, String choixLayout) {
		 mainAppFX = mainApp;
		 layoutActuel = choixLayout;
		 lang = Language.getLang();
		 rsc = Language.getsetRsc(ResourceBundle.getBundle("application.resources.UIResources", lang));
	 }	 
	 
	 @FXML
	 public void handleLangue() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitLANG.wav");
			 sound.Play();
		 }
		 if (lang.toString().equals("fr_FR")) {			 
			 lang = Language.getsetLang(new Locale("en", "EN"));
		 } else {
			 lang = Language.getsetLang(new Locale("fr", "FR"));			 
		 }
		 mainAppFX.refreshRootLayout(layoutActuel);
		 System.out.println("(RootLayoutController) Langue d�finie sur : "+lang.toString());
	 }
	 
	 @FXML
	 public void handleAccueil() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMENU.wav");
			 sound.Play();
		 }
		 layoutActuel = "viewer/Overview.fxml";
		 mainAppFX.showOverview(layoutActuel);
	 }
	 
	 @FXML
	 public void handleMachine() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMENU.wav");
			 sound.Play();
		 }
		 layoutActuel = "viewer/Machine.fxml";
		 mainAppFX.showOverview(layoutActuel);		 
	 }
	 
	 @FXML
	 public void handleComposant() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitMENU.wav");
			 sound.Play();
		 }
		 layoutActuel = "viewer/Composant.fxml";
		 mainAppFX.showOverview(layoutActuel);		 
	 }
	 
	 @FXML
	 private void handleAbout() {
		 if (player.getString("sound").equals("ON")) {
			 sound = new Sound(mainAppFX, "../../res/bitABOUT.wav");
			 sound.Play();
		 }
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle(rsc.getString("titre"));
		 alert.setHeaderText("Logiciel de Gestion de Parcs informatique");
		 alert.setContentText("Auteurs : COUPEZ Frédéric, Boris MOTZ, Renaud METZ");
		 while(alert.isShowing()) {
			 // TODO STOPPER MUSIQUE		 
		 }
		 alert.showAndWait();
		 
	 }
	 
	 @FXML
	 private void handleExit() {
		if (player.getString("sound").equals("ON")) {
		    sound = new Sound(mainAppFX, "../../res/bitEXIT.wav");	    		
			new Thread(new Runnable() {
		           @Override
		           public void run() {
						try {
							Thread.sleep(5200);
							System.out.println("EXIT");
							System.exit(0);	
						} catch (InterruptedException e) {
							e.printStackTrace(); // TODO LOGGER
						}
		           }
			}).start();	
			sound.Play();
		} else {
			System.out.println("EXIT");
			System.exit(0);	
		}
	 }
}