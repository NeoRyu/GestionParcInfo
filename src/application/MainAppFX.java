package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import application.DAO.objets.*;
import application.modeler.Language;
import application.viewer.OverviewController;
import application.viewer.RootLayoutController;
import application.viewer.MachineController;
import application.viewer.MachineEditDialogController;

/**
 *
 * @author Neo_Ryu
 */
public class MainAppFX extends Application {
	 
    private Stage primaryStage;
    public BorderPane rootLayout;
    private ObservableList<Machine> DataMachine = FXCollections.observableArrayList();
    public static Font f;	// Police d'ecriture
   
    
    public MainAppFX() {   	
    	Platform.runLater(new Runnable() {
    		@Override public void run() {
    			// TODO - JEU D'ESSAI
    			DataMachine.add(new Machine("0","localhost", "localhost", "01/01/2000", "0", "127.0.0.1", "root"));
    			DataMachine.add(new Machine("1","AN2K", "AN2K", "31/12/1999", "0", "2.0.0.0", "Bug"));
    			DataMachine.add(new Machine("2","MAYA", "MAYA", "21/12/2012", "0", "21.12.20.12", "Calendrier"));
    			DataMachine.add(new Machine("3","MIR", "MIR", "11/08/1999", "2", "48.86.2.33", "Station Spatiale"));
    			
    			// TODO - JEU D'ESSAI AVEC COMPOSANTS
    			//DataMachine.add(new Machine("0","localhost", "localhost", "01/01/2000", "0", "127.0.0.1", "root", null));
    			
    			// On récupère d'abord les données a partir du SGBD pour permettre l'affichage
    			getDataMachineDAO();
    		}
    	}); 
    	/*
    	MachineController.ENTER.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
            	 if (keyEvent.getKeyCode() == 20) { // TODO : trouver le code pour touche entrée
	       			 
            	 }
            }
		});
		*/
    	
    }
    
