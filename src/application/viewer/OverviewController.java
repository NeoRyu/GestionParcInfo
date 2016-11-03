package application.viewer;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.io.IOException;

import com.sun.media.jfxmedia.logging.Logger;

import application.MainAppFX;
import application.DAO.objets.Machine;

import javafx.fxml.FXMLLoader;


public class OverviewController {
		
		@FXML
		private static TableView<Machine> tableFX; 
		@FXML
		private TableColumn<Machine, String> colone;
		@FXML
		private TableColumn<Machine, String> coltwo;
		 
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
		public static MainAppFX mainAppFX;
		public static ObservableList<Machine> liste; 

		/*
		public OverviewController() throws IOException {
			super();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Overview.fxml")); //= new FXMLLoadergetClass().getResource("Overview.fxml");
			loader.setController(new OverviewController());
			Pane mainPane = FXMLLoader.load(getClass().getResource("/Overview.fxml"));
			
		}

		*/
		

	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appel�e apr�s le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
		// Initialise la tableFX avec deux colonnes
		 colone.setCellValueFactory(cellData -> cellData.getValue().idAfpaProperty()); 
		 coltwo.setCellValueFactory(cellData -> cellData.getValue().adresseIPProperty());		 
	}
	 
	 /**
	 * Appell� par l'application principale pour avoir une r�f�rence de retour sur elle-m�me
	 *
	 * @param mainApp
	 */
	 public static void setMainAppFX() {
		 
		 // Ajout de la liste des donn�es observables dans la tableFX	 
		 System.out.println(mainAppFX.getData().get(0).getAdresseIP());
		// TODO : les donn�es marchent mais n'arrivent pas a etre inserees dans le tableview
		
		 tableFX.setItems(mainAppFX.getData()); //TODO gros probleme
		
	 }
	
}