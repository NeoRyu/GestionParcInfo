package application.viewer;

import application.MainAppFX;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {
	 private static MainAppFX mainAppFX;
	
	 public static void setMainApp(MainAppFX mainApp) {
		 mainAppFX = mainApp;
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
		 alert.setTitle("ITpark Manager");
		 alert.setHeaderText("Logiciel de Gestion de Parcs informatique");
		 alert.setContentText("Auteurs : COUPEZ Frédéric, Boris MOTZ, Renaud METZ");
		 alert.showAndWait();
	 }
	
	 @FXML
	 private void handleExit() {
		 System.exit(0);
	 }
}