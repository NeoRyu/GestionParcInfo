package application.viewer;

import java.util.Locale;
import java.util.ResourceBundle;

import application.MainAppFX;
import application.modeler.Language;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {
	 private static MainAppFX mainAppFX;
	 private static Locale lang;
	 private static ResourceBundle rsc;
	 private static String LayoutActuel;
	
	 public static void setMainApp(MainAppFX mainApp, String choixLayout) {
		 mainAppFX = mainApp;
		 LayoutActuel = choixLayout;
		 lang = Language.getLang();
		 rsc = Language.getsetRsc(ResourceBundle.getBundle("application.resources.UIResources", lang));
	 }	 
	 
	 @FXML
	 public void handleLangue() {
		 ResourceBundle language = ResourceBundle.getBundle("application.resources.Lang");
		 if (lang.toString().equals("fr_FR")) {			 
			 lang = Language.getsetLang(new Locale("en", "EN"));
		 } else {
			 lang = Language.getsetLang(new Locale("fr", "FR"));			 
		 }
		 mainAppFX.refreshRootLayout(LayoutActuel);
		 System.out.println("(RootLayoutController) Langue définie sur : "+lang.toString());
	 }
	 
	 @FXML
	 public void handleAccueil() {
		 String  choixLayout = "viewer/Overview.fxml";
		 mainAppFX.showOverview(choixLayout);
	 }
	 
	 @FXML
	 public void handleMachine() {
		 String  choixLayout = "viewer/Machine.fxml";
		 mainAppFX.showOverview(choixLayout);		 
	 }
	 
	 @FXML
	 private void handleAbout() {
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle(rsc.getString("titre"));
		 alert.setHeaderText("Logiciel de Gestion de Parcs informatique");
		 alert.setContentText("Auteurs : COUPEZ Frédéric, Boris MOTZ, Renaud METZ");
		 alert.showAndWait();
	 }
	
	 @FXML
	 private void handleExit() {
		 System.exit(0);
	 }
}