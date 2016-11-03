package application.viewer;

import application.MainAppFX;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;


public class RootLayoutController {
	
	 @FXML
	 private MenuItem MachineLayout;
	
	 private MainAppFX mainApp;

	 public void setMainApp(MainAppFX mainApp) {
	 this.mainApp = mainApp;
	 }
	 

	 
	 /**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	 @FXML
	 private void handleMachineLayout() {    	
		 showOverview("viewer/Machine.fxml");
	 }
	 
	 
	 
	 public void showOverview(String choixLayout) {
	        try {
	        	
	            // charger l'apercu (overview) fxml
	        	FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainAppFX.class.getResource(choixLayout)); 
	            AnchorPane overview = (AnchorPane) loader.load();

	                        
	            // ajouts des données dans le tableview controller
	            OverviewController controller = loader.getController();
	        //    controller.setMainAppFX(this);
	        
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
  
	  
	  /**
	  * Opens an about dialog.
	  */
	  @FXML
	  private void handleAbout() {
	  Alert alert = new Alert(AlertType.INFORMATION);
	  alert.setTitle("AddressApp");
	  alert.setHeaderText("About");
	  alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");
	  alert.showAndWait();
	  }
	  
	  /**
	  * Closes the application.
	  */
	  @FXML
	  private void handleExit() {
	  System.exit(0);
	  }
 }