    // Intérrogation du SGBD pour récup les données de type Machine
    public void getDataMachineDAO() {    	
   	 	// TODO - A FAIRE
    }
    
    
    // Récupération des données dans une liste d'objets observables de type Machine
    public ObservableList<Machine> getDataMachine() {
    	 return DataMachine;
    }
    
    
    @Override
    public void start(Stage primaryStage) {
    	
    	// GESTION DE LA LANGUE
    	ResourceBundle language = ResourceBundle.getBundle("application.resources.Lang");
    	Language.setLang(new Locale(language.getString("lang"), language.getString("pays")));
    	System.out.println("(MainAppFX) Langue définie sur : "+Language.getLang().toString());	
    	Language.setRsc(ResourceBundle.getBundle("application.resources.UIResources", Language.getLang()));
    	
    	// GESTION DE LA POLICE D'ECRITURE
    	try { 
    	      f = Font.loadFont(new FileInputStream(new File("src/application/8BIT.TTF")), 12);
    	      //System.out.println(f.getFamily());
    	} catch (FileNotFoundException e) {
    	      e.printStackTrace();
    	}
    	 
    	// TITRE + ICONE
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ITpark Manager");
    	this.primaryStage.getIcons().add(new Image("@../../res/itmp.png"));
    	primaryStage.setResizable(false);
    	primaryStage.setMaxHeight(545);
    	primaryStage.setMaxWidth(575);
        
        // Methode permettant d'appeler le layout d'intro
        String  choixLayout = "viewer/Overview.fxml";
        		choixLayout = "viewer/Machine.fxml";
        
        // On affiche les layouts
        initRootLayout(choixLayout);
        showOverview(choixLayout);        
    }
    
    
    public void initRootLayout(String choixLayout) {
        try {
            // Chargement du layout racine Ã  partir du fichier fxml
        	//ResourceBundle bundle = ResourceBundle.getBundle("/resources/UIResources");
        	
        	
        	ResourceBundle bundle = Language.getsetRsc(ResourceBundle.getBundle("application.resources.UIResources", Language.getLang()));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewer/RootLayout.fxml"), bundle);
            loader.setLocation(MainAppFX.class.getResource("viewer/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            loader.setController(this);
           
            
            // Montrer la scene contenant le layout racine
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().addAll(this.getClass().getResource("viewer/theme_RootLayout.css").toExternalForm());
            primaryStage.setScene(scene);
            
            // Accorder au controller un acces a MainAppFX
            //RootLayoutController controller = loader.getController();
            //controller.setMainApp(this);
            RootLayoutController.setMainApp(this, choixLayout);
            
            // Affichage de la scene dans le stage          
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void refreshRootLayout(String LayoutActuel) {
        try {
            // Chargement du layout racine à partir du fichier fxml

        	Language.setRsc(ResourceBundle.getBundle("application.resources.UIResources", Language.getLang()));
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("viewer/RootLayout.fxml"), Language.getRsc());
            loader.setLocation(MainAppFX.class.getResource("viewer/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();            
            loader.setController(this);
           
            // Montrer la scene contenant le layout racine
            
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().addAll(this.getClass().getResource("viewer/theme_RootLayout.css").toExternalForm());
            primaryStage.setScene(scene);
            
            
            // Accorder au controller un acces a MainAppFX          
            RootLayoutController.setMainApp(this, LayoutActuel);
            showOverview(LayoutActuel);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    public void showOverview(String choixLayout) {
        try {
            // charger l'apercu (overview) fxml 
        	Language.setRsc(ResourceBundle.getBundle("application.resources.UIResources", Language.getLang()));
        	FXMLLoader loader = new FXMLLoader(getClass().getResource(choixLayout), Language.getRsc());
            loader.setLocation(MainAppFX.class.getResource(choixLayout)); 
            AnchorPane overview = (AnchorPane) loader.load();

            // charger cet apercu au centre du layout racine
            rootLayout.setCenter(overview);
                        
            // ajouts des données dans le tableview controller
            switch (choixLayout) {
            	case "viewer/Machine.fxml" : 
            		MachineController machineCtrl = loader.getController();
            		machineCtrl.setMainAppFX(this);
            		break;
            	case "viewer/Overview.fxml" :
            	default :
            		OverviewController overviewCtrl = loader.getController();
            		overviewCtrl.setMainAppFX(this);
            		break;  
            }  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean showMachineEditDialog(Machine machine) {
    	 try {
    		 // Charge le fichier FXML et creation d'un nouveau stage dans une popup
	    	 FXMLLoader loader = new FXMLLoader();
	    	 loader.setLocation(MainAppFX.class.getResource("viewer/MachineEditDialog.fxml"));
	    	 AnchorPane page = (AnchorPane) loader.load();
	    	 
	    	 // Creation du Stage
	    	 Stage dialogStage = new Stage();
	    	 dialogStage.setTitle("ITpark Manager Editor");
	    	 dialogStage.getIcons().add(new Image("@../../res/itmp.png"));
	    	 dialogStage.initModality(Modality.WINDOW_MODAL);
	    	 dialogStage.initOwner(primaryStage);
	    	 Scene scene = new Scene(page);
	    	 dialogStage.setScene(scene);
	    	 
	    	 // Configure l'objet (machine) dans un controlleur
	    	 MachineEditDialogController MachineEDC = loader.getController();
	    	 MachineEDC.setDialogStage(dialogStage);
	    	 MachineEDC.setMachine(machine);
	    	 
	    	 // Montre la popup tant qu'elle n'est pas fermée
	    	 dialogStage.showAndWait();
	    	 return MachineEDC.isOkClic();
    	 } catch (IOException e) {
	    	 e.printStackTrace();
	    	 return false;
    	 }
    }
    
	

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
  
    
    
    // 56 > 62
    // STRING STOCK XML
    // ACCELERATOR MENU
    // MENUBAR > CLIQUABLE
}
